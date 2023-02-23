package universitymanagement.controller;

import universitymanagement.main.ModelException;
import universitymanagement.util.Singleton;
import universitymanagement.model.SubjectModel;
import universitymanagement.service.SubjectService;
import universitymanagement.view.SubjectView;

/**
 * Subject controller.
 *
 * @author hasu
 */
public class SubjectController extends UniversityAbstractController<
        SubjectService, SubjectView, SubjectModel> {

    private SubjectController() {
        this.service = Singleton.getInstance(SubjectService.class);
        this.view = Singleton.getInstance(SubjectView.class);
    }

    @Override
    public SubjectModel createNewModel() {
        try {
            String id = this.view.getInputId();
            String name = this.view.getInputName();
            int numberOfCredits = this.view.getInputNumberOfCredits();
            String description = this.view.getInputDescription();
            return this.service.createModel(id, name, numberOfCredits, description);
        } catch (ModelException ex) {
            System.out.println(">>>>> Error: " + ex.getMessage());
//            Logger.getLogger(SubjectController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
