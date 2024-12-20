
import database.DatabaseManager;
import models.Project;
import panels.MainWindow;


/**
 *
 * @author david
 */
public class Start {
     private static DatabaseManager dbm;

    public static void main(String[] args) {
        dbm = new DatabaseManager();
        // Skapar fönstret och visar det.
        new MainWindow(dbm).setVisible(true);
        
        
    }
    }
   
