/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domen.Hotel;
import domen.Putnik;
import domen.Putovanje;
import domen.Rezervacija;
import domen.TuristickiAgent;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import konstante.Operacije;
import transfer.KlijentskiZahtev;
import transfer.Posiljalac;
import transfer.Primalac;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Korisnik
 */
public class Komunikacija {
    private static Komunikacija instance;
    private Socket socket;
    private Posiljalac posiljalac;
    private Primalac primalac;

    public Komunikacija() throws IOException {
            socket = new Socket("localhost", 9000);
            posiljalac = new Posiljalac(socket);
            primalac = new Primalac(socket);
    }

    public static Komunikacija getInstance() throws IOException {
        if(instance == null){
            instance = new Komunikacija();
        }
        return instance;
    }

    public TuristickiAgent login(String korisnickoIme, String lozinka) throws Exception {
        TuristickiAgent turistickiAgent = new TuristickiAgent();
        turistickiAgent.setKorisnickoIme(korisnickoIme);
        turistickiAgent.setLozinka(lozinka);
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.LOGIN, turistickiAgent);
        posiljalac.posalji(kz);
        ServerskiOdgovor so = (ServerskiOdgovor)primalac.primi();
        if(so.getException()==null){
            return (TuristickiAgent)so.getOdgovor();
        }else{
            throw so.getException();
        }
    }

    public void zapamtiPutnika(Putnik p) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.ZAPAMTI_PUTNIKA, p);
        posiljalac.posalji(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primi();
        
        if(so.getException() != null){
            throw so.getException();
        }
    }

    public Putnik ucitajPutnika(Putnik p) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.VRATI_PUTNIKA, p);
        posiljalac.posalji(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primi();
        
        if(so.getException() != null){
            throw so.getException();
        }
        
        return (Putnik) so.getOdgovor();
    }


    public ArrayList<Putnik> ucitajListuPutnika() throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.VRATI_SVE_PUTNIKE, null);
        posiljalac.posalji(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primi();
        if(so.getException() == null){
            return (ArrayList<Putnik>) so.getOdgovor();
        }else{
            throw so.getException();
        }
    }

    public ArrayList<Putnik> ucitajListuPutnika(Putnik putnik) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.PRETRAZI_PUTNIKE, putnik);
        posiljalac.posalji(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primi();
        if(so.getException() == null){
            return (ArrayList<Putnik>) so.getOdgovor();
        }else{
            throw so.getException();
        }
    }

    public void obrisiPutnika(Putnik p) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.OBRISI_PUTNIKA, p);
        posiljalac.posalji(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primi();
        if(so.getException() != null){
            throw so.getException();
        }
    }

    public ArrayList<Hotel> vratiHotele() throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.VRATI_HOTELE, null);
        posiljalac.posalji(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primi();
        if(so.getException() == null){
            return (ArrayList<Hotel>) so.getOdgovor();
        }else{
            throw so.getException();
        }
    }

    public void zapamtiPutovanje(Putovanje putovanje) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.ZAPAMTI_PUTOVANJE, putovanje);
        posiljalac.posalji(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primi();
        
        if(so.getException() != null){
            throw so.getException();
        }
    }

    public ArrayList<Putovanje> ucitajListuPutovanja() throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.VRATI_SVA_PUTOVANJA, null);
        posiljalac.posalji(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primi();
        if(so.getException() == null){
            return (ArrayList<Putovanje>) so.getOdgovor();
        }else{
            throw so.getException();
        }
    }

    public Putovanje ucitajPutovanje(Putovanje p) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.VRATI_PUTOVANJE, p);
        posiljalac.posalji(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primi();
        
        if(so.getException() != null){
            throw so.getException();
        }
        
        return (Putovanje) so.getOdgovor();
    }

    public ArrayList<Putovanje> ucitajListuPutovanja(Putovanje p) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.PRETRAZI_PUTOVANJA, p);
        posiljalac.posalji(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primi();
        if(so.getException() == null){
            return (ArrayList<Putovanje>) so.getOdgovor();
        }else{
            throw so.getException();
        }
    }

    public ArrayList<Rezervacija> ucitajListuRezervacija() throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.VRATI_SVE_REZERVACIJE, null);
        posiljalac.posalji(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primi();
        if(so.getException() == null){
            return (ArrayList<Rezervacija>) so.getOdgovor();
        }else{
            throw so.getException();
        }
    }

    public void zapamtiRezervaciju(Rezervacija rezervacija) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.ZAPAMTI_REZERVACIJU, rezervacija);
        posiljalac.posalji(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primi();
        
        if(so.getException() != null){
            throw so.getException();
        }
    }

    public ArrayList<Rezervacija> ucitajListuRezervacija(Rezervacija r) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.PRETRAZI_REZERVACIJE, r);
        posiljalac.posalji(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primi();
        if(so.getException() == null){
            return (ArrayList<Rezervacija>) so.getOdgovor();
        }else{
            throw so.getException();
        }
    }

    public Rezervacija ucitajRezervaciju(Rezervacija r) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.VRATI_REZERVACIJU, r);
        posiljalac.posalji(kz);
        ServerskiOdgovor so = (ServerskiOdgovor) primalac.primi();
        
        if(so.getException() != null){
            throw so.getException();
        }
        
        return (Rezervacija) so.getOdgovor();
    }
    
}
