/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class Putnik implements OpstiDomenskiObjekat{
    private int putnikID;
    private String brojPasosa;
    private String ime;
    private String prezime;
    private String JMBG;
    private String email;
    private String telefon;

    public Putnik() {
    }

    public Putnik(int putnikID, String brojPasosa, String ime, String prezime, String JMBG, String email, String telefon) {
        this.putnikID = putnikID;
        this.brojPasosa = brojPasosa;
        this.ime = ime;
        this.prezime = prezime;
        this.JMBG = JMBG;
        this.email = email;
        this.telefon = telefon;
    }

    public int getPutnikID() {
        return putnikID;
    }

    public void setPutnikID(int putnikID) {
        this.putnikID = putnikID;
    }

    public String getBrojPasosa() {
        return brojPasosa;
    }

    public void setBrojPasosa(String brojPasosa) {
        this.brojPasosa = brojPasosa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String vratiImeTabele() {
        return "putnik";
    }

    @Override
    public void setId(int id) {
        this.putnikID = id;
    }

    @Override
    public int getId() {
        return putnikID;
    }

    @Override
    public void ubaciVrednostiZaInsert(PreparedStatement statement) {
         try {
            statement.setString(1, brojPasosa);
            statement.setString(2, ime);
            statement.setString(3, prezime);
            statement.setString(4, JMBG);
            statement.setString(5, email);
            statement.setString(6, telefon);
        } catch (SQLException ex) {
            Logger.getLogger(Putnik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ubaciVrednostiZaUpdate(PreparedStatement statement) {
        try {
            statement.setString(1, brojPasosa);
            statement.setString(2, ime);
            statement.setString(3, prezime);
            statement.setString(4, JMBG);
            statement.setString(5, email);
            statement.setString(6, telefon);
        } catch (SQLException ex) {
            Logger.getLogger(Putnik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ubaciVrednostiZaSelectZaWehere(PreparedStatement statement) {
        try {
        if(this.getPutnikID()!= 0){
                statement.setInt(1, this.getId());
        }else{
            int i = 1;
            
            if(brojPasosa != null){
                statement.setString(i, "%" + brojPasosa + "%");
                i++;
            }
            
            if(ime != null){
                statement.setString(i, "%" + ime + "%");
                i++;
            }
            
            if(prezime != null) {
                    statement.setString(i, "%" + prezime + "%");
                    i++;
                }
            
            if(JMBG != null){
                statement.setString(i, "%" + JMBG + "%");
                i++;
            }

            if(email != null) {
                statement.setString(i, "%" + email + "%");
                i++;
            }

            if(telefon != null) {
                statement.setString(i, "%" + telefon + "%");
                i++;
            }
        }
            } catch (SQLException ex) {
                Logger.getLogger(Putnik.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public String vratiWhereZaSelect() {
        if(this.getPutnikID()!= 0){
            return "putnikID = ?";  
        }
        
        List<String> wheres = new ArrayList<>();
        
        if(brojPasosa != null){
            wheres.add("brojPasosa like ?");
        }
        
//        if(JMBG != null){
//            wheres.add("JMBG like ?");
//        }
        
        
        if(ime != null){
            wheres.add("ime like ?");
        }
        
        if(prezime != null){
            wheres.add("prezime like ?");
        }
        
        if(email != null){
            wheres.add("email like ?");
        }
        
        if(telefon != null){
            wheres.add("telefon like ?");
        }
        
        return String.join(" or ", wheres);
        
    }

    @Override
    public OpstiDomenskiObjekat vratiRedIzRS(ResultSet rs) {
        Putnik putnik = new Putnik();
        try {
            putnik.setPutnikID(rs.getInt("putnikID"));
            putnik.setBrojPasosa(rs.getString("brojPasosa"));
            putnik.setIme(rs.getString("ime"));
            putnik.setPrezime(rs.getString("prezime"));
            putnik.setJMBG(rs.getString("JMBG"));
            putnik.setEmail(rs.getString("email"));
            putnik.setTelefon(rs.getString("telefon"));
        } catch (SQLException ex) {
            System.out.println("rsss");
            Logger.getLogger(Putnik.class.getName()).log(Level.SEVERE, null, ex);
        }
        return putnik;
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
        return "brojPasosa,ime,prezime,JMBG,email,telefon";
    }

    @Override
    public String vratiNaziveKolonaZaSelect() {
        return "putnikID,brojPasosa,ime,prezime,JMBG,email,telefon";
    }

    @Override
    public String vratiNaziveKolonaZaUpdate() {
        return "brojPasosa,ime,prezime,JMBG,email,telefon";
    }


    @Override
    public String toString() {
        return ime + " " + prezime;
    }
    
    
}
