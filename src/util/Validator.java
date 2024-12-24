package util;
import javax.swing.JTextField;
import java.util.regex.Pattern;

public class Validator {
    
        public Validator() {
            
        }

    public static boolean textFieldHasValue(JTextField textField) {
       return (textField.getText().isEmpty()==false);
    }

       // kontroll av korrekt textformat av mail
    public static boolean textFieldIsEmail(JTextField textField) {
        String emailRegex = "^[\\w-\\.]+@[\\w-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(emailRegex, textField.getText());
    }
    
    // kontroll av icke skadlig kod
    public static boolean textFieldIsClean (JTextField textField) {
        String input = textField.getText();
        String forbiddeninput = "'|\"|;|--|\\b(SELECT|INSERT|DELETE|DROP|UPDATE|ALTER|CREATE|WHERE)\"\b,";
       
        if(input.matches(forbiddeninput)) {
        return false;
    }
        
        else{
    return true;
        }
    }
    
    // kontroll av korrekt inmatat telefonnummer
    public static boolean textFieldIsPhone (JTextField textField) {
        String input = textField.getText();
        
        String correctPhone = "^[0-9-]{7,15}$";
        if(input.matches(correctPhone)) {
            return true;
        }

        else{
   return false;
        }
    }
}
