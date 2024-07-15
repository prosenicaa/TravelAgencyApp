/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repozitorijum;

import baza.*;

/**
 *
 * @author Korisnik
 */
public interface DBRepozitorijum<T> extends Repozitorijum<T> {
      default public void connect() throws Exception{
        Konekcija.getInstance().otvoriKonekciju();
    }
    
    default public void disconnect() throws Exception{
        Konekcija.getInstance().otvoriKonekciju().close();
    }
    
    default public void commit() throws Exception{
        Konekcija.getInstance().otvoriKonekciju().commit();
    }
    
    default public void rollback() throws Exception{
        Konekcija.getInstance().otvoriKonekciju().rollback();
    }
}
