package universitymanagement.model;

import universitymanagement.main.UserRole;
import universitymanagement.main.ModelException;

/**
 * User model.
 *
 * @author hasu
 */
public class UserModel extends UniversityAbstractModel {

    private String password;
    private UserRole role;

    public String getPassword() {
        return password;
    }

    public final void setPassword(String password) {
        if (password != null && !password.isBlank()) {
            this.password = password;
        } else {
            this.password = "";
        }
    }

    public UserRole getRole() {
        return role;
    }

    public final void setRole(UserRole role) {
        this.role = role;
    }

    public UserModel() {
        this.password = "";
        this.role = UserRole.INVALID;
    }

    public UserModel(String id, String password, UserRole role) throws ModelException {
        setId(id);
        setPassword(password);
        setRole(role);
    }

    public int compareTo(UserRole role) {
        return this.role.intValue() - role.intValue();
    }

    public boolean checkRole(UserRole role) {
        return compareTo(role) <= 0;
    }

    @Override
    protected boolean validateId(String id) {
        return id != null && !id.isBlank();
    }

}
