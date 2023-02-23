package examinationmanagement.main;

/**
 *
 * @author hasu
 */
public enum MenuItem {
    EXIT("Exit", UserRole.USER),
    BACK("Back", UserRole.USER),
    
    DEPARTMENT("Department", UserRole.USER),
    DEPARTMENT_SHOW_ALL("Show all", UserRole.USER),
    DEPARTMENT_FILTER_BY_ID("Filter by id", UserRole.USER),
    DEPARTMENT_FILTER_BY_NAME("Filter by name", UserRole.USER),
    DEPARTMENT_ADD_NEW("Add new", UserRole.ADMIN),
    DEPARTMENT_UPDATE("Update", UserRole.ADMIN),
    DEPARTMENT_DELETE("Delete", UserRole.ADMIN),
    
    DOCTOR("Doctor", UserRole.USER),
    DOCTOR_SHOW_ALL("Show all", UserRole.USER),
    DOCTOR_FILTER_BY_ID("Filter by id", UserRole.USER),
    DOCTOR_FILTER_BY_NAME("Filter by name", UserRole.USER),
    DOCTOR_FILTER_BY_DEPARTMENT_ID("Filter by department", UserRole.USER),
    DOCTOR_ADD_NEW("Add new", UserRole.ADMIN),
    DOCTOR_UPDATE("Update", UserRole.ADMIN),
    DOCTOR_DELETE("Delete", UserRole.ADMIN),
    
    PATIENT("Patient", UserRole.USER),
    PATIENT_SHOW_ALL("Show all", UserRole.USER),
    PATIENT_FILTER_BY_ID("Filter by id", UserRole.USER),
    PATIENT_FILTER_BY_NAME("Filter by name", UserRole.USER),
    PATIENT_ADD_NEW("Add new", UserRole.ADMIN),
    PATIENT_UPDATE("Update", UserRole.ADMIN),
    PATIENT_DELETE("Delete", UserRole.ADMIN),
    
    EXAMINATION("Examination", UserRole.USER),
    EXAMINATION_SHOW_ALL("Show all", UserRole.USER),
    EXAMINATION_FILTER_BY_ID("Filter by id", UserRole.USER),
    EXAMINATION_FILTER_BY_DOCTOR_ID("Filter by doctor's id", UserRole.USER),
    EXAMINATION_FILTER_BY_PATIENT_ID("Filter by patient's id", UserRole.USER),
    EXAMINATION_FILTER_BY_DATE("Filter by date", UserRole.USER),
    EXAMINATION_ADD_NEW("Add new", UserRole.ADMIN),
    EXAMINATION_UPDATE("Update", UserRole.ADMIN),
    EXAMINATION_DELETE("Delete", UserRole.ADMIN);

    private final UserRole role;
    private final String label;

    public UserRole getRole() {
        return role;
    }

    public String getLabel() {
        return label;
    }

    private MenuItem(String label, UserRole role) {
        this.role = role;
        this.label = label;
    }

}
