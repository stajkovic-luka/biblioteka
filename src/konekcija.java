/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lukas
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class konekcija {
    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/vezbanje";
        try {
            Connection konekcija = DriverManager.getConnection(url, "root", "");
            System.out.println("Uspesna konekcija");
            
            PreparedStatement ps = konekcija.prepareStatement("DELETE FROM automobil WHERE godiste= ?");
            ps.setString(1, "2012");
            
            ps.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(konekcija.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Neuspesna konekcija");

        }
        
    }
}
