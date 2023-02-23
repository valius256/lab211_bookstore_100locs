package universitymanagement.view;

import java.util.List;
import universitymanagement.model.UniversityModelInterface;

/**
 * UniversityViewInterface.
 * @author hasu
 * @param <ModelClass>
 */
public interface UniversityViewInterface<ModelClass extends UniversityModelInterface> {

    public void showModel(ModelClass model);

    public void showModel(List<ModelClass> modelList);
}
