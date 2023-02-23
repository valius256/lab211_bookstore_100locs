package universitymanagement.controller;

import universitymanagement.main.ModelException;
import universitymanagement.model.LearnedSubjectModel;
import universitymanagement.util.Singleton;
import universitymanagement.model.StudentModel;
import universitymanagement.service.StudentService;
import universitymanagement.view.StudentView;

/**
 * Student controller.
 *
 * @author hasu
 */
public class StudentController extends UniversityAbstractController<
        StudentService, StudentView, StudentModel> {

    private StudentController() {
        this.service = Singleton.getInstance(StudentService.class);
        this.view = Singleton.getInstance(StudentView.class);
    }

    @Override
    public StudentModel createNewModel() {
        String id = this.view.getInputId();
        String name = this.view.getInputName();
        String groupId = this.view.getInputGroupId();
        String description = this.view.getInputDescription();
        try {
            return this.service.createModel(id, name, groupId, description);
        } catch (ModelException ex) {
            System.out.println(">>>>> Error: " + ex.getMessage());
//            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean registerGroup() {
        String studentId = this.view.getInputId();
        String groupId = this.view.getInputGroupId();
        return this.service.registerGroup(studentId, groupId);
    }

    public boolean registerSubject(StudentModel studentModel, LearnedSubjectModel learnedSubjectModel) {
        return this.service.registerSubject(studentModel, learnedSubjectModel);
    }

}
