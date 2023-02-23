package examinationmanagement.main;

/**
 * Enum User role.
 *
 * @author hasu
 */
public enum UserRole {
    ADMIN(0),
    DOCTOR(1),
    USER(2),
    INVALID(-1);

    private final int role;

    public static UserRole valueOf(int role) {
        if (role < 0 || role >= UserRole.values().length) {
            return UserRole.INVALID;
        }
        return UserRole.values()[role];
    }

    private UserRole(int role) {
        this.role = role;
    }

    public int intValue() {
        return this.role;
    }
}
