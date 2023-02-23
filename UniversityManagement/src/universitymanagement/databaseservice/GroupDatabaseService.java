package universitymanagement.databaseservice;

import java.util.List;
import universitymanagement.entity.GroupEntity;

/**
 * GroupDatabaseService.
 *
 * @author hasu
 */
public class GroupDatabaseService extends UniversityAbstractDatabaseService<GroupEntity> {

    private static final int GROUP_ENTITY_ATTRIBUTE_COUNT = 4;

    private GroupDatabaseService() {
        prepareDataFile(getEntityFilePath(GroupEntity.class));
    }

    @Override
    public List<GroupEntity> loadEntitys(Class<GroupEntity> clazz) {
        return loadEntitysFromFile(getEntityFilePath(clazz));
    }

    @Override
    public boolean saveEntitys(List<GroupEntity> entityLis) {
        if (entityLis != null && !entityLis.isEmpty()) {
            return saveEntitysToFile(getEntityFilePath(entityLis.get(0).getClass()), entityLis);
        }
        return false;
    }

    @Override
    protected String toString(GroupEntity entity) {
        StringBuilder sb = new StringBuilder();
        sb.append(entity.getId());
        sb.append(UniversityAbstractDatabaseService.SEPARATOR);
        sb.append(entity.getName());
        sb.append(UniversityAbstractDatabaseService.SEPARATOR);
        sb.append(entity.getMajorsId());
        sb.append(UniversityAbstractDatabaseService.SEPARATOR);
        sb.append(entity.getDescription());
        return sb.toString();
    }

    @Override
    protected GroupEntity toEntity(String entityString) {
        GroupEntity groupEntity = null;
        if (entityString != null) {
            String[] attributes = entityString.split(UniversityAbstractDatabaseService.SEPARATOR, -1);
            if (attributes.length >= GroupDatabaseService.GROUP_ENTITY_ATTRIBUTE_COUNT) {
                groupEntity = new GroupEntity();
                groupEntity.setId(attributes[0]);
                groupEntity.setName(attributes[1]);
                groupEntity.setMajorsId(attributes[2]);
                groupEntity.setDescription(attributes[3]);
            }
        }
        return groupEntity;
    }

}
