package universitymanagement.view;

import universitymanagement.model.SubjectModel;
import universitymanagement.util.Util;

/**
 * SubjectView.
 *
 * @author hasu
 */
public class SubjectView extends UniversityAbstractView<SubjectModel> {

    private SubjectView() {
    }

    public String getInputId() {
        return Util.inputString("Please enter subject's id with the pattern(" + SubjectModel.ID_FORMAT + ")", false).trim();
    }

    public String getInputName() {
        return Util.inputString("Please enter subject's name", false).trim();
    }

    public String getInputDescription() {
        return Util.inputString("Please enter subject's description", true).trim();
    }

    public int getInputNumberOfCredits() {
        return Util.inputInteger("Please enter number of credits", SubjectModel.MIN_CREDITS, SubjectModel.MAX_CREDITS);
    }

    @Override
    public String toString(SubjectModel model) {
        StringBuilder sb = new StringBuilder();
        if (model != null) {
            sb.append("\tSubject {");
            sb.append("\n\t\tId: ");
            sb.append(model.getId());
            sb.append("\n\t\tName: ");
            sb.append(model.getName());
            sb.append("\n\t\tNumberOfCredits: ");
            sb.append(model.getNumberOfCredits());
            sb.append("\n\t\tDescription: ");
            if (model.getDescription() != null) {
                sb.append(model.getDescription());
            }
            sb.append("\n\t}");
        }
        return sb.toString();
    }
}
