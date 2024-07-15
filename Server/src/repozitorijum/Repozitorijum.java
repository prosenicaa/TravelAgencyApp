/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repozitorijum;

import java.util.List;

/**
 *
 * @author Korisnik
 */
public interface Repozitorijum<T> {
    List<T> vratiSve(T param) throws Exception;
    void dodaj(T param) throws Exception;
    void izmeni(T param) throws Exception;
    void obrisi(T param)throws Exception;
    List<T> vratiSve();
}
