package universitymanagement.databaseservice;

import java.util.List;
import universitymanagement.entity.StudentEntity;

/**
 * StudentDatabaseService.
 *
 * @author hasu
 */
public class StudentDatabaseService extends UniversityAbstractDatabaseService<StudentEntity> {

    private static final int STUDENT_ENTITY_ATTRIBUTE_COUNT = 4;

    private StudentDatabaseService() {
        prepareDataFile(getEntityFilePath(StudentEntity.class));
    }

    @Override
    public List<StudentEntity> loadEntitys(Class<StudentEntity> clazz) {
        return loadEntitysFromFile(getEntityFilePath(clazz));
    }

    @Override
    public boolean saveEntitys(List<StudentEntity> entityLis) {
        if (entityLis != null && !entityLis.isEmpty()) {
            return saveEntitysToFile(getEntityFilePath(entityLis.get(0).getClass()), entityLis);
        }
        return false;
    }

    @Override
    protected String toString(StudentEntity entity) {
        StringBuilder sb = new StringBuilder();
        sb.append(entity.getId());
        sb.append(UniversityAbstractDatabaseService.SEPARATOR);
        sb.append(entity.getName());
        sb.append(UniversityAbstractDatabaseService.SEPARATOR);
        sb.append(entity.getGroupId());
        sb.append(UniversityAbstractDatabaseService.SEPARATOR);
        sb.append(entity.getDescription());
        return sb.toString();
    }

    @Override
    protected StudentEntity toEntity(String entityString) {
        StudentEntity studentEntity = null;
        if (entityString != null) {
            String[] attributes = entityString.split(UniversityAbstractDatabaseService.SEPARATOR, -1);
            if (attributes.length >= StudentDatabaseService.STUDENT_ENTITY_ATTRIBUTE_COUNT) {
                studentEntity = new StudentEntity();
                studentEntity.setId(attributes[0]);
                studentEntity.setName(attributes[1]);
                studentEntity.setGroupId(attributes[2]);
                studentEntity.setDescription(attributes[3]);
            }
        }
        return studentEntity;
    }
}
