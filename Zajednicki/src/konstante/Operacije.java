/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package konstante;

/**
 *
 * @author Korisnik
 */
public interface Operacije {
    //Turisticki agent
    public static final int LOGIN = 1;
    
    //Putnik
    public static final int ZAPAMTI_PUTNIKA = 2;
    public static final int VRATI_SVE_PUTNIKE = 3;
    public static final int VRATI_PUTNIKA = 4;
    public static final int PRETRAZI_PUTNIKE = 5;
    public static final int OBRISI_PUTNIKA = 6;
    
    //Hotel
    public static final int VRATI_HOTELE = 7;
    
    //Putovanje
    public static final int ZAPAMTI_PUTOVANJE = 8;
    public static final int VRATI_SVA_PUTOVANJA = 9;
    public static final int VRATI_PUTOVANJE = 10;
    public static final int PRETRAZI_PUTOVANJA = 11;
    
    //Rezervacija
    public static final int VRATI_SVE_REZERVACIJE = 12;
    public static final int ZAPAMTI_REZERVACIJU = 13;
    public static final int PRETRAZI_REZERVACIJE = 14;
    public static final int VRATI_REZERVACIJU = 15;
}
