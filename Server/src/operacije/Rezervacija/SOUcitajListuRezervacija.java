/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.Rezervacija;

import domen.Putnik;
import domen.Putovanje;
import domen.Rezervacija;
import domen.TuristickiAgent;
import java.util.List;
import operacije.ApstraktnaOperacija;

/**
 *
 * @author Korisnik
 */
public class SOUcitajListuRezervacija extends ApstraktnaOperacija{

    private List<Rezervacija> lista;

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Rezervacija)) {
            throw new Exception("Netacni podaci za rezervaciju!");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param) throws Exception {
        this.lista = this.repozitorijum.vratiSve(param);
        
        for(Rezervacija rezervacija : this.lista){
            Putovanje putovanje = rezervacija.getPutovanje();
            Putnik putnik = rezervacija.getPutnik();
            TuristickiAgent ta = rezervacija.getTuristickiAgent();
            
            if(putovanje != null && putovanje.getId() != 0){
                rezervacija.setPutovanje((Putovanje) this.repozitorijum.vratiSve(putovanje).get(0));
            }
            
             if(putnik != null && putnik.getId() != 0){
                rezervacija.setPutnik((Putnik) this.repozitorijum.vratiSve(putnik).get(0));
            }
             
             if(ta != null && ta.getId() != 0){
                rezervacija.setTuristickiAgent((TuristickiAgent) this.repozitorijum.vratiSve(ta).get(0));
            }
        }
        
        
    }
    
     public List<Rezervacija> getLista() {
        return lista;
    }
    
}
