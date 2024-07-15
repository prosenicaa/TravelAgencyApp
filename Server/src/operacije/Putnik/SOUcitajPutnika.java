/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.Putnik;

import domen.Putnik;
import java.util.List;
import operacije.ApstraktnaOperacija;

/**
 *
 * @author Korisnik
 */
public class SOUcitajPutnika extends ApstraktnaOperacija{

    private Putnik putnik;

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Putnik)) {
            throw new Exception("Netacni podaci za putnika!");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param) throws Exception {
        this.putnik = null;
        
        List<Putnik> bs = this.repozitorijum.vratiSve((Putnik) param);
        
        if(!bs.isEmpty()) {
            this.putnik = bs.get(0);
        }
    }
    
    public Putnik getPutnik() {
        return putnik;
    }
    
}
