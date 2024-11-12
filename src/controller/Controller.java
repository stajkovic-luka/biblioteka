/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;
import java.util.ArrayList;
import java.util.List;
import model.Autor;
import model.Knjiga;
import model.Zanr;

/**
 *
 * @author lukas
 */
public class Controller {
    private DBBroker dbb;
    
//  Liste za rad u lokalnoj memoriji
    private List<Knjiga> listaKnjiga;
    private List<Autor> listaAutora;
       
    // Lazy Singleton
    private static Controller instance;
    public static Controller getInstance(){
            if (instance == null) {
                instance = new Controller();
            }
            return instance;
        };
 
    private Controller() {
        dbb = new DBBroker();
        
        
        
        
        //RAD U LOKALNOJ MEMORIJI
//        Autor autor1 = new Autor("Miodrag ", "Majić", 1969, "	\n" +
//                "\n" +
//                "Miodrag Majić je rođen 17.11.1969. godine u Beogradu. Pravni fakultet završio je 1995. godine. Na istom fakultetu je magistrirao (2003) i "
//                + "doktorirao u oblasti krivičnog prava 2008. godine.");
//        Autor autor2 = new Autor("Jordan ", "Belfort", 1962, "Belfort je rođen 1962. godine, u Bronksu u Njujorku. "
//                + "Odgajan je u Bejsajdu u Kvinsu, u jevrejskoj porodici. Nakon što je završio srednju školu, a krenuo na fakultet, Belfort "
//                + "i njegov bliski prijatelj iz detinjstva, Eliot Lovenstern su zaradili 20 hiljada dolara, tako što su prodavali italijanski "
//                + "sladoled iz ručnih frižidera, ljudima na lokalnoj plaži. Nakon toga, Belfort je diplomirao na Američkom univerzitetu, "
//                + "postavši diplomirani biolog. Džordan je planirao da iskoristi zarađeni novac kako bi otplatio zubarsku školu, pa je "
//                + "krenuo na univerzitet u Merilendu. To nije dugo trajalo, jer je Belfort napustio školu nakon što mu je dekan prvi dan "
//                + "fakulteta rekao da je zlatno doba stomatologije prošlo i da treba da napusti fakultet, ako ga je upisao samo zbog novca. ");
//        Autor autor3 = new Autor("Danijel ", "Vudrel", 0, "Danijel Vudrel (rođen 4. marta 1953.) je američki romanopisac"
//                + " i pisac kratkih priča, koji je napisao devet romana, od kojih je većina smeštena u Misuri Ozarks, i jednu zbirku kratkih priča. "
//                + "Vudrel je skovao frazu „countri noir“ da bi opisao svoj roman „Daj nam poljubac“ iz 1996. godine. Recenzenti su od tada često "
//                + "koristili ovaj termin da kategorizuju njegovo pisanje.");
//       
//        
//        Knjiga knjiga1 = new Knjiga("Deca Zla", autor1, "9788610025477", 2019, Zanr.DOMACI);
//        Knjiga knjiga2 = new Knjiga("Vuk sa Vol Strita", autor2, "9780733622625", 2007, Zanr.POPULARNA_PSIHOLOGIJA);
//        Knjiga knjiga3 = new Knjiga("Darovi Zime", autor3, "9788682904014", 2007, Zanr.TRILER);
//        
//        listaKnjiga = new ArrayList<>();
//        listaAutora = new ArrayList<>();
//        
//        listaAutora.add(autor1);
//        listaAutora.add(autor2);
//        listaAutora.add(autor3);
//        
//        listaKnjiga.add(knjiga1);
//        listaKnjiga.add(knjiga2);
//        listaKnjiga.add(knjiga3);
        
        
        
    }

    public List<Knjiga> getListaKnjiga() {
        return listaKnjiga;
    }

    public void setListaKnjiga(List<Knjiga> listaKnjiga) {
        this.listaKnjiga = listaKnjiga;
    }

    public List<Autor> getListaAutora() {
        return listaAutora;
    }

    public void setListaAutora(List<Autor> listaAutora) {
        this.listaAutora = listaAutora;
    }

    public void obrisiKnjigu(int id) {
        dbb.obrisiKnjigu(id);
        
        
//        listaKnjiga.remove(selektovaniRed);
    }

    public void dodajKnjigu(Knjiga novaKnjiga) {
        dbb.dodajKnjigu(novaKnjiga);
        
//       listaKnjiga.add(novaKnjiga);
    }
    
    // ucitava listu iz baze
    public List<Knjiga> ucitaj() {
        return dbb.ucitaj();
    }

    public List<Autor> ucitajListuAutoraIzBaze() {
        return dbb.ucitajListuAutoraIzBaze();
    }

    public void azurirajKnjigu(Knjiga knjigaZaIzmenu) {
        dbb.azurirajKnjigu(knjigaZaIzmenu);
    }
    
    
};
    
    
    

