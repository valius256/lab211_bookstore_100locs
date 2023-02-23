package universitymanagement.view;

import java.util.List;
import universitymanagement.model.UniversityModelInterface;

/**
 * UniversityAbstrac.
 *
 * @param <ModelClass>
 */
public abstract class UniversityAbstractView<ModelClass extends UniversityModelInterface>
        implements UniversityViewInterface<ModelClass> {

    public void showModel(ModelClass model) {
        System.out.println(toString(model));
    }

    public void showModel(List<ModelClass> modelList) {
        if (modelList != null) {
            System.out.println("Model list:");
            int idx = 0;
            for (ModelClass model : modelList) {
                System.out.print(++idx + ".");
                showModel(model);
            }
        }
    }

    public abstract String toString(ModelClass model);
}
