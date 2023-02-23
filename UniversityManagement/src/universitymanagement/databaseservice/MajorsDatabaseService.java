package universitymanagement.databaseservice;

import java.util.List;
import universitymanagement.entity.MajorsEntity;

/**
 * MajorsDatabaseService.
 *
 * @author hasu
 */
public class MajorsDatabaseService extends UniversityAbstractDatabaseService<MajorsEntity> {

    private static final int MAJORS_ENTITY_ATTRIBUTE_COUNT = 4;

    private MajorsDatabaseService() {
        prepareDataFile(getEntityFilePath(MajorsEntity.class));
    }

    @Override
    public List<MajorsEntity> loadEntitys(Class<MajorsEntity> clazz) {
        return loadEntitysFromFile(getEntityFilePath(clazz));
    }

    @Override
    public boolean saveEntitys(List<MajorsEntity> entityLis) {
        if (entityLis != null && !entityLis.isEmpty()) {
            return saveEntitysToFile(getEntityFilePath(entityLis.get(0).getClass()), entityLis);
        }
        return false;
    }

    @Override
    protected String toString(MajorsEntity entity) {
        StringBuilder sb = new StringBuilder();
        sb.append(entity.getId());
        sb.append(UniversityAbstractDatabaseService.SEPARATOR);
        sb.append(entity.getName());
        sb.append(UniversityAbstractDatabaseService.SEPARATOR);
        sb.append(entity.getFacultyId());
        sb.append(UniversityAbstractDatabaseService.SEPARATOR);
        sb.append(entity.getDescription());
        return sb.toString();
    }

    @Override
    protected MajorsEntity toEntity(String entityString) {
        MajorsEntity majorsEntity = null;
        if (entityString != null) {
            String[] attributes = entityString.split(UniversityAbstractDatabaseService.SEPARATOR, -1);
            if (attributes.length >= MajorsDatabaseService.MAJORS_ENTITY_ATTRIBUTE_COUNT) {
                majorsEntity = new MajorsEntity();
                majorsEntity.setId(attributes[0]);
                majorsEntity.setName(attributes[1]);
                majorsEntity.setFacultyId(attributes[2]);
                majorsEntity.setDescription(attributes[3]);
            }
        }
        return majorsEntity;
    }

}
