package examinationmanagement.main;

import examinationmanagement.model.User;
import examinationmanagement.service.UserManagetment;
import examinationmanagement.util.Util;

/**
 *
 * @author hasu
 */
public class Menu {

    private final MenuItem[] primaryOptions = {
        MenuItem.DEPARTMENT,
        MenuItem.DOCTOR,
        MenuItem.PATIENT,
        MenuItem.EXAMINATION,
        MenuItem.EXIT
    };

    private final MenuItem[] departmentOptions = {
        MenuItem.DEPARTMENT_SHOW_ALL,
        MenuItem.DEPARTMENT_FILTER_BY_ID,
        MenuItem.DEPARTMENT_FILTER_BY_NAME,
        MenuItem.DEPARTMENT_ADD_NEW,
        MenuItem.DEPARTMENT_UPDATE,
        MenuItem.DEPARTMENT_DELETE,
        MenuItem.BACK
    };

    private final MenuItem[] doctorOptions = {
        MenuItem.DOCTOR_SHOW_ALL,
        MenuItem.DOCTOR_FILTER_BY_ID,
        MenuItem.DOCTOR_FILTER_BY_NAME,
        MenuItem.DOCTOR_FILTER_BY_DEPARTMENT_ID,
        MenuItem.DOCTOR_ADD_NEW,
        MenuItem.DOCTOR_UPDATE,
        MenuItem.DOCTOR_DELETE,
        MenuItem.BACK
    };

    private final MenuItem[] patientOptions = {
        MenuItem.PATIENT_SHOW_ALL,
        MenuItem.PATIENT_FILTER_BY_ID,
        MenuItem.PATIENT_FILTER_BY_NAME,
        MenuItem.PATIENT_ADD_NEW,
        MenuItem.PATIENT_UPDATE,
        MenuItem.PATIENT_DELETE,
        MenuItem.BACK
    };

    private final MenuItem[] examanitionOptions = {
        MenuItem.EXAMINATION_SHOW_ALL,
        MenuItem.EXAMINATION_FILTER_BY_ID,
        MenuItem.EXAMINATION_FILTER_BY_DOCTOR_ID,
        MenuItem.EXAMINATION_FILTER_BY_PATIENT_ID,
        MenuItem.EXAMINATION_FILTER_BY_DATE,
        MenuItem.EXAMINATION_ADD_NEW,
        MenuItem.EXAMINATION_UPDATE,
        MenuItem.EXAMINATION_DELETE,
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
            User currentUser = UserManagetment.getInstance().getCurrentUser();
            for (MenuItem item : optionList) {
                if (currentUser.checkRole(item.getRole())) {
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
        User currentUser = UserManagetment.getInstance().getCurrentUser();
        for (int i = 0; i < optionList.length; i++) {
            if (currentUser.checkRole(optionList[i].getRole())) {
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
                case DEPARTMENT ->
                    departmentOptions;
                case DOCTOR ->
                    doctorOptions;
                case PATIENT ->
                    patientOptions;
                case EXAMINATION ->
                    examanitionOptions;
                default ->
                    primaryOptions;
            };
        }
        return optionList;
    }
}
