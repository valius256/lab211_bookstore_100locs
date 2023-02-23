package universitymanagement.service;

import java.util.List;
import universitymanagement.main.ModelException;
import universitymanagement.databaseservice.StudentDatabaseService;
import universitymanagement.entity.StudentEntity;
import universitymanagement.model.StudentModel;
import universitymanagement.util.Singleton;
import universitymanagement.model.GroupModel;
import universitymanagement.model.LearnedSubjectModel;

/**
 * Student service.
 *
 * @author hasu
 */
public class StudentService extends UniversityAbstractService<StudentModel, StudentEntity> {

    private StudentService() {
        this.dataManagementService = Singleton.getInstance(StudentDatabaseService.class);
    }

    public boolean registerGroup(String studentId, String groupId) {
        StudentModel studentModel = filterById(studentId);
        GroupModel groupModel = Singleton.getInstance(GroupService.class).filterById(groupId);
        if (studentModel != null && groupModel != null) {
            groupModel.registerStudent(studentModel);
            studentModel.setGroup(groupModel);
            return saveModels();
        }
        return false;
    }

    public boolean registerSubject(StudentModel studentModel, LearnedSubjectModel learnedSubjectModel) {
        if (studentModel != null && learnedSubjectModel != null) {
            return studentModel.registerSubject(learnedSubjectModel);
        }
        return false;
    }

    List<StudentModel> filterByGroupId(String groupId) {
        if (groupId != null && !groupId.isBlank()) {
            return this.modelMap.values().stream().filter(obj -> groupId.equalsIgnoreCase(obj.getGroupId())).toList();
        }
        return null;
    }

    public StudentModel createModel(String id, String name, String groupId, String description) throws ModelException {
        if (id != null && name != null) {
            if (filterById(id) == null) {
                return new StudentModel(id, name, groupId, description);
            } else {
                throw new ModelException(id + " already exists.");
            }
        }
        return null;
    }

    @Override
    public int loadModels() {
        return loadEntityFromDatabase(StudentEntity.class);
    }

    @Override
    public boolean saveModels() {
        return saveEntitytoDatabase(StudentEntity.class);
    }

    @Override
    public void refresh() {
        for (StudentModel model : this.modelMap.values()) {
            model.setGroup(Singleton.getInstance(GroupService.class).filterById(model.getGroupId()));
            model.setLearnedSubjectList(Singleton.getInstance(LearnedSubjectService.class).filterByStudentId(model.getId()));
        }
    }

    @Override
    protected StudentEntity toEntity(StudentModel model) {
        StudentEntity entity = null;
        if (model != null) {
            entity = new StudentEntity();
            entity.setId(model.getId());
            entity.setName(model.getName());
            entity.setDescription(model.getDescription());
            entity.setGroupId(model.getGroupId());
        }
        return entity;
    }

    @Override
    protected StudentModel toModel(StudentEntity entity) {
        StudentModel model = null;
        if (entity != null) {
            try {
                model = new StudentModel();
                model.setId(entity.getId());
                model.setName(entity.getName());
                model.setDescription(entity.getDescription());
                model.setGroupId(entity.getGroupId());
                model.setGroup(Singleton.getInstance(GroupService.class).filterById(entity.getGroupId()));
                model.setLearnedSubjectList(Singleton.getInstance(LearnedSubjectService.class).filterByStudentId(model.getId()));
            } catch (ModelException ex) {
                System.out.println(">>>>> Error: " + ex.getMessage());
//                Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return model;
    }

}
