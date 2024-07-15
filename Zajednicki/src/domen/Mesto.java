/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class Mesto implements OpstiDomenskiObjekat{
    private int mestoID;
    private String ptt;
    private String naziv;

    public Mesto() {
    }

    public Mesto(int mestoID, String ptt, String naziv) {
        this.mestoID = mestoID;
        this.ptt = ptt;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getMestoID() {
        return mestoID;
    }

    public void setMestoID(int mestoID) {
        this.mestoID = mestoID;
    }

    public String getPtt() {
        return ptt;
    }

    public void setPtt(String ptt) {
        this.ptt = ptt;
    }

    @Override
    public String vratiImeTabele() {
        return "mesto";
    }

    @Override
    public void setId(int id) {
        this.mestoID = id;
    }

    @Override
    public int getId() {
        return mestoID;
    }

    @Override
    public void ubaciVrednostiZaInsert(PreparedStatement statement) {
        try {
            statement.setString(1, ptt);
            statement.setString(2, naziv);
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ubaciVrednostiZaUpdate(PreparedStatement statement) {
         try {
            statement.setString(1, ptt);
            statement.setString(2, naziv);
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ubaciVrednostiZaSelectZaWehere(PreparedStatement statement) {
         try {
        if(this.getMestoID()!= 0){
                statement.setInt(1, this.getId());
        }
            } catch (SQLException ex) {
                Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public String vratiWhereZaSelect() {
        if(this.getMestoID()!= 0){
            return "mestoID = ?";  
        }else{
            return "";
        }
    }

    @Override
    public OpstiDomenskiObjekat vratiRedIzRS(ResultSet rs) {
        Mesto mesto = new Mesto();
        try {
            mesto.setMestoID(rs.getInt("mestoID"));
            mesto.setPtt(rs.getString("ptt"));
            mesto.setNaziv(rs.getString("naziv"));
        } catch (SQLException ex) {
            System.out.println("rsss");
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mesto;
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
        return "ptt,naziv";
    }

    @Override
    public String vratiNaziveKolonaZaSelect() {
         return "mestoID,ptt,naziv";
    }

    @Override
    public String vratiNaziveKolonaZaUpdate() {
         return "ptt,naziv";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.mestoID;
        hash = 37 * hash + Objects.hashCode(this.ptt);
        hash = 37 * hash + Objects.hashCode(this.naziv);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mesto other = (Mesto) obj;
        if (this.mestoID != other.mestoID) {
            return false;
        }
        if (!Objects.equals(this.ptt, other.ptt)) {
            return false;
        }
        return Objects.equals(this.naziv, other.naziv);
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
    
    
    
}
