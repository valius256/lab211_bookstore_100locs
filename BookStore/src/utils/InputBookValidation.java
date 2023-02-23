/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author Phat
 */
public class InputBookValidation {

    public static boolean checkBookID(String Id) {
        if (Id.matches("[B]+\\d{5}")) {
            return true;
        }
        return false;
    }

    public static boolean checkBookName(String Name) {
        if (Name.length() > 5 && Name.length() < 30) {
            return true;
        }

        return false;
    }

    public static boolean checkBookPrice(double price) {
        if (price > 0) {
            return true;
        }

        return false;
    }

    public static boolean checkBookQuantity(int quantity) {
        if (quantity > 0) {
            return true;
        }
        return false;
    }

    public static boolean checkBookStatus(String Status) {
        if (Status.equals("Available") || Status.equals("Not Available")) {
            return true;
        }
        return false;
    }

    public static boolean checkPublisherId(String Id) {
        if (Id.matches("[P]+\\d{5}")) {
            return true;
        } else {
            return false;
        }
    }
}
