package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author hasu
 */
public final class Util {

    public static final String SEP = ",";
    private static final String IGNORE_CASE_PATTERN = "(?i)";

    static Scanner sc = new Scanner(System.in);

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
//                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (val < minValue || maxValue < val);
        return val;
    }

    public static String inputString(String message, boolean allowEmpty) {
        Scanner sc = new Scanner(System.in);
        String str = "";
        do {
            System.out.print(message + ": ");
            str = sc.nextLine();
        } while (!allowEmpty && str.isBlank());
//        } while (!allowEmpty && str.trim().isEmpty());
        return str.trim();
    }

    public static boolean validateStringPattern(String str, String regex, boolean ignoreCase) {
        if (str != null && regex != null) {
            if (ignoreCase) {
                regex = Util.IGNORE_CASE_PATTERN + regex;
            }
            return str.matches(regex);
        }
        return false;
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

    public static String inputStringWithSize(String message, int min, int max) {
        Scanner sc = new Scanner(System.in);
        String str = "";
        do {
            System.out.print(message + ": ");
            str = sc.nextLine();
        } while (str.length() > min && str.length() < max);
//        } while (!allowEmpty && str.trim().isEmpty());
        return str.trim();
    }

    public static boolean saveLines(String path, List<String> list) {
        
        try {
            PrintWriter output = new PrintWriter(path);
            for (String i : list) {
                output.println(i);
            }
            output.close();
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }

    }

    public static List<String> readLines(String path) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            List<String> ret = new ArrayList();
            String s = "";
            while ((s = in.readLine()) != null) {
                ret.add(s);
            }
            in.close();
            return ret;
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    public static int inputInt(String msg) {
        int data = 0;
        boolean flag;
        do {
            try {
                flag = false;
                System.out.print(msg);
                data = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(e);
                flag = true;
            }
        } while (flag);
        return data;
    }


    public static double inputDouble(String msg, int min) {
        double ret = 0;
        boolean flag;
        do {
            try {
                System.out.print(msg);
                flag = false;
                ret = Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(e);
                flag = true;
            }
        } while (flag);
        return ret;
    }
    
    public static double inputDouble(String message, double minValue) {
        double val = minValue - 1;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(message + ": ");
            try {
                val = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException ex) {
//                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (val < minValue);
        return val;
    }
    
    public static int inputInt(String message, int minValue) {
        int val = minValue - 1;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(message + ": ");
            try {
                val = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException ex) {
//                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (val < minValue);
        return val;
    } 

//    public static Integer inputInteger(String message, int min, int max, boolean allowEmpty){
//        Integer intVal = null;
//        String sVal;
//        Scanner sc = new Scanner(System.in);
//        while (true ) {            
//                System.out.print(message + ": ");
//            try {
//                sVal =Util.inputString(message, allowEmpty);
//                
//                if(intVal.)
//                
//            } catch (Exception e) {
//            }
//        }
//    
//    }
    


}
