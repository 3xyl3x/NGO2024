package util;
import javax.swing.JTextField;
import java.util.regex.Pattern;

public class Validator {
    
        public Validator() {
            
        }

    public static boolean textFieldHasValue(JTextField textField) {
       return (textField.getText().isEmpty()==false);
    }

       // alternativ med endast booelan
    public static boolean isValidEmail(JTextField textField) {
        String emailRegex = "^[\\w-\\.]+@[\\w-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(emailRegex, textField.getText());
    }
    
}
