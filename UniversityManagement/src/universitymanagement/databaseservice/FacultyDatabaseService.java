package universitymanagement.databaseservice;

import java.util.List;
import universitymanagement.entity.FacultyEntity;

/**
 * FacultyDatabaseService.
 *
 * @author hasu
 */
public class FacultyDatabaseService extends UniversityAbstractDatabaseService<FacultyEntity> {

    private static final int FACULTY_ENTITY_ATTRIBUTE_COUNT = 3;

    private FacultyDatabaseService() {
        prepareDataFile(getEntityFilePath(FacultyEntity.class));
    }

    @Override
    public List<FacultyEntity> loadEntitys(Class<FacultyEntity> clazz) {
        return loadEntitysFromFile(getEntityFilePath(clazz));
    }

    @Override
    public boolean saveEntitys(List<FacultyEntity> entityLis) {
        if (entityLis != null && !entityLis.isEmpty()) {
            return saveEntitysToFile(getEntityFilePath(entityLis.get(0).getClass()), entityLis);
        }
        return false;
    }

    @Override
    protected String toString(FacultyEntity entity) {
        StringBuilder sb = new StringBuilder();
        sb.append(entity.getId());
        sb.append(UniversityAbstractDatabaseService.SEPARATOR);
        sb.append(entity.getName());
        sb.append(UniversityAbstractDatabaseService.SEPARATOR);
        sb.append(entity.getDescription());
        return sb.toString();
    }

    @Override
    protected FacultyEntity toEntity(String entityString) {
        FacultyEntity facultyEntity = null;
        if (entityString != null) {
            String[] attributes = entityString.split(UniversityAbstractDatabaseService.SEPARATOR, -1);
            if (attributes.length >= FacultyDatabaseService.FACULTY_ENTITY_ATTRIBUTE_COUNT) {
                facultyEntity = new FacultyEntity();
                facultyEntity.setId(attributes[0]);
                facultyEntity.setName(attributes[1]);
                facultyEntity.setDescription(attributes[2]);
            }
        }
        return facultyEntity;
    }

}
