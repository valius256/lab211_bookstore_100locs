package universitymanagement.controller;

import java.util.List;
import universitymanagement.model.UniversityModelInterface;

/**
 * Interface UniversityControllerInterface.
 *
 * @author hasu
 * @param <ModelClass>
 */
public interface UniversityControllerInterface<ModelClass extends UniversityModelInterface> {

    public void loadModels();

    public void refresh();

    public void showAll();

    public void showModel(ModelClass model);

    public ModelClass createNewModel();

    public ModelClass addNewModel();

    public ModelClass filterById(String id);

    public List<ModelClass> filterByName(String name);
}
