package universitymanagement.service;

import java.util.List;
import universitymanagement.main.ModelException;
import universitymanagement.databaseservice.LearnedSubjecDatabaseService;
import universitymanagement.util.Singleton;
import universitymanagement.entity.LearnedSubjectEntity;
import universitymanagement.model.LearnedSubjectModel;
import universitymanagement.model.StudentModel;
import universitymanagement.model.SubjectModel;

/**
 * Learned subject service.
 *
 * @author hasu
 */
public class LearnedSubjectService extends UniversityAbstractService<LearnedSubjectModel, LearnedSubjectEntity> {

    private LearnedSubjectService() {
        this.dataManagementService = Singleton.getInstance(LearnedSubjecDatabaseService.class);
    }

    public LearnedSubjectModel register(StudentModel studentModel, SubjectModel subjectModel, int semester, String description) {
        LearnedSubjectModel learnedSubjectModel = createModel(studentModel, subjectModel, semester, description);
        if (learnedSubjectModel != null) {
            if (add(learnedSubjectModel)) {
                return learnedSubjectModel;
            }
        }
        return null;
    }

    public LearnedSubjectModel createModel(StudentModel studentModel, SubjectModel subjectModel, int semester, String description) {
        if (studentModel != null && subjectModel != null) {
            return new LearnedSubjectModel(studentModel, subjectModel, semester, description);
        }
        return null;
    }

    public List<LearnedSubjectModel> filterByStudentId(String studentId) {
        if (studentId != null && !studentId.isBlank()) {
            return this.modelMap.values().stream().filter(obj -> studentId.equalsIgnoreCase(obj.getStudentId())).toList();
        }
        return null;
    }

    public List<LearnedSubjectModel> filterBySubjectId(String subjectId) {
        if (subjectId != null && !subjectId.isBlank()) {
            return this.modelMap.values().stream().filter(obj -> subjectId.equalsIgnoreCase(obj.getSubjectId())).toList();
        }
        return null;
    }

    public int loadModels() {
        return loadEntityFromDatabase(LearnedSubjectEntity.class);
    }

    public boolean saveModels() {
        return saveEntitytoDatabase(LearnedSubjectEntity.class);
    }

    @Override
    public void refresh() {
        for (LearnedSubjectModel model : this.modelMap.values()) {
            model.setStudent(Singleton.getInstance(StudentService.class).filterById(model.getStudentId()));
            model.setSubject(Singleton.getInstance(SubjectService.class).filterById(model.getSubjectId()));
        }
    }

    @Override
    protected LearnedSubjectEntity toEntity(LearnedSubjectModel model) {
        LearnedSubjectEntity entity = null;
        if (model != null) {
            entity = new LearnedSubjectEntity();
            entity.setStudentId(model.getStudentId());
            entity.setSubjectId(model.getSubjectId());
            entity.setSemester(model.getSemester());
            entity.setScore(model.getScore());
            entity.setDescription(model.getDescription());
        }
        return entity;
    }

    @Override
    protected LearnedSubjectModel toModel(LearnedSubjectEntity entity) {
        LearnedSubjectModel model = null;
        if (entity != null) {
            try {
                model = new LearnedSubjectModel();
                model.setStudentId(entity.getStudentId());
                model.setSubjectId(entity.getSubjectId());
                model.setSemester(entity.getSemester());
                model.setScore(entity.getScore());
                model.setDescription(entity.getDescription());
                model.setStudent(Singleton.getInstance(StudentService.class).filterById(entity.getStudentId()));
                model.setSubject(Singleton.getInstance(SubjectService.class).filterById(entity.getSubjectId()));
            } catch (ModelException ex) {
                System.out.println(">>>>> Error: " + ex.getMessage());
//                Logger.getLogger(LearnedSubjectService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return model;
    }

}
