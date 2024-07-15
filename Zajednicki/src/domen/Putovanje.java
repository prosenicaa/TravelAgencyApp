/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class Putovanje implements OpstiDomenskiObjekat{
    private int putovanjeID;
    private String prevoz;
    private int brojNoci;
    private long cena;
    private String naziv;
    private Date datumPolaska;
    private Hotel hotel;

    public Putovanje() {
    }

    public Putovanje(int putovanjeID, String prevoz, int brojNoci, long cena, String naziv, Date datumPolaska, Hotel hotel) {
        this.putovanjeID = putovanjeID;
        this.prevoz = prevoz;
        this.brojNoci = brojNoci;
        this.cena = cena;
        this.naziv = naziv;
        this.datumPolaska = datumPolaska;
        this.hotel = hotel;
    }

    public int getPutovanjeID() {
        return putovanjeID;
    }

    public void setPutovanjeID(int putovanjeID) {
        this.putovanjeID = putovanjeID;
    }

    public String getPrevoz() {
        return prevoz;
    }

    public void setPrevoz(String prevoz) {
        this.prevoz = prevoz;
    }

    public int getBrojNoci() {
        return brojNoci;
    }

    public void setBrojNoci(int brojNoci) {
        this.brojNoci = brojNoci;
    }

    public long getCena() {
        return cena;
    }

    public void setCena(long cena) {
        this.cena = cena;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Date getDatumPolaska() {
        return datumPolaska;
    }

    public void setDatumPolaska(Date datumPolaska) {
        this.datumPolaska = datumPolaska;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String vratiImeTabele() {
        return "putovanje";
    }

    @Override
    public void setId(int id) {
        this.putovanjeID = id;
    }

    @Override
    public int getId() {
        return putovanjeID;
    }

    @Override
    public void ubaciVrednostiZaInsert(PreparedStatement statement) {
         try {
            statement.setString(1, prevoz);
            statement.setInt(2, brojNoci);
            statement.setLong(3, cena);
            statement.setString(4, naziv);
            statement.setDate(5, new java.sql.Date(datumPolaska.getTime()));
            statement.setInt(6, hotel.getId());
        } catch (SQLException ex) {
            Logger.getLogger(Putovanje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ubaciVrednostiZaUpdate(PreparedStatement statement) {
        try {
            statement.setString(1, prevoz);
            statement.setInt(2, brojNoci);
            statement.setLong(3, cena);
            statement.setString(4, naziv);
            statement.setDate(5, new java.sql.Date(datumPolaska.getTime()));
            statement.setInt(6, hotel.getId());
        } catch (SQLException ex) {
            Logger.getLogger(Putovanje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ubaciVrednostiZaSelectZaWehere(PreparedStatement statement) {
        try {
        if(this.getPutovanjeID()!= 0){
                statement.setInt(1, this.getId());
        }else{
            int i = 1;
            
             if(naziv != null){
                statement.setString(i, "%" + naziv + "%");
                i++;
            }
            
            
            if(prevoz != null){
                statement.setString(i, "%" + prevoz + "%");
                i++;
            }
            
//            if(brojNoci != 0) {
//                    statement.setString(i, "%" + brojNoci + "%");
//                    i++;
//                }
//
//                if(cena != 0) {
//                    statement.setString(i, "%" + cena + "%");
//                    i++;
//                }

        }
            } catch (SQLException ex) {
                Logger.getLogger(Putovanje.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public String vratiWhereZaSelect() {
        if(this.getPutovanjeID()!= 0){
            return "putovanjeID = ?";  
        }
        
        List<String> wheres = new ArrayList<>();
        
        
        if(naziv != null){
            wheres.add("naziv like ?");
        }
        
        if(prevoz != null){
            wheres.add("prevoz like ?");
        }
        
//        if(brojNoci != 0){
//            wheres.add("brojNoci like ?");
//        }
//        
//        if(cena != 0){
//            wheres.add("cena like ?");
//        }
        
        return String.join(" or ", wheres);
    }

    @Override
    public OpstiDomenskiObjekat vratiRedIzRS(ResultSet rs) {
         Putovanje putovanje = new Putovanje();
        try {
//            ResultSetMetaData metaData = rs.getMetaData();
//            int columnCount = metaData.getColumnCount();
//            for (int i = 1; i <= columnCount; i++) {
//            String columnName = metaData.getColumnName(i);
//            System.out.println("Column Name: " + columnName);


            Hotel h = new Hotel();
            h.setId(rs.getInt("hotelID"));
//            h.setNaziv(rs.getString("naziv"));
//            Mesto m = new Mesto();
//            m.setId(rs.getInt("mestoID"));
//            m.setNaziv(rs.getString("naziv"));

            putovanje.setPutovanjeID(rs.getInt("putovanjeID"));
            putovanje.setPrevoz((rs.getString("prevoz")));
            putovanje.setBrojNoci(rs.getInt("brojNoci"));
            putovanje.setCena(rs.getLong("cena"));
            putovanje.setNaziv(rs.getString("naziv"));
            putovanje.setDatumPolaska(new java.sql.Date(rs.getDate("datumPolaska").getTime()));
            putovanje.setHotel(h);
//            putovanje.getHotel().setMesto(m);
            System.out.println("hotel " + h.getId());
        } catch (SQLException ex) {
            System.out.println("rsss");
            Logger.getLogger(Putovanje.class.getName()).log(Level.SEVERE, null, ex);
        }
        return putovanje;
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
        return "prevoz,brojNoci,cena,naziv,datumPolaska,hotelID";
    }

    @Override
    public String vratiNaziveKolonaZaSelect() {
        return "putovanjeID,prevoz,brojNoci,cena,naziv,datumPolaska,hotelID";
    }

    @Override
    public String vratiNaziveKolonaZaUpdate() {
        return "prevoz,brojNoci,cena,naziv,datumPolaska,hotelID";
    }


    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.putovanjeID;
        hash = 97 * hash + Objects.hashCode(this.prevoz);
        hash = 97 * hash + this.brojNoci;
        hash = 97 * hash + (int) (this.cena ^ (this.cena >>> 32));
        hash = 97 * hash + Objects.hashCode(this.naziv);
        hash = 97 * hash + Objects.hashCode(this.datumPolaska);
        hash = 97 * hash + Objects.hashCode(this.hotel);
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
        final Putovanje other = (Putovanje) obj;
        if (this.putovanjeID != other.putovanjeID) {
            return false;
        }
        if (this.brojNoci != other.brojNoci) {
            return false;
        }
        if (this.cena != other.cena) {
            return false;
        }
        if (!Objects.equals(this.prevoz, other.prevoz)) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.datumPolaska, other.datumPolaska)) {
            return false;
        }
        return Objects.equals(this.hotel, other.hotel);
    }
    
    
    
}
