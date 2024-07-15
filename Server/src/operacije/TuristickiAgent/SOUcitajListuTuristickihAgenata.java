/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.TuristickiAgent;

import domen.TuristickiAgent;
import java.util.List;
import operacije.ApstraktnaOperacija;

/**
 *
 * @author Korisnik
 */
public class SOUcitajListuTuristickihAgenata extends ApstraktnaOperacija{

    private List<TuristickiAgent> lista;

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof TuristickiAgent)) {
            throw new Exception("Netacni podaci za turistickog agenta!");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param) throws Exception {
        this.lista = this.repozitorijum.vratiSve(param);
    }
    
     public List<TuristickiAgent> getLista() {
        return lista;
    }
    
}
