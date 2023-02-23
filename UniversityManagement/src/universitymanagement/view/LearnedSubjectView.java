package universitymanagement.view;

import universitymanagement.model.LearnedSubjectModel;
import universitymanagement.model.StudentModel;
import universitymanagement.model.SubjectModel;
import universitymanagement.util.Util;

/**
 *
 * @author hasu
 */
public class LearnedSubjectView extends UniversityAbstractView<LearnedSubjectModel> {

    private LearnedSubjectView() {
    }

    public String getInputStudentId() {
        return Util.inputString("Please enter studen's id with the pattern(" + StudentModel.ID_FORMAT + ")", false).trim();
    }

    public String getInputSubjectId() {
        return Util.inputString("Please enter subject's id with the pattern(" + SubjectModel.ID_FORMAT + ")", false).trim();
    }

    public int getInputSemester() {
        return Util.inputInteger("Please enter semester", LearnedSubjectModel.MIN_SEMESTER, LearnedSubjectModel.MAX_SEMESTER);
    }

    public String getInputDescription() {
        return Util.inputString("Please enter description", true).trim();
    }

    @Override
    public String toString(LearnedSubjectModel model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
