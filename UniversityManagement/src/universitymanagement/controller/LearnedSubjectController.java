package universitymanagement.controller;

import universitymanagement.util.Singleton;
import universitymanagement.model.LearnedSubjectModel;
import universitymanagement.model.StudentModel;
import universitymanagement.model.SubjectModel;
import universitymanagement.service.LearnedSubjectService;
import universitymanagement.view.LearnedSubjectView;

/**
 * Learned subject controller.
 *
 * @author hasu
 */
public class LearnedSubjectController extends UniversityAbstractController<
        LearnedSubjectService, LearnedSubjectView, LearnedSubjectModel> {

    private LearnedSubjectController() {
        this.service = Singleton.getInstance(LearnedSubjectService.class);
        this.view = Singleton.getInstance(LearnedSubjectView.class);
    }

    @Override
    public LearnedSubjectModel createNewModel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean register() {
        String studentId = this.view.getInputStudentId();
        String subjectId = this.view.getInputSubjectId();
        int semester = this.view.getInputSemester();
        String description = this.view.getInputDescription();
        StudentModel student = Singleton.getInstance(StudentController.class).filterById(studentId);
        SubjectModel subject = Singleton.getInstance(SubjectController.class).filterById(subjectId);
        LearnedSubjectModel learnedSubject =  this.service.register(student, subject, semester, description);
        if (learnedSubject != null) {
            return Singleton.getInstance(StudentController.class).registerSubject(student, learnedSubject);
        }
        return false;
    }
}
