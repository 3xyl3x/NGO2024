package util;
import javax.swing.JTextField;

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
}
