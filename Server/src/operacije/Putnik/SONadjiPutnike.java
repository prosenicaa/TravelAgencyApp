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
public class SONadjiPutnike extends ApstraktnaOperacija{

    private List<Putnik> lista;

    @Override
    protected void preduslovi(Object param) throws Exception {
         if (param == null){
         throw new Exception("PUTNIK NULL");
         }
         if(!(param instanceof Putnik)){
                throw new Exception("Netacni podaci za putnika!");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param) throws Exception {
        this.lista = this.repozitorijum.vratiSve(param);
    }
    
    public List<Putnik> getLista() {
        return lista;
    }
    
}
