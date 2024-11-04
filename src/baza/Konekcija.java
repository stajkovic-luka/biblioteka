/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

//Potrebni importi za uspostavljanje konekcije sa bazom
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lukas
 */
public class Konekcija {
    //Jedna instanca konekcije za singleton
    private static Konekcija instance;
    //Konekcija za povezivanje sa bazom
    private Connection connection;
    
    //Povezivanje na bazu
    private Konekcija(){
        try {
            //link do baze
            String url = "jdbc:mysql://localhost:3306/ps24_1";
            connection = DriverManager.getConnection(url, "root", "");
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            System.out.println("Nije uspostavljena konekcija sa bazom.");
        }
    }
    
    
    
    //Singleton
    public static Konekcija getInstance(){
        if (instance == null) {
            instance = new Konekcija();
        }
        return instance;
    }
    
    // Getter za pristup konekciji
    public Connection getConnection(){
        return connection;
    }
    
    
}
