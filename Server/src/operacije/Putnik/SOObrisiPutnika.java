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
public class SOObrisiPutnika extends ApstraktnaOperacija{

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Putnik)) {
            throw new Exception("Netacni podaci za putnika!");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param) throws Exception {
        this.repozitorijum.obrisi((Putnik)param);
    }
    
}
