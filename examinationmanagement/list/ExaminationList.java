package examinationmanagement.list;

import examinationmanagement.model.Examination;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hasu
 */
public class ExaminationList extends ObjectList<Examination> {

    public ExaminationList() {
    }

    public ExaminationList(String filePath) {
        super(filePath);
    }

    @Override
    public List<Examination> filter(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Examination> filter(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected Examination parseString(String stringObject) {
        Examination obj = new Examination();
        obj.parseString(stringObject);
        return obj;
    }

}
