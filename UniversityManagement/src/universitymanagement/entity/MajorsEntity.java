package universitymanagement.entity;

/**
 * Majors entity.
 *
 * @author hasu
 */
public class MajorsEntity extends UniversityAbstractEntity {

    private String facultyId;

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public MajorsEntity() {
        this.facultyId = "";
    }

}
