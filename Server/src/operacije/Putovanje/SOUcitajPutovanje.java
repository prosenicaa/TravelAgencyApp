/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.Putovanje;

import domen.Hotel;
import domen.Mesto;
import domen.Putovanje;
import java.util.List;
import operacije.ApstraktnaOperacija;

/**
 *
 * @author Korisnik
 */
public class SOUcitajPutovanje extends ApstraktnaOperacija{

    private Putovanje putovanje;

    @Override
    protected void preduslovi(Object param) throws Exception {
         if (param == null || !(param instanceof Putovanje)) {
            throw new Exception("Netacni podaci za putovanje!");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param) throws Exception {
        this.putovanje = null;
        
        List<Putovanje> bs = this.repozitorijum.vratiSve((Putovanje) param);
        
            System.out.println("vracena putovanja");
            for(Putovanje putovanje : bs){
            Hotel h = putovanje.getHotel();
            
            if(h != null && h.getHotelID() != 0){
                List<Hotel> hoteli = this.repozitorijum.vratiSve(h);
                System.out.println("vraceni hoteli");
                for(Hotel hotel : hoteli){
                    Mesto m = hotel.getMesto();
                    
                    if(m != null && m.getMestoID() != 0){
                        hotel.setMesto((Mesto) this.repozitorijum.vratiSve(m).get(0));
                        System.out.println("postavljeno mesto");
                    }
                }
                putovanje.setHotel(hoteli.get(0));
                System.out.println("postavljen hotel"); 
            }
        
        }
        
        
        if(!bs.isEmpty()) {
            this.putovanje = bs.get(0);
        }
    }
    
    public Putovanje getPutovanje() {
        return putovanje;
    }
    
}
