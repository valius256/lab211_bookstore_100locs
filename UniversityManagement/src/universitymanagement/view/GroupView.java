package universitymanagement.view;

import universitymanagement.util.Util;
import universitymanagement.model.GroupModel;
import universitymanagement.model.MajorsModel;
import universitymanagement.model.StudentModel;

/**
 * Group view.
 *
 * @author hasu
 */
public class GroupView extends UniversityAbstractView<GroupModel> {

    private GroupView() {
    }

    public String getInputId() {
        return Util.inputString("Please enter group's id with the pattern(" + GroupModel.ID_FORMAT + ")", true).trim();
    }

    public String getInputName() {
        return Util.inputString("Please enter group's name", false).trim();
    }

    public String getInputDescription() {
        return Util.inputString("Please enter group's description", true).trim();
    }

    public String getInputMajorsId() {
        return Util.inputString("Please enter majorsId's id with the pattern(" + MajorsModel.ID_FORMAT + ")", true).trim();
    }

    public String getInputStudentId() {
        return Util.inputString("Please enter studen's id with the pattern(" + StudentModel.ID_FORMAT + ")", false).trim();
    }

    @Override
    public String toString(GroupModel model) {
        StringBuilder sb = new StringBuilder();
        if (model != null) {
            sb.append("\tGroup {");
            sb.append("\n\t\tId: ");
            sb.append(model.getId());
            sb.append("\n\t\tName: ");
            sb.append(", ");
            sb.append(model.getName());
            sb.append("\n\t\tDescription: ");
            if (model.getDescription() != null) {
                sb.append(model.getDescription());
            }
            sb.append("\n\t\tMajors: ");
            if (model.getMajors() != null) {
                sb.append(", ");
                sb.append(model.getMajors().getName());
            }
            sb.append("\n\t\tStudent: [");
            for (StudentModel studentModel : model.getStudentList()) {
                sb.append(studentModel.getName());
                sb.append(", ");
            }
            sb.append("]\n\t\t}");
        }
        return sb.toString();
    }
}
