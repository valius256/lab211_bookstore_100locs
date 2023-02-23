package universitymanagement.entity;

/**
 * Subject entity.
 *
 * @author hasu
 */
public class SubjectEntity extends UniversityAbstractEntity {

    private int numberOfCredits;

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public SubjectEntity() {
        this.numberOfCredits = Integer.MIN_VALUE;
    }
    
}
