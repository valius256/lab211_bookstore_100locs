package universitymanagement.model;

import java.util.ArrayList;
import java.util.List;
import universitymanagement.main.ModelException;
import universitymanagement.util.Util;

/**
 * Faculty model.
 *
 * @author hasu
 */
public class FacultyModel extends UniversityAbstractModel {

    public static final String ID_FORMAT = "FAxxxxxx";
    private static final String ID_PATTERN = "FA\\d{6}";

    private final List<MajorsModel> majorsList;

    public List<MajorsModel> getMajorsList() {
        return majorsList;
    }

    public final void setMajorsList(List<MajorsModel> majorsList) {
        this.majorsList.clear();
        if (majorsList != null) {
            this.majorsList.addAll(majorsList);
        }
    }

    public FacultyModel() {
        this.majorsList = new ArrayList();
    }

    public FacultyModel(String id, String name, String description) throws ModelException {
        super(id, name, description);
        this.majorsList = new ArrayList();
    }

    @Override
    protected boolean validateId(String id) {
        return Util.validateStringPattern(id, FacultyModel.ID_PATTERN, true);
    }

}
