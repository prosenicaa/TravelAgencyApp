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
public class TuristickiAgent implements OpstiDomenskiObjekat{
    private int turistickiAgentID;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;

    public TuristickiAgent() {
    }

    public TuristickiAgent(int turistickiAgentID, String ime, String prezime, String korisnickoIme, String lozinka) {
        this.turistickiAgentID = turistickiAgentID;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public int getTuristickiAgentID() {
        return turistickiAgentID;
    }

    public void setTuristickiAgentID(int turistickiAgentID) {
        this.turistickiAgentID = turistickiAgentID;
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

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

   @Override
    public String vratiImeTabele() {
        return "turistickiagent";
    }


    @Override
    public void setId(int id) {
        this.turistickiAgentID = id;
    }


    @Override
    public void ubaciVrednostiZaInsert(PreparedStatement statement) {
        try {
            statement.setString(1, ime);
            statement.setString(2, prezime);
            statement.setString(3, korisnickoIme);
            statement.setString(4, lozinka);
        } catch (SQLException ex) {
            Logger.getLogger(TuristickiAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void ubaciVrednostiZaUpdate(PreparedStatement statement) {
        try {
            statement.setString(1, ime);
            statement.setString(2, prezime);
            statement.setString(3, korisnickoIme);
            statement.setString(4, lozinka);
        } catch (SQLException ex) {
            Logger.getLogger(TuristickiAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getId() {
        return turistickiAgentID;
    }

    @Override
    public void ubaciVrednostiZaSelectZaWehere(PreparedStatement statement) {
        try {
        if(this.getTuristickiAgentID() != 0){
                statement.setInt(1, this.getId());
        }
            } catch (SQLException ex) {
                Logger.getLogger(TuristickiAgent.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    

    @Override
    public String vratiWhereZaSelect() {
        if(this.getTuristickiAgentID() != 0){
            return "turistickiAgentID = ?";  
        }else{
            return "";
        }
    }

    @Override
    public OpstiDomenskiObjekat vratiRedIzRS(ResultSet rs) {
        TuristickiAgent ta = new TuristickiAgent();
        try {
            
            ta.setTuristickiAgentID(rs.getInt("turistickiAgentID"));
            ta.setIme(rs.getString("ime"));
            ta.setPrezime(rs.getString("prezime"));
            ta.setKorisnickoIme(rs.getString("korisnickoIme"));
            ta.setLozinka(rs.getString("lozinka"));            
        } catch (SQLException ex) {
            System.out.println("rsss");
            Logger.getLogger(TuristickiAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ta;
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
         return "ime,prezime,korisnickoIme,lozinka";
    }

    @Override
    public String vratiNaziveKolonaZaSelect() {
        return "turistickiAgentID,ime,prezime,korisnickoIme,lozinka";
    }
    
    @Override
    public String vratiNaziveKolonaZaUpdate() {
        return "ime,prezime,korisnickoIme,lozinka";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.turistickiAgentID;
        hash = 97 * hash + Objects.hashCode(this.ime);
        hash = 97 * hash + Objects.hashCode(this.prezime);
        hash = 97 * hash + Objects.hashCode(this.korisnickoIme);
        hash = 97 * hash + Objects.hashCode(this.lozinka);
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
        final TuristickiAgent other = (TuristickiAgent) obj;
        if (this.turistickiAgentID != other.turistickiAgentID) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        return Objects.equals(this.lozinka, other.lozinka);
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

   
    
    
}
