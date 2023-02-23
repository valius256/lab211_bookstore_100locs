package universitymanagement.view;

import universitymanagement.model.UserModel;
import universitymanagement.util.Util;

/**
 * UserView.
 *
 * @author hasu
 */
public class UserView extends UniversityAbstractView<UserModel> {

    private UserView() {
    }

    public String getInputId() {
        return Util.inputString("Please enter user's id", false).trim();
    }

    public String getInputPassword() {
        return Util.inputString("Please enter user's password", false).trim();
    }

    @Override
    public String toString(UserModel model) {
        StringBuilder sb = new StringBuilder();
        if (model != null) {
            sb.append("\tUser {");
            sb.append("\n\t\tName: ");
            sb.append(model.getName());
            sb.append("\n\t\tRole: ");
            sb.append(model.getRole());
            sb.append("\n\t\tDescription: ");
            if (model.getDescription() != null) {
                sb.append(model.getDescription());
            }
            sb.append("\n\t}");
        }
        return sb.toString();
    }

}
