package examinationmanagement.util;

import examinationmanagement.model.Department;
import examinationmanagement.model.Doctor;
import examinationmanagement.model.Examination;
import examinationmanagement.model.Patient;
import examinationmanagement.main.ExaminationManagement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class util
 *
 * @author hasu
 */
public final class Util {

    public static final String SEPARATOR = ",";
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final String IGNORE_CASE_PATTERN = "(?i)";

    private Util() {
    }

    public static int inputInteger(String message, int minValue, int maxValue) {
        int val = minValue - 1;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(message + ": ");
            try {
                val = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (val < minValue || maxValue < val);
        return val;
    }

    public static String inputString(String message) {
        String inputString;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(message + ": ");
            inputString = sc.nextLine();
        } while (inputString.isBlank());
        return inputString;
    }

    public static Date toDate(String strDate) throws ParseException {
        if (strDate == null) {
            return null;
        }
        SimpleDateFormat df = new SimpleDateFormat(Util.DATE_FORMAT);
        df.setLenient(false);
        return df.parse(strDate);
    }

    public static String toString(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat df = new SimpleDateFormat(Util.DATE_FORMAT);
        return df.format(date);
    }

    public static Date inputDate(String message) {
        Scanner sc = new Scanner(System.in);
        Date date = null;
        do {
            System.out.print(message + "(" + Util.DATE_FORMAT + "): ");
            try {
                date = toDate(sc.nextLine());
            } catch (ParseException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (date == null);
        return date;
    }

    public static boolean inputBoolean(String message) {
        System.out.print(message + "(" + Boolean.TRUE.toString() + "/" + Boolean.FALSE.toString() + "): ");
        Scanner sc = new Scanner(System.in);
        return Boolean.parseBoolean(sc.nextLine());
    }

    public static boolean validateString(String str, String regex, boolean ignoreCase) {
        if (str != null && regex != null) {
            if (ignoreCase) {
                regex = Util.IGNORE_CASE_PATTERN + regex;
            }
            return str.matches(regex);
        }
        return false;
    }

    public static boolean validateDate(Date createDate, Date lastUpdateDate) {
        Date now = new Date();
        if (createDate == null) {
            return lastUpdateDate != null && !lastUpdateDate.after(now);
        } else if (lastUpdateDate == null) {
            return !createDate.after(now);
        }
        return !createDate.after(lastUpdateDate) && !lastUpdateDate.after(now);
    }

    public static boolean isExistsDepartmentId(String id) {
        if (id != null && !id.isBlank()) {
            Department obj = new Department();
            obj.setId(id);
            return ExaminationManagement.getInstance().getDepartmentList().contains(obj);
        }
        return false;
    }

    public static boolean isDepartmentdExists(String id) {
        if (id != null && !id.isBlank()) {
            Department obj = new Department();
            obj.setId(id);
            return ExaminationManagement.getInstance().getDepartmentList().contains(obj);
        }
        return false;
    }

    public static boolean isDoctorIdExists(String id) {
        if (id != null && !id.isBlank()) {
            Doctor obj = new Doctor();
            obj.setId(id);
            return ExaminationManagement.getInstance().getDoctorList().contains(obj);
        }
        return false;
    }

    public static boolean isPatientIdExists(String id) {
        if (id != null && !id.isBlank()) {
            Patient obj = new Patient();
            obj.setId(id);
            return ExaminationManagement.getInstance().getPatientList().contains(obj);
        }
        return false;
    }

    public static boolean isExaminationIdExists(String id) {
        if (id != null && !id.isBlank()) {
            Examination obj = new Examination();
            obj.setId(id);
            return ExaminationManagement.getInstance().getExaminationtList().contains(obj);
        }
        return false;
    }

}
