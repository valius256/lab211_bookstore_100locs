/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author Phat
 */
public final class InputPublisherValidation {
    public static boolean checkPublisherId(String Id){
        if(Id.matches("[P]+\\d{5}")){
            return true;
        }else {
            return false;
        }
    }
    
    public static boolean checkPublisherName(String Name){
        if(Name.length() >= 5 && Name.length() <= 30){
            return true;
        }else {
            return false;
        }
    }
    
    public static boolean checkPublisherPhoneNumber(String PhoneNumber){
        if(PhoneNumber.length() >= 10 && PhoneNumber.length() <= 12){
            return true;
        }else {
            return false;
        }
    }
    
    
}
