package universitymanagement.main;

/**
 * Menu item.
 *
 * @author hasu
 */
public enum MenuItem {
    BACK("Back", UserRole.USER),
    EXIT("Exit", UserRole.USER),
    FACULTY("Faculty management", UserRole.USER),
    FACULTY_SHOW_ALL("Show all", UserRole.USER),
    FACULTY_FILTER_BY_ID("Filter by id", UserRole.USER),
    FACULTY_FILTER_BY_NAME("Filter by name", UserRole.USER),
    FACULTY_ADD_NEW("Add new", UserRole.ADMIN),
    FACULTY_UPDATE("Update", UserRole.ADMIN),
    FACULTY_DELETE("Delete", UserRole.ADMIN),
    FACULTY_MAJORS_REGISTER("Register majors", UserRole.ADMIN),
    MAJORS("Majors management", UserRole.USER),
    MAJORS_SHOW_ALL("Show all", UserRole.USER),
    MAJORS_FILTER_BY_ID("Filter by id", UserRole.USER),
    MAJORS_FILTER_BY_NAME("Filter by name", UserRole.USER),
    MAJORS_ADD_NEW("Add new", UserRole.ADMIN),
    MAJORS_UPDATE("Update", UserRole.ADMIN),
    MAJORS_DELETE("Delete", UserRole.ADMIN),
    MAJORS_FACULTY_REGISTER("Register faculty", UserRole.ADMIN),
    GROUP("Group management", UserRole.USER),
    GROUP_SHOW_ALL("Show all", UserRole.USER),
    GROUP_FILTER_BY_ID("Filter by id", UserRole.USER),
    GROUP_FILTER_BY_NAME("Filter by name", UserRole.USER),
    GROUP_ADD_NEW("Add new", UserRole.ADMIN),
    GROUP_UPDATE("Update", UserRole.ADMIN),
    GROUP_DELETE("Delete", UserRole.ADMIN),
    GROUP_MAJORS_REGISTER("Register faculty", UserRole.ADMIN),
    GROUP_STUDENT_REGISTER("Register student", UserRole.ADMIN),
    SUBJECT("Subject management", UserRole.USER),
    SUBJECT_SHOW_ALL("Show all", UserRole.USER),
    SUBJECT_FILTER_BY_ID("Filter by id", UserRole.USER),
    SUBJECT_FILTER_BY_NAME("Filter by name", UserRole.USER),
    SUBJECT_ADD_NEW("Add new", UserRole.ADMIN),
    SUBJECT_UPDATE("Update", UserRole.ADMIN),
    SUBJECT_DELETE("Delete", UserRole.ADMIN),
    STUDENT("Student management", UserRole.USER),
    STUDENT_SHOW_ALL("Show all", UserRole.USER),
    STUDENT_FILTER_BY_ID("Filter by id", UserRole.USER),
    STUDENT_FILTER_BY_NAME("Filter by name  ", UserRole.USER),
    STUDENT_ADD_NEW("Add new", UserRole.ADMIN),
    STUDENT_UPDATE("Update", UserRole.ADMIN),
    STUDENT_DELETE("Delete", UserRole.ADMIN),
    STUDENT_GROUP_REGISTER("Register group", UserRole.ADMIN),
    STUDENT_SUBJECT_REGISTER("Register subject", UserRole.ADMIN);

    private final String label;
    private final UserRole role;

    public String getLabel() {
        return label;
    }

    public UserRole getRole() {
        return role;
    }

    private MenuItem(String label, UserRole role) {
        this.label = label;
        this.role = role;
    }

}
