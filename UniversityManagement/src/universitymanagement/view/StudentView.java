package universitymanagement.view;

import universitymanagement.util.Util;
import universitymanagement.model.GroupModel;
import universitymanagement.model.LearnedSubjectModel;
import universitymanagement.model.StudentModel;

/**
 * Student view.
 *
 * @author hasu
 */
public class StudentView extends UniversityAbstractView<StudentModel> {

    private StudentView() {
    }

    public String getInputId() {
        return Util.inputString("Please enter studen's id with the pattern(" + StudentModel.ID_FORMAT + ")", false).trim();
    }

    public String getInputName() {
        return Util.inputString("Please enter studen's name", false).trim();
    }

    public String getInputDescription() {
        return Util.inputString("Please enter studen's description", true).trim();
    }

    public String getInputGroupId() {
        return Util.inputString("Please enter group's id with the pattern(" + GroupModel.ID_FORMAT + ")", true).trim();
    }

    @Override
    public String toString(StudentModel model) {
        StringBuilder sb = new StringBuilder();
        if (model != null) {
            sb.append("\tStudent {");
            sb.append("\n\t\tId: ");
            sb.append(model.getId());
            sb.append("\n\t\tName: ");
            sb.append(model.getName());
            sb.append("\n\t\tDescription: ");
            if (model.getDescription() != null) {
                sb.append(model.getDescription());
            }
            sb.append("\n\t\tGroup: ");
            if (model.getGroup() != null) {
                sb.append(model.getGroup().getName());
            }
            sb.append("\n\t\tLearnedSubject: [");
            for (LearnedSubjectModel learnedSubjectModel : model.getLearnedSubjectList()) {
                sb.append("\n\t\t\t{");
                sb.append("Subject: ");
                if (learnedSubjectModel.getSubject() != null) {
                    sb.append(learnedSubjectModel.getSubject().getName());
                }
                sb.append(", Semester: ");
                sb.append(learnedSubjectModel.getSemester());
                sb.append(", Score: ");
                if (!Float.isNaN(learnedSubjectModel.getScore())) {
                    sb.append(learnedSubjectModel.getScore());
                }
                sb.append("}");
            }
            sb.append(" ]\n\t\t}");
        }
        return sb.toString();
    }

}
