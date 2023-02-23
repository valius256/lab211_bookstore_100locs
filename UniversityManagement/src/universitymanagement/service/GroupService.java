qqqqq111111111111111111111111111111111111111111111package universitymanagement.service;

import java.util.List;
import universitymanagement.main.ModelException;
import universitymanagement.databaseservice.GroupDatabaseService;
import universitymanagement.util.Singleton;
import universitymanagement.entity.GroupEntity;
import universitymanagement.model.GroupModel;
import universitymanagement.model.StudentModel;

/**
 * Group service.
 *
 * @author hasu
 */
public class GroupService extends UniversityAbstractService<GroupModel, GroupEntity> {

    private GroupService() {
        this.dataManagementService = Singleton.getInstance(GroupDatabaseService.class);
    }

    public GroupModel createModel(String id, String name, String majorsId, String description) throws ModelException {
        if (id != null && name != null) {
            if (filterById(id) == null) {
                return new GroupModel(id, name, majorsId, description);
            } else {
                throw new ModelException(id + " already exists.");
            }
        }
        return null;
    }

    public List<GroupModel> filterByMajorsId(String majorsId) {
        if (majorsId != null && !majorsId.isBlank()) {
            return this.modelMap.values().stream().filter(obj -> majorsId.equalsIgnoreCase(obj.getMajorsId())).toList();
        }
        return null;
    }

    public boolean registerStudent(String groupId, String studentId) {
        GroupModel groupModel = filterById(groupId);
        StudentService studentService = Singleton.getInstance(StudentService.class);
        StudentModel studentModel = studentService.filterById(studentId);
        if (groupModel != null && studentModel != null) {
            groupModel.registerStudent(studentModel);
            studentModel.setGroup(groupModel);
            return studentService.saveModels();
        }
        return false;
    }

    @Override
    public int loadModels() {
        return loadEntityFromDatabase(GroupEntity.class);
    }

    @Override
    public boolean saveModels() {
        return saveEntitytoDatabase(GroupEntity.class);
    }

    @Override
    public void refresh() {
        MajorsService majorsService = Singleton.getInstance(MajorsService.class);
        StudentService studentService = Singleton.getInstance(StudentService.class);
        for (GroupModel model : this.modelMap.values()) {
            model.setMajors(majorsService.filterById(model.getMajorsId()));
            model.setStudentList(studentService.filterByGroupId(model.getId()));
        }
    }

    @Override
    protected GroupEntity toEntity(GroupModel model) {
        GroupEntity entity = null;
        if (model != null) {
            entity = new GroupEntity();
            entity.setId(model.getId());
            entity.setName(model.getName());
            entity.setDescription(model.getDescription());
            entity.setMajorsId(model.getMajorsId());
        }
        return entity;
    }

    @Override
    protected GroupModel toModel(GroupEntity entity) {
        GroupModel model = null;
        if (entity != null) {
            try {
                model = new GroupModel();
                model.setId(entity.getId());
                model.setName(entity.getName());
                model.setDescription(entity.getDescription());
                model.setMajorsId(entity.getMajorsId());
                model.setMajors(Singleton.getInstance(MajorsService.class).filterById(entity.getMajorsId()));
                model.setStudentList(Singleton.getInstance(StudentService.class).filterByGroupId(entity.getId()));
            } catch (ModelException ex) {
                System.out.println(">>>>> Error: " + ex.getMessage());
//                Logger.getLogger(GroupService.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return model;
    }

}
