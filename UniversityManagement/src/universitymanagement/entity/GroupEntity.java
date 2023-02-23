package universitymanagement.entity;

/**
 * Group entity.
 *
 * @author hasu
 */
public class GroupEntity extends UniversityAbstractEntity {

    private String majorsId;

    public String getMajorsId() {
        return majorsId;
    }

    public void setMajorsId(String majorsId) {
        this.majorsId = majorsId;
    }

    public GroupEntity() {
        this.majorsId = "";
    }
}
