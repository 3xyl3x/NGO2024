package util;

import javax.swing.JOptionPane;
import java.awt.Component;

public class ErrorHandler {

    // Visa ett felmeddelande
    public static void showError(Component parent, boolean critical, String message) {
        JOptionPane.showMessageDialog(
            parent,
            message,
            "Fel",
            JOptionPane.ERROR_MESSAGE
        );
        
        // Kritiskt fel, stäng program
        if (critical) System.exit(1);
    }

    // Visa en varning
    public static void showWarning(Component parent, String message) {
        JOptionPane.showMessageDialog(
            parent,
            message,
            "Varning",
            JOptionPane.WARNING_MESSAGE
        );
    }

    // Visa information
    public static void showInfo(Component parent, String message) {
        JOptionPane.showMessageDialog(
            parent,
            message,
            "Information",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    // Bekräftelsedialog
    public static boolean showConfirmation(Component parent, String message) {
        int result = JOptionPane.showConfirmDialog(
            parent,
            message,
            "Bekräfta",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        return result == JOptionPane.YES_OPTION;
    }
}
