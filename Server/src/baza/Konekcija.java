/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Korisnik
 */
public class Konekcija {
      private Connection konekcija;
    private static Konekcija instance;

    private Konekcija() {
    }

    public static Konekcija getInstance() {
        if (instance == null) {
            instance = new Konekcija();
        }
        return instance;
    }


    public Connection otvoriKonekciju() throws Exception {
        if (konekcija == null || konekcija.isClosed()) {
            Properties properties = new Properties();
            properties.load(new FileInputStream("konfiguracija/konfiguracija.properties"));
            String url = properties.getProperty("url");
            String username = properties.getProperty("korisnickoIme");
            String password = properties.getProperty("lozinka");
            konekcija = DriverManager.getConnection(url, username, password);
            konekcija.setAutoCommit(false);
        }
        return konekcija;
    }
    
     public void disconnect() throws SQLException
    {
        if(this.konekcija != null) {
            if(!this.konekcija.isClosed()) {
                this.konekcija.close();
            }
            
            this.konekcija = null;
        }
    }
    
//    public void zatvoriKonekciju() throws Exception {
//        konekcija.close();
//        System.out.println("Zatvorena konekcija..");
//    }
//
//    public void potvrdiTransakciju() throws Exception {
//        konekcija.commit();
//        System.out.println("Transakcija je potvrđena.");
//    }
//
//    public void ponistiTransakciju() throws Exception {
//        konekcija.rollback();
//        System.err.println("Transakcija je poništena.");
//    }
    
}
