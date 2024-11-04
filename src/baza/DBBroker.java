/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Autor;
import model.Knjiga;
import model.Zanr;

/**
 *
 * @author lukas
 */
public class DBBroker {

    public List<Knjiga> ucitaj() {
            List<Knjiga> lista = new ArrayList<>();
        try {
            
            String upit ="SELECT * FROM knjiga k JOIN autor a ON k.autorId = a.id;";
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            
            
            while (rs.next()) {                
                int id = rs.getInt("k.id");
                String naslov = rs.getString("k.naslov");
                int godinaIzdanja = rs.getInt("k.godinaIzdanja");
                String zanr = rs.getString("k.zanr");
                Zanr z = Zanr.valueOf(zanr);
                int idA = rs.getInt("a.id");
                String imeAutora = rs.getString("a.ime");
                String prezimeAutora = rs.getString("a.prezime");
                String biografija = rs.getString("a.biografija");
                int godinaRodjenja = rs.getInt("a.godinaRodjenja");
                String ISBN = rs.getString("k.isbn");

                Autor a = new Autor(idA,imeAutora, prezimeAutora, godinaRodjenja, biografija);
                Knjiga k = new Knjiga(id, naslov, a, ISBN, godinaIzdanja, z);
                lista.add(k);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
            return lista;
    }

    public List<Autor> ucitajListuAutoraIzBaze() {
         List<Autor> lista = new ArrayList<>();
        try {
            
            String upit ="SELECT * FROM Autor a";
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            
            
            while (rs.next()) {                
                int idA = rs.getInt("a.id");
                String imeAutora = rs.getString("a.ime");
                String prezimeAutora = rs.getString("a.prezime");
                String biografija = rs.getString("a.biografija");
                int godinaRodjenja = rs.getInt("a.godinaRodjenja");

                Autor a = new Autor(idA,imeAutora, prezimeAutora, godinaRodjenja, biografija);
                
                lista.add(a);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
            return lista;
    }

    public void obrisiKnjigu(int id) {
        String upit = "DELETE FROM Knjiga WHERE id=?";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            
            ps.setInt(1, id);
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
