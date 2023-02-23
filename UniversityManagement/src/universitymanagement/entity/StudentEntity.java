package universitymanagement.entity;

/**
 * Student entity.
 *
 * @author hasu
 */
public class StudentEntity extends UniversityAbstractEntity {

    private String groupId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public StudentEntity() {
        this.groupId = "";
    }

}
