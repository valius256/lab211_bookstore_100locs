package universitymanagement.databaseservice;

import java.util.List;
import universitymanagement.entity.SubjectEntity;

/**
 * SubjectDatabaseService.
 *
 * @author hasu
 */
public class SubjectDatabaseService extends UniversityAbstractDatabaseService<SubjectEntity> {

    private static final int SUBJECT_ENTITY_ATTRIBUTE_COUNT = 4;

    private SubjectDatabaseService() {
        prepareDataFile(getEntityFilePath(SubjectEntity.class));
    }

    @Override
    public List<SubjectEntity> loadEntitys(Class<SubjectEntity> clazz) {
        return loadEntitysFromFile(getEntityFilePath(clazz));
    }

    @Override
    public boolean saveEntitys(List<SubjectEntity> entityLis) {
        if (entityLis != null && !entityLis.isEmpty()) {
            return saveEntitysToFile(getEntityFilePath(entityLis.get(0).getClass()), entityLis);
        }
        return false;
    }

    @Override
    protected String toString(SubjectEntity entity) {
        StringBuilder sb = new StringBuilder();
        sb.append(entity.getId());
        sb.append(UniversityAbstractDatabaseService.SEPARATOR);
        sb.append(entity.getName());
        sb.append(UniversityAbstractDatabaseService.SEPARATOR);
        sb.append(entity.getNumberOfCredits());
        sb.append(UniversityAbstractDatabaseService.SEPARATOR);
        sb.append(entity.getDescription());
        return sb.toString();
    }

    @Override
    protected SubjectEntity toEntity(String entityString) {
        SubjectEntity subjectEntity = null;
        if (entityString != null) {
            String[] attributes = entityString.split(UniversityAbstractDatabaseService.SEPARATOR, -1);
            if (attributes.length >= SubjectDatabaseService.SUBJECT_ENTITY_ATTRIBUTE_COUNT) {
                subjectEntity = new SubjectEntity();
                subjectEntity.setId(attributes[0]);
                subjectEntity.setName(attributes[1]);
                try {
                    subjectEntity.setNumberOfCredits(Integer.parseInt(attributes[2]));
                } catch (NumberFormatException ex) {
                    System.out.println(">>>>> Error: " + ex.getMessage());
//                    Logger.getLogger(UniversityAbstractService.class.getName()).log(Level.SEVERE, null, ex);
                }
                subjectEntity.setDescription(attributes[3]);
            }
        }
        return subjectEntity;
    }
}
