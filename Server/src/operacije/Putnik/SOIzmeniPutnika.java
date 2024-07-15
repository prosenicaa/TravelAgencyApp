/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.Putnik;

import domen.Putnik;
import operacije.ApstraktnaOperacija;

/**
 *
 * @author Korisnik
 */
public class SOIzmeniPutnika extends ApstraktnaOperacija{

     @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Putnik)) {
            throw new Exception("Netacni podaci za putnika!");
        }
        
        Putnik p = (Putnik) param;
        
         boolean isValid = (p.getIme() != null && p.getIme().length() >= 2) &&
                (p.getPrezime() != null && p.getPrezime().length() >= 2) &&
                (p.getBrojPasosa() != null && p.getBrojPasosa().length() >= 2) && 
                (p.getEmail() != null && p.getEmail().contains("@") && p.getEmail().length() >= 2) &&
                (p.getTelefon() != null && p.getTelefon().length() >= 2) &&
                (p.getJMBG() != null && p.getJMBG().length() == 13);
                 
        
        if(!isValid) {
            throw new Exception("Niste uneli korektne podatke");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param) throws Exception {
         this.repozitorijum.izmeni((Putnik) param);
    }
    
    
}
