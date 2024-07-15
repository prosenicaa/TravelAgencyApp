/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Korisnik
 */
public interface OpstiDomenskiObjekat extends Serializable{
    String vratiImeTabele();

    void setId(int id);
    
    public int getId();

    public void ubaciVrednostiZaInsert(PreparedStatement statement);

    public void ubaciVrednostiZaUpdate(PreparedStatement statement);

    public void ubaciVrednostiZaSelectZaWehere(PreparedStatement statement);

    public String vratiWhereZaSelect();

    public OpstiDomenskiObjekat vratiRedIzRS(ResultSet rs);

    public String vratiNaziveKolonaZaInsert();

    public String vratiNaziveKolonaZaSelect();
    
    public String vratiNaziveKolonaZaUpdate();
    
}
