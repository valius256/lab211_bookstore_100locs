package universitymanagement.controller;

import universitymanagement.model.UserModel;
import universitymanagement.main.UserRole;
import universitymanagement.service.UserService;
import universitymanagement.util.Singleton;
import universitymanagement.view.UserView;

/**
 *
 * @author hasu
 */
public class UserController extends UniversityAbstractController<UserService, UserView, UserModel> {

    private UserController() {
        this.service = Singleton.getInstance(UserService.class);
        this.view = Singleton.getInstance(UserView.class);
    }

    public boolean login() {
        String id = this.view.getInputId();
        String password = this.view.getInputPassword();
        if (this.service.login(id, password)) {
            this.view.showModel(this.service.getCurrentUser());
            return true;
        }
        return false;
    }

    public boolean checkCurrentUserRole(UserRole role) {
        return this.service.checkCurrentUserRole(role);
    }

    @Override
    public UserModel createNewModel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
