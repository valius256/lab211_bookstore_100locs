package universitymanagement.model;

import java.util.ArrayList;
import java.util.List;
import universitymanagement.main.ModelException;
import universitymanagement.util.Util;

/**
 * Group model.
 *
 * @author hasu
 */
public class GroupModel extends UniversityAbstractModel {

    public static final String ID_FORMAT = "GRxxxxxx";
    private static final String ID_PATTERN = "GR\\d{6}";

    private String majorsId;
    private MajorsModel majors;
    private final List<StudentModel> studentList;

    public String getMajorsId() {
        return majorsId;
    }

    public final void setMajorsId(String majorsId) {
        if (majorsId != null && !majorsId.isBlank()) {
            this.majorsId = majorsId;
        } else {
            this.majorsId = "";
        }
    }

    public MajorsModel getMajors() {
        return majors;
    }

    public final void setMajors(MajorsModel majors) {
        if (majors != null) {
            this.majors = majors;
            this.majorsId = majors.getId();
        } else {
            this.majorsId = "";
        }
    }

    public List<StudentModel> getStudentList() {
        return studentList;
    }

    public final void setStudentList(List<StudentModel> studentList) {
        this.studentList.clear();
        if (studentList != null) {
            this.studentList.addAll(studentList);
        }
    }

    public GroupModel() {
        this.majorsId = "";
        this.studentList = new ArrayList();
    }

    public GroupModel(String id,
            String name,
            String majorsId,
            String description) throws ModelException {
        super(id, name, description);
        setMajorsId(majorsId);
        this.studentList = new ArrayList();
    }

    public boolean registerStudent(StudentModel studentModel) {
        if (!this.studentList.contains(studentModel)) {
            return this.studentList.add(studentModel);
        }
        return false;
    }

    @Override
    protected boolean validateId(String id) {
        return Util.validateStringPattern(id, GroupModel.ID_PATTERN, true);
    }

}
