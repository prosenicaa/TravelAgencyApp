/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class Rezervacija implements OpstiDomenskiObjekat{
    private int brojRezervacije;
    private Putovanje putovanje;
    private Putnik putnik;
    private Date datumRezervacije;
    private String status;
    private String napomena;
    private TuristickiAgent turistickiAgent;

    public Rezervacija() {
    }

    public Rezervacija(int brojRezervacije, Putovanje putovanje, Putnik putnik, Date datumRezervacije, String status, String napomena, TuristickiAgent turistickiAgent) {
        this.brojRezervacije = brojRezervacije;
        this.putovanje = putovanje;
        this.putnik = putnik;
        this.datumRezervacije = datumRezervacije;
        this.status = status;
        this.napomena = napomena;
        this.turistickiAgent = turistickiAgent;
    }

        public int getBrojRezervacije() {
        return brojRezervacije;
    }

    public void setBrojRezervacije(int brojRezervacije) {
        this.brojRezervacije = brojRezervacije;
    }

    public TuristickiAgent getTuristickiAgent() {
        return turistickiAgent;
    }

    public void setTuristickiAgent(TuristickiAgent turistickiAgent) {
        this.turistickiAgent = turistickiAgent;
    }

    public Putovanje getPutovanje() {
        return putovanje;
    }

    public void setPutovanje(Putovanje putovanje) {
        this.putovanje = putovanje;
    }

    public Putnik getPutnik() {
        return putnik;
    }

    public void setPutnik(Putnik putnik) {
        this.putnik = putnik;
    }

    public Date getDatumRezervacije() {
        return datumRezervacije;
    }

    public void setDatumRezervacije(Date datumRezervacije) {
        this.datumRezervacije = datumRezervacije;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    @Override
    public String vratiImeTabele() {
        return "rezervacija";
    }

    @Override
    public void setId(int id) {
        this.brojRezervacije = id;
    }

    @Override
    public int getId() {
        return brojRezervacije;
    }

    @Override
    public void ubaciVrednostiZaInsert(PreparedStatement statement) {
         try {
            statement.setInt(1, putovanje.getId());
            statement.setInt(2, putnik.getId());
            statement.setDate(3, new java.sql.Date(datumRezervacije.getTime()));
            statement.setString(4, status);
            statement.setString(5, napomena);
            statement.setInt(6, turistickiAgent.getId());
        } catch (SQLException ex) {
            Logger.getLogger(Rezervacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ubaciVrednostiZaUpdate(PreparedStatement statement) {
          try {
            statement.setInt(1, putovanje.getId());
            statement.setInt(2, putnik.getId());
            statement.setDate(3, new java.sql.Date(datumRezervacije.getTime()));
            statement.setString(4, status);
            statement.setString(5, napomena);
            statement.setInt(6, turistickiAgent.getId());
        } catch (SQLException ex) {
            Logger.getLogger(Rezervacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ubaciVrednostiZaSelectZaWehere(PreparedStatement statement) {
        try {
        if(this.getBrojRezervacije()!= 0){
                statement.setInt(1, this.getId());
        }else{
            //int i = 1;
            
//            if(putovanje.getNaziv() != null){
//                statement.setString(i, "%" + putovanje.getNaziv() + "%");
//                i++;
//            }
//            
//            if(putnik.getIme() != null){
//                statement.setString(i, "%" + putnik.getIme() + "%");
//                i++;
//            }
            
            if(status != null) {
                    //statement.setString(1, "%" + status + "%");
                    statement.setString(1, this.getStatus());
                   // i++;
                }

        }
        
            } catch (SQLException ex) {
                Logger.getLogger(Rezervacija.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public String vratiWhereZaSelect() {
        if(this.getBrojRezervacije()!= 0){
            return "brojRezervacije = ?";  
        }
        
        List<String> wheres = new ArrayList<>();
        
        if(status != null){
            wheres.add("status like ?");
        }
        
         return String.join(" or ", wheres);
    }

    @Override
    public OpstiDomenskiObjekat vratiRedIzRS(ResultSet rs) {
        Rezervacija rezervacija = new Rezervacija();
        try {
            Putovanje put = new Putovanje();
            put.setId(rs.getInt("putovanje"));
            Putnik p = new Putnik();
            p.setId(rs.getInt("putnik"));
            TuristickiAgent ta = new TuristickiAgent();
            ta.setId(rs.getInt("turistickiAgent"));
            rezervacija.setBrojRezervacije(rs.getInt("brojRezervacije"));
            rezervacija.setPutovanje(put);
            rezervacija.setPutnik(p);
            rezervacija.setDatumRezervacije(new java.sql.Date(rs.getDate("datumRezervacije").getTime()));
            rezervacija.setStatus(rs.getString("status"));
            rezervacija.setNapomena(rs.getString("napomena"));
            rezervacija.setTuristickiAgent(ta);
        } catch (SQLException ex) {
            System.out.println("rsss");
            Logger.getLogger(Rezervacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rezervacija;
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
        return "putovanje,putnik,datumRezervacije,status,napomena,turistickiAgent";
    }

    @Override
    public String vratiNaziveKolonaZaSelect() {
        return "brojrezervacije,putovanje,putnik,datumRezervacije,status,napomena,turistickiAgent";
    }

    @Override
    public String vratiNaziveKolonaZaUpdate() {
        return "putovanje,putnik,datumRezervacije,status,napomena,turistickiAgent";
    }

    
    
    
    
}
