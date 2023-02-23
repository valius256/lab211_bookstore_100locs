package universitymanagement.controller;

import universitymanagement.main.ModelException;
import universitymanagement.util.Singleton;
import universitymanagement.model.MajorsModel;
import universitymanagement.service.MajorsService;
import universitymanagement.view.MajorsView;

/**
 * Majors controller.
 *
 * @author hasu
 */
public class MajorsController extends UniversityAbstractController<
        MajorsService, MajorsView, MajorsModel> {

    private MajorsController() {
        this.service = Singleton.getInstance(MajorsService.class);
        this.view = Singleton.getInstance(MajorsView.class);
    }

    @Override
    public MajorsModel createNewModel() {
        try {
            String id = this.view.getInputId();
            String name = this.view.getInputName();
            String facultyId = this.view.getInputFacultyId();
            String description = this.view.getInputDescription();
            return this.service.createModel(id, name, facultyId, description);
        } catch (ModelException ex) {
            System.out.println(">>>>> Error: " + ex.getMessage());
//            Logger.getLogger(MajorsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
