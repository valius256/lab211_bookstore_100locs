package universitymanagement.model;

import java.util.ArrayList;
import java.util.List;
import universitymanagement.main.ModelException;
import universitymanagement.util.Util;

/**
 * Majors model.
 *
 * @author hasu
 */
public class MajorsModel extends UniversityAbstractModel {

    public static final String ID_FORMAT = "MAxxxxxx";
    private static final String ID_PATTERN = "MA\\d{6}";

    private String facultyId;
    private FacultyModel faculty;
    private final List<GroupModel> groupList;

    public String getFacultyId() {
        return facultyId;
    }

    public final void setFacultyId(String facultyId) {
        if (facultyId != null && !facultyId.isBlank()) {
            this.facultyId = facultyId;
        } else {
            this.facultyId = "";
        }
    }

    public FacultyModel getFaculty() {
        return faculty;
    }

    public final void setFaculty(FacultyModel facultyModel) {
        if (facultyModel != null) {
            this.faculty = facultyModel;
            this.facultyId = facultyModel.getId();
        } else {
            this.facultyId = "";
        }
    }

    public List<GroupModel> getGroupList() {
        return groupList;
    }

    public final void setGroupList(List<GroupModel> groupList) {
        this.groupList.clear();
        if (groupList != null) {
            this.groupList.addAll(groupList);
        }
    }

    public MajorsModel() {
        this.facultyId = "";
        this.groupList = new ArrayList();
    }

    public MajorsModel(
            String id,
            String name,
            String facultyId,
            String description) throws ModelException {
        super(id, name, description);
        setFacultyId(facultyId);
        this.groupList = new ArrayList();
    }

    @Override
    protected boolean validateId(String id) {
        return Util.validateStringPattern(id, MajorsModel.ID_PATTERN, true);
    }

}
