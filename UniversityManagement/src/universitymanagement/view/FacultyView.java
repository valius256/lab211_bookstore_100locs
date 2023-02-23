package universitymanagement.view;

import universitymanagement.util.Util;
import universitymanagement.model.FacultyModel;
import universitymanagement.model.MajorsModel;

/**
 * Faculty view.
 *
 * @author hasu
 */
public class FacultyView extends UniversityAbstractView<FacultyModel> {

    private FacultyView() {
    }

    public String getInputId() {
        return Util.inputString("Please enter faculty's id with the pattern(" + FacultyModel.ID_FORMAT + ")", false).trim();
    }

    public String getInputName() {
        return Util.inputString("Please enter faculty's name", false).trim();
    }

    public String getInputDescription() {
        return Util.inputString("Please enter faculty's description", true).trim();
    }

    @Override
    public String toString(FacultyModel model) {
        StringBuilder sb = new StringBuilder();
        if (model != null) {
            sb.append("\tFaculty {");
            sb.append("\n\t\tId: ");
            sb.append(model.getId());
            sb.append("\n\t\tName: ");
            sb.append(model.getName());
            sb.append("\n\t\tDescription: ");
            if (model.getDescription() != null) {
                sb.append(model.getDescription());
            }
            sb.append("\n\t\tMajors: [");
            for (MajorsModel majorsModel : model.getMajorsList()) {
                sb.append(majorsModel.getName());
                sb.append(", ");
            }
            sb.append("]\n\t}");
        }
        return sb.toString();
    }

}
