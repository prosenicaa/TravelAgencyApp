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
public class Hotel implements OpstiDomenskiObjekat{
    private int hotelID;
    private VrstaUsluge vrstaUsluge;
    private int brojZvezdica;
    private boolean ljubimci;
    private String naziv;
    private String adresa;
    private Mesto mesto;

    public Hotel() {
    }

    public Hotel(int hotelID, VrstaUsluge vrstaUsluge, int brojZvezdica, boolean ljubimci, String naziv, String adresa, Mesto mesto) {
        this.hotelID = hotelID;
        this.vrstaUsluge = vrstaUsluge;
        this.brojZvezdica = brojZvezdica;
        this.ljubimci = ljubimci;
        this.naziv = naziv;
        this.adresa = adresa;
        this.mesto = mesto;
    }

 

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public VrstaUsluge getVrstaUsluge() {
        return vrstaUsluge;
    }

    public void setVrstaUsluge(VrstaUsluge vrstaUsluge) {
        this.vrstaUsluge = vrstaUsluge;
    }

    public int getBrojZvezdica() {
        return brojZvezdica;
    }

    public void setBrojZvezdica(int brojZvezdica) {
        this.brojZvezdica = brojZvezdica;
    }

    public boolean isLjubimci() {
        return ljubimci;
    }

    public void setLjubimci(boolean ljubimci) {
        this.ljubimci = ljubimci;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String vratiImeTabele() {
        return "hotel";
    }

    @Override
    public void setId(int id) {
        this.hotelID = id;
    }

    @Override
    public int getId() {
        return hotelID;
    }

    @Override
    public void ubaciVrednostiZaInsert(PreparedStatement statement) {
        try {
            statement.setString(1, vrstaUsluge.toString());
            statement.setInt(2, brojZvezdica);
            statement.setBoolean(3, ljubimci);
            statement.setString(4, naziv);
            statement.setString(5, adresa);
            statement.setInt(6, mesto.getId());
        } catch (SQLException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ubaciVrednostiZaUpdate(PreparedStatement statement) {
        try {
            statement.setString(1, vrstaUsluge.toString());
            statement.setInt(2, brojZvezdica);
            statement.setBoolean(3, ljubimci);
            statement.setString(4, naziv);
            statement.setString(5, adresa);
            statement.setInt(6, mesto.getId());
        } catch (SQLException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ubaciVrednostiZaSelectZaWehere(PreparedStatement statement) {
        try {
        if(this.getHotelID()!= 0){
                statement.setInt(1, this.getId());
        }
            } catch (SQLException ex) {
                Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public String vratiWhereZaSelect() {
        if(this.getHotelID()!= 0){
            return "hotelID = ?";  
        }else{
            return "";
        }
    }

    @Override
    public OpstiDomenskiObjekat vratiRedIzRS(ResultSet rs) {
        Hotel hotel = new Hotel();
        try {
            Mesto m = new Mesto();
            m.setId(rs.getInt("mestoID"));
            hotel.setHotelID(rs.getInt("hotelID"));
            hotel.setVrstaUsluge(VrstaUsluge.valueOf(rs.getString("vrstaUsluge")));
            hotel.setBrojZvezdica(rs.getInt("brojZvezdica"));
            hotel.setLjubimci(rs.getBoolean("ljubimci"));
            hotel.setNaziv(rs.getString("naziv"));
            hotel.setAdresa(rs.getString("adresa"));
            hotel.setMesto(m);
        } catch (SQLException ex) {
            System.out.println("rsss");
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hotel;
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
        return "vrstaUsluge,brojZvezdica,ljubimci,naziv,adresa,mestoID";
    }

    @Override
    public String vratiNaziveKolonaZaSelect() {
        return "hotelID,vrstaUsluge,brojZvezdica,ljubimci,naziv,adresa,mestoID";
    }

    @Override
    public String vratiNaziveKolonaZaUpdate() {
        return "vrstaUsluge,brojZvezdica,ljubimci,naziv,adresa,mestoID";
    }

    @Override
    public String toString() {
        return naziv;
    }

   
    
    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.hotelID;
        hash = 97 * hash + Objects.hashCode(this.vrstaUsluge);
        hash = 97 * hash + this.brojZvezdica;
        hash = 97 * hash + (this.ljubimci ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.naziv);
        hash = 97 * hash + Objects.hashCode(this.adresa);
        hash = 97 * hash + Objects.hashCode(this.mesto);
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
        final Hotel other = (Hotel) obj;
        if (this.hotelID != other.hotelID) {
            return false;
        }
        if (this.brojZvezdica != other.brojZvezdica) {
            return false;
        }
        if (this.ljubimci != other.ljubimci) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.adresa, other.adresa)) {
            return false;
        }
        if (this.vrstaUsluge != other.vrstaUsluge) {
            return false;
        }
        return Objects.equals(this.mesto, other.mesto);
    }

    
    
}
