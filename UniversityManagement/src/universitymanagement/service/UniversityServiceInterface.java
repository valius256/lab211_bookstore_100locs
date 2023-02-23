package universitymanagement.service;

import java.util.List;
import universitymanagement.model.UniversityModelInterface;

/**
 * UniversityServiceInterface.
 *
 * @author hasu
 * @param <ModelClass>
 */
public interface UniversityServiceInterface<ModelClass extends UniversityModelInterface> {

    public abstract int loadModels();

    public abstract boolean saveModels();

    public abstract void refresh();

    public boolean add(ModelClass object);

    public ModelClass update(ModelClass object);

    public ModelClass delete(ModelClass object);

    public List<ModelClass> getModelList();

    public ModelClass filterById(String id);

    public List<ModelClass> filterByName(String name);

}
