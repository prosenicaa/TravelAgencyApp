/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.Hotel;

import domen.Hotel;
import domen.Mesto;
import java.util.List;
import operacije.ApstraktnaOperacija;

/**
 *
 * @author Korisnik
 */
public class SOUcitajListuHotela extends ApstraktnaOperacija{

    private List<Hotel> lista;

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Hotel)) {
            throw new Exception("Netacni podaci za hotel!");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param) throws Exception {
        this.lista = this.repozitorijum.vratiSve(param);
        
        for(Hotel h : this.lista){
            Mesto m = h.getMesto();
            
            if(m != null && m.getId() != 0){
                h.setMesto((Mesto) this.repozitorijum.vratiSve(m).get(0));
            } 
        }
    }
    
     public List<Hotel> getLista() {
        return lista;
    }
    
}
