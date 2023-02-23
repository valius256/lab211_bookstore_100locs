package universitymanagement.main;

import universitymanagement.controller.UserController;
import universitymanagement.util.Singleton;
import universitymanagement.util.Util;

/**
 * Menu.
 *
 * @author hasu
 */
public class Menu {

    private final MenuItem[] primaryOptions = {
        MenuItem.FACULTY,
        MenuItem.MAJORS,
        MenuItem.GROUP,
        MenuItem.SUBJECT,
        MenuItem.STUDENT,
        MenuItem.EXIT
    };

    private final MenuItem[] facultyOptions = {
        MenuItem.FACULTY_SHOW_ALL,
        MenuItem.FACULTY_FILTER_BY_ID,
        MenuItem.FACULTY_FILTER_BY_NAME,
        MenuItem.FACULTY_ADD_NEW,
        MenuItem.FACULTY_UPDATE,
        MenuItem.FACULTY_DELETE,
        MenuItem.FACULTY_MAJORS_REGISTER,
        MenuItem.BACK
    };

    private final MenuItem[] majorsOptions = {
        MenuItem.MAJORS_SHOW_ALL,
        MenuItem.MAJORS_FILTER_BY_ID,
        MenuItem.MAJORS_FILTER_BY_NAME,
        MenuItem.MAJORS_ADD_NEW,
        MenuItem.MAJORS_UPDATE,
        MenuItem.MAJORS_DELETE,
        MenuItem.MAJORS_FACULTY_REGISTER,
        MenuItem.BACK
    };

    private final MenuItem[] groupOptions = {
        MenuItem.GROUP_SHOW_ALL,
        MenuItem.GROUP_FILTER_BY_ID,
        MenuItem.GROUP_FILTER_BY_NAME,
        MenuItem.GROUP_ADD_NEW,
        MenuItem.GROUP_UPDATE,
        MenuItem.GROUP_DELETE,
        MenuItem.GROUP_MAJORS_REGISTER,
        MenuItem.GROUP_STUDENT_REGISTER,
        MenuItem.BACK
    };

    private final MenuItem[] subjectOptions = {
        MenuItem.SUBJECT_SHOW_ALL,
        MenuItem.SUBJECT_FILTER_BY_ID,
        MenuItem.SUBJECT_FILTER_BY_NAME,
        MenuItem.SUBJECT_ADD_NEW,
        MenuItem.SUBJECT_UPDATE,
        MenuItem.SUBJECT_DELETE,
        MenuItem.BACK
    };

    private final MenuItem[] studentOptions = {
        MenuItem.STUDENT_SHOW_ALL,
        MenuItem.STUDENT_FILTER_BY_ID,
        MenuItem.STUDENT_FILTER_BY_NAME,
        MenuItem.STUDENT_ADD_NEW,
        MenuItem.STUDENT_UPDATE,
        MenuItem.STUDENT_DELETE,
        MenuItem.STUDENT_GROUP_REGISTER,
        MenuItem.STUDENT_SUBJECT_REGISTER,
        MenuItem.BACK
    };

    private MenuItem primaryOption = null;
    private MenuItem subOption = null;

    public Menu() {
        this.primaryOption = MenuItem.EXIT;
        this.subOption = MenuItem.BACK;
    }

    public MenuItem getUserChoice() {
        do {
            if (subOption == MenuItem.BACK) {
                primaryOption = getChoice(null);
            }
            if (primaryOption != MenuItem.EXIT) {
                subOption = getChoice(primaryOption);
            }
        } while (primaryOption != MenuItem.EXIT && subOption == MenuItem.BACK);
        return primaryOption.equals(MenuItem.EXIT) ? MenuItem.EXIT : subOption;
    }

    private MenuItem getChoice(MenuItem option) {
        MenuItem[] optionList = getOptionList(option);
        String menuCaption;
        if (option == null) {
            menuCaption = "University management:";
        } else {
            menuCaption = option.getLabel();
        }
        int numItems = showOptionMenu(menuCaption, optionList);
        int choice = Util.inputInteger("Please enter your choice", 0, numItems - 1);
        if (choice > 0) {
            UserController userController = Singleton.getInstance(UserController.class);
            for (MenuItem item : optionList) {
                if (userController.checkCurrentUserRole(item.getRole())) {
                    choice--;
                    if (choice == 0) {
                        return item;
                    }
                }
            }
        }
        return optionList[optionList.length - 1];
    }

    private int showOptionMenu(String menuCaption, MenuItem[] optionList) {
        int numItems = 0;
        System.out.println("*********************************************");
        System.out.println(menuCaption);
        UserController userController = Singleton.getInstance(UserController.class);
        for (int i = 0; i < optionList.length; i++) {
            if (userController.checkCurrentUserRole(optionList[i].getRole())) {
                numItems++;
                if (i < optionList.length - 1) {
                    System.out.printf("(%d) -> %s\n", numItems, optionList[i].getLabel());
                } else {
                    System.out.printf("(0) -> %s\n", optionList[i].getLabel());
                }
            }
        }
        System.out.println("*********************************************");
        return numItems;

    }

    private MenuItem[] getOptionList(MenuItem option) {
        MenuItem[] optionList;
        if (option == null) {
            optionList = primaryOptions;
        } else {
            optionList = switch (option) {
                case FACULTY ->
                    facultyOptions;
                case MAJORS ->
                    majorsOptions;
                case GROUP ->
                    groupOptions;
                case SUBJECT ->
                    subjectOptions;
                case STUDENT ->
                    studentOptions;
                default ->
                    primaryOptions;
            };
        }
        return optionList;
    }
}
