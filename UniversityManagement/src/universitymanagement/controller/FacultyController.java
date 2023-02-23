package universitymanagement.controller;

import universitymanagement.main.ModelException;
import universitymanagement.util.Singleton;
import universitymanagement.model.FacultyModel;
import universitymanagement.service.FacultyService;
import universitymanagement.view.FacultyView;

/**
 * Faculty controller.
 *
 * @author hasu
 */
public class FacultyController extends UniversityAbstractController<FacultyService, FacultyView, FacultyModel> {

    private FacultyController() {
        this.service = Singleton.getInstance(FacultyService.class);
        this.view = Singleton.getInstance(FacultyView.class);
    }

    @Override
    public FacultyModel createNewModel() {
        try {
            String id = this.view.getInputId();
            String name = this.view.getInputName();
            String description = this.view.getInputDescription();
            return this.service.createModel(id, name, description);
        } catch (ModelException ex) {
            System.out.println(">>>>> Error: " + ex.getMessage());
//            Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}