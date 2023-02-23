package universitymanagement.view;

import universitymanagement.model.FacultyModel;
import universitymanagement.model.GroupModel;
import universitymanagement.model.MajorsModel;
import universitymanagement.util.Util;

/**
 * Majors view.
 *
 * @author hasu
 */
public class MajorsView extends UniversityAbstractView<MajorsModel> {

    private MajorsView() {
    }

    public String getInputId() {
        return Util.inputString("Please enter majors's id with the pattern(" + MajorsModel.ID_FORMAT + ")", false).trim();
    }

    public String getInputName() {
        return Util.inputString("Please enter majors's name", false).trim();
    }

    public String getInputDescription() {
        return Util.inputString("Please enter majors's description", true).trim();
    }

    public String getInputFacultyId() {
        return Util.inputString("Please enter faculty's id with the pattern(" + FacultyModel.ID_FORMAT + ")", true).trim();
    }

    @Override
    public String toString(MajorsModel model) {
        StringBuilder sb = new StringBuilder();
        if (model != null) {
            sb.append("\tMajors {");
            sb.append("\n\t\tId: ");
            sb.append(model.getId());
            sb.append("\n\t\tName: ");
            sb.append(model.getName());
            sb.append("\n\t\tDescription: ");
            if (model.getDescription() != null) {
                sb.append(model.getDescription());
            }
            sb.append("\n\t\tFaculty: ");
            if (model.getFaculty() != null) {
                sb.append(model.getFaculty().getName());
            }
            sb.append("\n\t\tGroup: [");
            for (GroupModel groupModel : model.getGroupList()) {
                sb.append(groupModel.getName());
                sb.append(", ");
            }
            sb.append("]\n\t\t}");
        }
        return sb.toString();
    }

}
