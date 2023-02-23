package universitymanagement.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import universitymanagement.main.ModelException;
import universitymanagement.util.Singleton;
import universitymanagement.model.GroupModel;
import universitymanagement.service.GroupService;
import universitymanagement.view.GroupView;

/**
 * Group controller.
 *
 * @author hasu
 */
public class GroupController extends UniversityAbstractController<GroupService, GroupView, GroupModel> {

    private GroupController() {
        this.service = Singleton.getInstance(GroupService.class);
        this.view = Singleton.getInstance(GroupView.class);
    }

    @Override
    public GroupModel createNewModel() {
        try {
            String id = this.view.getInputId();
            String name = this.view.getInputName();
            String majorsId = this.view.getInputMajorsId();
            String description = this.view.getInputDescription();
            return this.service.createModel(id, name, majorsId,description);
        } catch (ModelException ex) {
            System.out.println(">>>>> Error: " + ex.getMessage());
//            Logger.getLogger(GroupController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean registerStudent() {
        String groupId = this.view.getInputId();
        String studentId = this.view.getInputStudentId();
        return this.service.registerStudent(groupId, studentId);
    }

}
