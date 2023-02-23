package universitymanagement.entity;

/**
 * Abstract class UniversityAbstractEntity.
 *
 * @author hasu
 */
public abstract class UniversityAbstractEntity implements UniversityEntityInterface {

    protected String id;
    protected String name;
    protected String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UniversityAbstractEntity() {
        this.id = "";
        this.name = "";
        this.description = "";
    }

}
