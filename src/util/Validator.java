package util;
import javax.swing.JTextField;
import java.util.regex.Pattern;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author david
 */
public class Validator {
    
    public static boolean textFieldHasValue(JTextField textField) {
       return (textField.getText().isEmpty()==false);
    }
    
       public static void main(String[] args) {
        String email = "example@mail.com";
        String emailRegex = "^[\\w-\\.]+@[\\w-]+\\.[a-zA-Z]{2,}$";

        boolean isValid = Pattern.matches(emailRegex, email);

        if (isValid) {
            System.out.println("Valid mail");
        } else {
            System.out.println("Invalid mail");
        }
       }
}
