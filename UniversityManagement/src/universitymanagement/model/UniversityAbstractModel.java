package universitymanagement.model;

import universitymanagement.main.ModelException;

/**
 * Abstract class UniversityAbstractModel.
 *
 * @author hasu
 */
public abstract class UniversityAbstractModel implements UniversityModelInterface {

    private String id;
    private String name;
    private String description;

    public String getId() {
        return id;
    }

    public final void setId(String id) throws ModelException {
        if (!validateId(id)) {
            throw new ModelException(id + " does not match the pattern.");
        }
        this.id = id.trim().toUpperCase();
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) throws ModelException {
        if (name == null || name.isBlank()) {
            throw new ModelException("name is blank.");
        }
        this.name = name.trim();
    }

    public String getDescription() {
        return description;
    }

    public final void setDescription(String description) {
        if (description != null && !description.isBlank()) {
            this.description = description;
        } else {
            this.description = "";
        }
    }

    public UniversityAbstractModel() {
        this.id = "";
        this.name = "";
        this.description = "";
    }

    public UniversityAbstractModel(String id, String name, String description) throws ModelException {
        setId(id);
        setName(name);
        setDescription(description);
    }

    public boolean isValid() {
        return validateId(this.id) && !this.name.isBlank();
    }

    protected abstract boolean validateId(String id);

}
