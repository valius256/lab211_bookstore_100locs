package universitymanagement.model;

import universitymanagement.main.ModelException;
import universitymanagement.util.Util;

/**
 * Subject model.
 *
 * @author hasu
 */
public class SubjectModel extends UniversityAbstractModel {

    public static final String ID_FORMAT = "SUxxxxxx";
    private static final String ID_PATTERN = "SU\\d{6}";
    public static final int MIN_CREDITS = 1;
    public static final int MAX_CREDITS = 10;

    private int numberOfCredits;

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public final void setNumberOfCredits(int numberOfCredits) {
        if (SubjectModel.MIN_CREDITS <= numberOfCredits && numberOfCredits <= SubjectModel.MAX_CREDITS) {
            this.numberOfCredits = numberOfCredits;
        } else {
            this.numberOfCredits = 0;
        }
    }

    public SubjectModel() {
        this.numberOfCredits = 0;
    }

    public SubjectModel(String id, String name, int numberOfCredits, String description) throws ModelException {
        super(id, name, description);
        setNumberOfCredits(numberOfCredits);
    }

    @Override
    protected boolean validateId(String id) {
        return Util.validateStringPattern(id, SubjectModel.ID_PATTERN, true);
    }

}
