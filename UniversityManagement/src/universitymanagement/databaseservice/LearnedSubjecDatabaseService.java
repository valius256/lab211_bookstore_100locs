package universitymanagement.databaseservice;

import java.util.List;
import universitymanagement.entity.LearnedSubjectEntity;

/**
 * LearnedSubjecDataServic.e
 *
 * @author hasu
 */
public class LearnedSubjecDatabaseService extends UniversityAbstractDatabaseService<LearnedSubjectEntity> {

    private static final int LEARNEDSUBJECT_ENTITY_ATTRIBUTE_COUNT = 5;

    private LearnedSubjecDatabaseService() {
        prepareDataFile(getEntityFilePath(LearnedSubjectEntity.class));
    }

    @Override
    public List<LearnedSubjectEntity> loadEntitys(Class<LearnedSubjectEntity> clazz) {
        return loadEntitysFromFile(getEntityFilePath(clazz));
    }

    @Override
    public boolean saveEntitys(List<LearnedSubjectEntity> entityLis) {
        if (entityLis != null && !entityLis.isEmpty()) {
            return saveEntitysToFile(getEntityFilePath(entityLis.get(0).getClass()), entityLis);
        }
        return false;
    }

    @Override
    protected String toString(LearnedSubjectEntity entity) {
        StringBuilder sb = new StringBuilder();
        sb.append(entity.getStudentId());
        sb.append(UniversityAbstractDatabaseService.SEPARATOR);
        sb.append(entity.getSubjectId());
        sb.append(UniversityAbstractDatabaseService.SEPARATOR);
        sb.append(entity.getSemester());
        sb.append(UniversityAbstractDatabaseService.SEPARATOR);
        sb.append(entity.getScore());
        sb.append(UniversityAbstractDatabaseService.SEPARATOR);
        sb.append(entity.getDescription());
        return sb.toString();
    }

    @Override
    protected LearnedSubjectEntity toEntity(String entityString) {
        LearnedSubjectEntity learnedSubjectEntity = null;
        if (entityString != null) {
            String[] attributes = entityString.split(UniversityAbstractDatabaseService.SEPARATOR, -1);
            if (attributes.length >= LearnedSubjecDatabaseService.LEARNEDSUBJECT_ENTITY_ATTRIBUTE_COUNT) {
                learnedSubjectEntity = new LearnedSubjectEntity();
                learnedSubjectEntity.setStudentId(attributes[0]);
                learnedSubjectEntity.setSubjectId(attributes[1]);
                try {
                    learnedSubjectEntity.setSemester(Integer.parseInt(attributes[2]));
                    learnedSubjectEntity.setScore(Float.parseFloat(attributes[3]));
                } catch (NumberFormatException ex) {
                    System.out.println(">>>>> Error: " + ex.getMessage());
//                    Logger.getLogger(UniversityAbstractService.class.getName()).log(Level.SEVERE, null, ex);
                }
                learnedSubjectEntity.setDescription(attributes[3]);
            }
        }
        return learnedSubjectEntity;
    }
}
