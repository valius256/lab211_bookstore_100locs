package universitymanagement.databaseservice;

import java.util.List;
import universitymanagement.entity.UniversityEntityInterface;

/**
 * Interface UniversityDatabaseServiceInterface.
 *
 * @author hasu
 * @param <EntityClass>
 */
public interface UniversityDatabaseServiceInterface<EntityClass extends UniversityEntityInterface> {

    public List<EntityClass> loadEntitys(Class<EntityClass> clazz);

    public boolean saveEntitys(List<EntityClass> entityLis);

}
