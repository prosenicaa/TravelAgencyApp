/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.Rezervacija;

import domen.Putnik;
import domen.Putovanje;
import domen.Rezervacija;
import domen.TuristickiAgent;
import operacije.ApstraktnaOperacija;

/**
 *
 * @author Korisnik
 */
public class SOZapamtiRezervaciju extends ApstraktnaOperacija{

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Rezervacija)) {
            throw new Exception("Netacni podaci za rezervaciju!");
        }
        
        Rezervacija r = (Rezervacija) param;
        
        boolean isValid = (r.getPutnik() != null && r.getPutnik() instanceof Putnik) &&
                (r.getStatus() != null) && (r.getNapomena() != null && r.getNapomena().length() >= 2) &&
                (r.getTuristickiAgent() != null && r.getTuristickiAgent() instanceof TuristickiAgent) &&
                (r.getPutovanje() != null && r.getPutovanje() instanceof Putovanje);
        
        if(!isValid) {
            throw new Exception("Niste uneli korektne podatke");
        } 
    }

    @Override
    protected void izvrsiOperaciju(Object param) throws Exception {
        this.repozitorijum.dodaj((Rezervacija) param);
    }
    
}
