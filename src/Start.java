
import database.DatabaseManager;
import panels.MainWindow;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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
