package examinationmanagement.list;

import examinationmanagement.model.User;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hasu
 */
public class UserList extends ObjectList<User> {

    @Override
    public List<User> filter(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<User> filter(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected User parseString(String stringObject) {
        User u = new User();
        u.parseString(stringObject);
        return u;
    }
    
}
