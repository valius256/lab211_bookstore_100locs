package universitymanagement.main;

import universitymanagement.util.Singleton;
import universitymanagement.controller.FacultyController;
import universitymanagement.controller.GroupController;
import universitymanagement.controller.LearnedSubjectController;
import universitymanagement.controller.MajorsController;
import universitymanagement.controller.StudentController;
import universitymanagement.controller.SubjectController;
import universitymanagement.controller.UserController;
import universitymanagement.model.FacultyModel;
import universitymanagement.model.GroupModel;
import universitymanagement.model.MajorsModel;
import universitymanagement.model.StudentModel;
import universitymanagement.model.SubjectModel;

/**
 * University management.
 *
 * @author hasu
 */
public class UniversityManagement {

    private UserController userController;
    private FacultyController facultyController;
    private MajorsController majorsController;
    private GroupController groupController;
    private StudentController studentController;
    private SubjectController subjectController;
    private LearnedSubjectController learnedSubjectController;

    private UniversityManagement() {
    }

    private void prepareData() {
        this.userController = Singleton.getInstance(UserController.class);
        this.facultyController = Singleton.getInstance(FacultyController.class);
        this.majorsController = Singleton.getInstance(MajorsController.class);
        this.groupController = Singleton.getInstance(GroupController.class);
        this.studentController = Singleton.getInstance(StudentController.class);
        this.subjectController = Singleton.getInstance(SubjectController.class);
        this.learnedSubjectController = Singleton.getInstance(LearnedSubjectController.class);

        this.facultyController.loadModels();
        this.majorsController.loadModels();
        this.groupController.loadModels();
        this.studentController.loadModels();
        this.subjectController.loadModels();
        this.learnedSubjectController.loadModels();

        this.facultyController.refresh();
        this.majorsController.refresh();
        this.groupController.refresh();
        this.studentController.refresh();
        this.subjectController.refresh();
        this.learnedSubjectController.refresh();
    }

    private void showAllFaculty() {
        if (this.userController.checkCurrentUserRole(UserRole.USER)) {
            this.facultyController.showAll();
        } else {
            System.out.println("???");
        }
    }

    private void filterFacultyById() {
        System.out.println("filterFacultyById ...");
    }

    private void filterFacultyByName() {
        System.out.println("filterFacultyByName ...");
    }

    private void addNewFaculty() {
        if (this.userController.checkCurrentUserRole(UserRole.ADMIN)) {
            FacultyModel model = this.facultyController.addNewModel();
            if (model != null) {
                System.out.println("Success!");
                this.facultyController.showModel(model);
            } else {
                System.out.println("Failed!");
            }
        } else {
            System.out.println("???");
        }
    }

    private void updateFaculty() {
        System.out.println("updateFaculty ...");
    }

    private void deleteFaculty() {
        System.out.println("deleteFaculty ...");
    }

    private void facultyRegisterMajors() {
        System.out.println("facultyRegisterMajors ...");
    }

    private void showAllMajors() {
        if (this.userController.checkCurrentUserRole(UserRole.USER)) {
            this.majorsController.showAll();
        } else {
            System.out.println("???");
        }
    }

    private void filterMajorsById() {
        System.out.println("filterMajorsById ...");
    }

    private void filterMajorsByName() {
        System.out.println("filterMajorsByName ...");
    }

    private void addNewMajors() {
        if (this.userController.checkCurrentUserRole(UserRole.ADMIN)) {
            MajorsModel model = this.majorsController.addNewModel();
            if (model != null) {
                System.out.println("Success!");
                this.majorsController.showModel(model);
            } else {
                System.out.println("Failed!");
            }
        } else {
            System.out.println("???");
        }
    }

    private void updateMajors() {
        System.out.println("updateMajors ...");
    }

    private void deleteMajors() {
        System.out.println("deleteMajors ...");
    }

    private void majorsRegisterFaculty() {
        System.out.println("majorsRegisterFaculty ...");
    }

    private void showAllGroup() {
        if (this.userController.checkCurrentUserRole(UserRole.USER)) {
            this.groupController.showAll();
        } else {
            System.out.println("???");
        }
    }

    private void filterGroupById() {
        System.out.println("filterGroupById ...");
    }

    private void filterGroupByName() {
        System.out.println("filterGroupByName ...");
    }

    private void addNewGroup() {
        if (this.userController.checkCurrentUserRole(UserRole.ADMIN)) {
            GroupModel model = this.groupController.addNewModel();
            if (model != null) {
                System.out.println("Success!");
                this.groupController.showModel(model);
            } else {
                System.out.println("Failed!");
            }
        } else {
            System.out.println("???");
        }
    }

    private void updateGroup() {
        System.out.println("updateGroup ...");
    }

    private void deleteGroup() {
        System.out.println("deleteGroup ...");
    }

    private void groupRegisterMajors() {
        System.out.println("groupRegisterMajors ...");
    }

    private void groupRegisterStudent() {
        if (this.userController.checkCurrentUserRole(UserRole.ADMIN)) {
            if (this.groupController.registerStudent()) {
                System.out.println("Successful!");
            } else {
                System.out.println("Failed!");
            }
        } else {
            System.out.println("???");
        }
    }

    private void showAllStudent() {
        if (this.userController.checkCurrentUserRole(UserRole.USER)) {
            this.studentController.showAll();
        } else {
            System.out.println("???");
        }
    }

    private void filterStudentById() {
        System.out.println("filterStudentById ...");
    }

    private void filterStudentByName() {
        System.out.println("filterStudentByName ...");
    }

    private void addNewStudent() {
        if (this.userController.checkCurrentUserRole(UserRole.ADMIN)) {
            StudentModel model = this.studentController.addNewModel();
            if (model != null) {
                System.out.println("Success!");
                this.studentController.showModel(model);
            } else {
                System.out.println("Failed!");
            }
        } else {
            System.out.println("???");
        }
    }

    private void updateStudent() {
        System.out.println("updateStudent ...");
    }

    private void deleteStudent() {
        System.out.println("deleteStudent ...");
    }

    private void studentRegisterGroup() {
        if (this.userController.checkCurrentUserRole(UserRole.ADMIN)) {
            if (this.studentController.registerGroup()) {
                System.out.println("Successful!");
            } else {
                System.out.println("Failed!");
            }
        } else {
            System.out.println("???");
        }
    }

    private void studentRegisterSubject() {
        if (this.userController.checkCurrentUserRole(UserRole.ADMIN)) {
            if (this.learnedSubjectController.register()) {
                System.out.println("Successful!");
            } else {
                System.out.println("Failed!");
            }
        } else {
            System.out.println("???");
        }
    }

    private void showAllSubject() {
        if (this.userController.checkCurrentUserRole(UserRole.USER)) {
            this.subjectController.showAll();
        } else {
            System.out.println("???");
        }
    }

    private void filterSubjectById() {
        System.out.println("filterSubjectById ...");
    }

    private void filterSubjectByName() {
        System.out.println("filterSubjectByName ...");
    }

    private void addNewSubject() {
        if (this.userController.checkCurrentUserRole(UserRole.ADMIN)) {
            SubjectModel model = this.subjectController.addNewModel();
            if (model != null) {
                System.out.println("Success!");
                this.subjectController.showModel(model);
            } else {
                System.out.println("Failed!");
            }
        } else {
            System.out.println("???");
        }
    }

    private void updateSubject() {
        System.out.println("updateSubject ...");
    }

    private void deleteSubject() {
        System.out.println("deleteSubject ...");
    }

    private void run() {
        Menu menu = new Menu();
        MenuItem userChoice;
        do {
            userChoice = menu.getUserChoice();
            switch (userChoice) {
                case FACULTY_SHOW_ALL ->
                    showAllFaculty();
                case FACULTY_FILTER_BY_ID ->
                    filterFacultyById();
                case FACULTY_FILTER_BY_NAME ->
                    filterFacultyByName();
                case FACULTY_ADD_NEW ->
                    addNewFaculty();
                case FACULTY_UPDATE ->
                    updateFaculty();
                case FACULTY_DELETE ->
                    deleteFaculty();
                case FACULTY_MAJORS_REGISTER ->
                    facultyRegisterMajors();
                case MAJORS_SHOW_ALL ->
                    showAllMajors();
                case MAJORS_FILTER_BY_ID ->
                    filterMajorsById();
                case MAJORS_FILTER_BY_NAME ->
                    filterMajorsByName();
                case MAJORS_ADD_NEW ->
                    addNewMajors();
                case MAJORS_UPDATE ->
                    updateMajors();
                case MAJORS_DELETE ->
                    deleteMajors();
                case MAJORS_FACULTY_REGISTER ->
                    majorsRegisterFaculty();
                case GROUP_SHOW_ALL ->
                    showAllGroup();
                case GROUP_FILTER_BY_ID ->
                    filterGroupById();
                case GROUP_FILTER_BY_NAME ->
                    filterGroupByName();
                case GROUP_ADD_NEW ->
                    addNewGroup();
                case GROUP_UPDATE ->
                    updateGroup();
                case GROUP_DELETE ->
                    deleteGroup();
                case GROUP_MAJORS_REGISTER ->
                    groupRegisterMajors();
                case GROUP_STUDENT_REGISTER ->
                    groupRegisterStudent();
                case SUBJECT_SHOW_ALL ->
                    showAllSubject();
                case SUBJECT_FILTER_BY_ID ->
                    filterSubjectById();
                case SUBJECT_FILTER_BY_NAME ->
                    filterSubjectByName();
                case SUBJECT_ADD_NEW ->
                    addNewSubject();
                case SUBJECT_UPDATE ->
                    updateSubject();
                case SUBJECT_DELETE ->
                    deleteSubject();
                case STUDENT_SHOW_ALL ->
                    showAllStudent();
                case STUDENT_FILTER_BY_ID ->
                    filterStudentById();
                case STUDENT_FILTER_BY_NAME ->
                    filterStudentByName();
                case STUDENT_ADD_NEW ->
                    addNewStudent();
                case STUDENT_UPDATE ->
                    updateStudent();
                case STUDENT_DELETE ->
                    deleteStudent();
                case STUDENT_GROUP_REGISTER ->
                    studentRegisterGroup();
                case STUDENT_SUBJECT_REGISTER ->
                    studentRegisterSubject();
                case EXIT -> {
                    System.out.println("Exited!");
                }
                default ->
                    System.out.println("???");
            }
        } while (userChoice != MenuItem.EXIT);
    }

    private void start() {
        System.out.println("University management");
        System.out.println("Login ...");
        if (Singleton.getInstance(UserController.class).login()) {
            prepareData();
            run();
        } else {
            System.out.println("Login failed!");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new UniversityManagement().start();
    }

}
