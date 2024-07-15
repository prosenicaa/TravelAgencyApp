/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.Putovanje;

import domen.Hotel;
import domen.Putovanje;
import operacije.ApstraktnaOperacija;

/**
 *
 * @author Korisnik
 */
public class SOIzmeniPutovanje extends ApstraktnaOperacija{

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Putovanje)) {
            throw new Exception("Netacni podaci za putovanje!");
        }
        
        Putovanje p = (Putovanje) param;
        
        boolean isValid = (p.getPrevoz() != null) &&
                (p.getBrojNoci() != 0) &&
                (p.getCena() > 0) && (p.getNaziv() != null  && p.getNaziv().length() > 2) &&
                (p.getHotel() != null && (p.getHotel() instanceof Hotel));
        
        if(!isValid) {
            throw new Exception("Niste uneli korektne podatke");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param) throws Exception {
        this.repozitorijum.izmeni((Putovanje) param);
    }
    
}
