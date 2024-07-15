/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika;

import baza.DBBroker;
import domen.Hotel;
import domen.Putnik;
import domen.Putovanje;
import domen.Rezervacija;
import domen.TuristickiAgent;
import java.util.List;
import operacije.Hotel.SOUcitajListuHotela;
import operacije.Putnik.SOIzmeniPutnika;
import operacije.Putnik.SONadjiPutnike;
import operacije.Putnik.SOObrisiPutnika;
import operacije.Putnik.SOUcitajListuPutnika;
import operacije.Putnik.SOUcitajPutnika;
import operacije.Putnik.SOZapamtiPutnika;
import operacije.Putovanje.SOIzmeniPutovanje;
import operacije.Putovanje.SONadjiPutovanja;
import operacije.Putovanje.SOUcitajListuPutovanja;
import operacije.Putovanje.SOUcitajPutovanje;
import operacije.Putovanje.SOZapamtiPutovanje;
import operacije.Rezervacija.SOIzmeniRezervaciju;
import operacije.Rezervacija.NadjiRezervacije;
import operacije.Rezervacija.SOUcitajListuRezervacija;
import operacije.Rezervacija.SOUcitajRezervaciju;
import operacije.Rezervacija.SOZapamtiRezervaciju;
import repozitorijum.Repozitorijum;

/**
 *
 * @author Korisnik
 */
public class Kontroler {
     private static Kontroler instance;
    private DBBroker dbb;
    private final Repozitorijum repozitorijum;

    public Kontroler() {
        this.repozitorijum = new DBBroker();
    }

    public static Kontroler getInstance() {
        if(instance == null){
            instance = new Kontroler();
        }
        return instance;
    }

    public TuristickiAgent login(String korisnickoIme, String lozinka) throws Exception {
        List<TuristickiAgent> listaT = repozitorijum.vratiSve(new TuristickiAgent());
        for(TuristickiAgent t : listaT){
            if(t.getKorisnickoIme().equals(korisnickoIme) && t.getLozinka().equals(lozinka)){
                return t;
            }
        }
        throw new Exception("Ne postoji turisticki agent sa ovim kredencijalima!");
        
        
    }

    public void zapamtiPutnika(Putnik putnikZaCuvanje) throws Exception {
        (new SOZapamtiPutnika()).izvrsi(putnikZaCuvanje);
    }

    public List<Putnik> vratiSvePutnike() throws Exception {
        SOUcitajListuPutnika lista = new SOUcitajListuPutnika();
        lista.izvrsi(new Putnik());
        return lista.getLista();
    }

    public Putnik vratiPutnika(Putnik putnikZaVracanje) throws Exception {
        SOUcitajPutnika putnik = new SOUcitajPutnika();
        putnik.izvrsi(putnikZaVracanje);
        return putnik.getPutnik();
    }

    public void izmeniPutnika(Putnik putnikZaCuvanje) throws Exception {
        (new SOIzmeniPutnika()).izvrsi(putnikZaCuvanje);
    }

    public Object pretraziPutnike(Putnik pretraziPutnike) throws Exception {
        SONadjiPutnike np = new SONadjiPutnike();
        np.izvrsi(pretraziPutnike);
        return np.getLista();
    }

    public void obrisiPutnika(Putnik putnikZaBrisanje) throws Exception {
        (new SOObrisiPutnika()).izvrsi(putnikZaBrisanje);
    }

    public List<Hotel> vratiHotele() throws Exception {
        SOUcitajListuHotela lista = new SOUcitajListuHotela();
        lista.izvrsi(new Hotel());
        return lista.getLista();
    }

    public void zapamtiPutovanje(Putovanje putovanjeZaCuvanje) throws Exception {
        (new SOZapamtiPutovanje()).izvrsi(putovanjeZaCuvanje);
    }

    public Object vratiSvaPutovanja() throws Exception {
        SOUcitajListuPutovanja lista = new SOUcitajListuPutovanja();
        lista.izvrsi(new Putovanje());
        return lista.getLista();
    }


    public Putovanje vratiPutovanje(Putovanje putovanjeZaVracanje) throws Exception {
        SOUcitajPutovanje putovanje = new SOUcitajPutovanje();
        putovanje.izvrsi(putovanjeZaVracanje);
        return putovanje.getPutovanje();
    }

    public void izmeniPutovanje(Putovanje putovanjeZaCuvanje) throws Exception {
        (new SOIzmeniPutovanje()).izvrsi(putovanjeZaCuvanje);
    }

    public Object pretraziPutovanja(Putovanje pretraziPutovanje) throws Exception {
        SONadjiPutovanja np = new SONadjiPutovanja();
        np.izvrsi(pretraziPutovanje);
        return np.getLista();
    }

    public Object vratiSveRezervacije() throws Exception {
        SOUcitajListuRezervacija lista = new SOUcitajListuRezervacija();
        lista.izvrsi(new Rezervacija());
        return lista.getLista();
    }

    public void zapamtiRezervaciju(Rezervacija rezervacijaZaCuvanje) throws Exception {
        (new SOZapamtiRezervaciju()).izvrsi(rezervacijaZaCuvanje);
    }

    public Object pretraziRezervacije(Rezervacija pretraziRezervacije) throws Exception {
        NadjiRezervacije np = new NadjiRezervacije();
        np.izvrsi(pretraziRezervacije);
        return np.getLista();
    }

    public Rezervacija vratiRezervaciju(Rezervacija rezervacijaZaVracanje) throws Exception {
        SOUcitajRezervaciju rezervacija = new SOUcitajRezervaciju();
        rezervacija.izvrsi(rezervacijaZaVracanje);
        return rezervacija.getRezervacija();
    }

    public void izmeniRezervaciju(Rezervacija rezervacijaZaCuvanje) throws Exception {
        (new SOIzmeniRezervaciju()).izvrsi(rezervacijaZaCuvanje);
    }
}
