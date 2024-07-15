/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import domen.Putnik;
import domen.Putovanje;
import domen.Rezervacija;
import domen.TuristickiAgent;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Operacije;
import logika.Kontroler;
import server.PokreniServer;
import transfer.KlijentskiZahtev;
import transfer.Posiljalac;
import transfer.Primalac;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Korisnik
 */
public class ObradaKlijentskihZahteva extends Thread{
    TuristickiAgent ulogovan;
    Socket socket;
    Posiljalac posiljalac;
    Primalac primalac;
    PokreniServer server;

    public ObradaKlijentskihZahteva(Socket socket) {
        this.socket = socket;        
        posiljalac = new Posiljalac(socket);
        primalac = new Primalac(socket);
    }

    public void stopHandler() throws IOException
    {
        if(this.socket != null) {
            if(!this.socket.isClosed()) {
                this.socket.close();
            }
        }
    }
    
    public void setPokreniServer(PokreniServer server) {
        this.server = server;
    }
    
    public TuristickiAgent vratiUlogovanogAgenta() {
        return ulogovan;
    }
    
    @Override
    public void run() {
        

        while (true) {
            try {
                KlijentskiZahtev kz = (KlijentskiZahtev) primalac.primi();
                ServerskiOdgovor so = new ServerskiOdgovor();
                try {
                    switch (kz.getOperacija()) {
                         case Operacije.LOGIN:
                            TuristickiAgent turistickiAgent = (TuristickiAgent) kz.getParametar();
                            TuristickiAgent ta = Kontroler.getInstance().login(turistickiAgent.getKorisnickoIme(), turistickiAgent.getLozinka());
                            so.setOdgovor(ta);
                            this.ulogovan = ta;
                            this.server.refreshUlogovane();
                            break;
                         case Operacije.ZAPAMTI_PUTNIKA:
                             Putnik putnikZaCuvanje = (Putnik) kz.getParametar();
                             if(putnikZaCuvanje.getId() != 0){
                                Kontroler.getInstance().izmeniPutnika(putnikZaCuvanje);
                             }else{
                                 Kontroler.getInstance().zapamtiPutnika(putnikZaCuvanje);
                             }
                             so.setOdgovor(putnikZaCuvanje);
                             break;
                         case Operacije.VRATI_SVE_PUTNIKE:
                             so.setOdgovor(Kontroler.getInstance().vratiSvePutnike());
                             break;
                         case Operacije.VRATI_PUTNIKA:
                             Putnik putnikZaVracanje = (Putnik) kz.getParametar();
                             so.setOdgovor(Kontroler.getInstance().vratiPutnika(putnikZaVracanje));
                             break;
                        case Operacije.PRETRAZI_PUTNIKE:
                            Putnik pretraziPutnike = (Putnik) kz.getParametar();
                             so.setOdgovor(Kontroler.getInstance().pretraziPutnike(pretraziPutnike));
                             break;
                        case Operacije.OBRISI_PUTNIKA:
                            Putnik putnikZaBrisanje = (Putnik) kz.getParametar();
                            Kontroler.getInstance().obrisiPutnika(putnikZaBrisanje);
                            so.setOdgovor(putnikZaBrisanje);
                            break;
                        case Operacije.VRATI_HOTELE:
                            so.setOdgovor(Kontroler.getInstance().vratiHotele());
                            break;
                        case Operacije.ZAPAMTI_PUTOVANJE:
                            Putovanje putovanjeZaCuvanje = (Putovanje) kz.getParametar();
                            if(putovanjeZaCuvanje.getId() != 0){
                                Kontroler.getInstance().izmeniPutovanje(putovanjeZaCuvanje);
                             }else{
                            Kontroler.getInstance().zapamtiPutovanje(putovanjeZaCuvanje);
                            }
                            so.setOdgovor(putovanjeZaCuvanje);
                            break;
                        case Operacije.VRATI_SVA_PUTOVANJA:
                             so.setOdgovor(Kontroler.getInstance().vratiSvaPutovanja());
                             break;
                        case Operacije.VRATI_PUTOVANJE:
                             Putovanje putovanjeZaVracanje = (Putovanje) kz.getParametar();
                             so.setOdgovor(Kontroler.getInstance().vratiPutovanje(putovanjeZaVracanje));
                             break;
                        case Operacije.PRETRAZI_PUTOVANJA:
                            Putovanje pretraziPutovanje = (Putovanje) kz.getParametar();
                             so.setOdgovor(Kontroler.getInstance().pretraziPutovanja(pretraziPutovanje));
                             break;
                        case Operacije.VRATI_SVE_REZERVACIJE:
                             so.setOdgovor(Kontroler.getInstance().vratiSveRezervacije());
                             break;
                        case Operacije.ZAPAMTI_REZERVACIJU:
                            Rezervacija rezervacijaZaCuvanje = (Rezervacija) kz.getParametar();
                            if(rezervacijaZaCuvanje.getId() != 0){
                                Kontroler.getInstance().izmeniRezervaciju(rezervacijaZaCuvanje);
                             }else{
                            Kontroler.getInstance().zapamtiRezervaciju(rezervacijaZaCuvanje);
                            }
                            so.setOdgovor(rezervacijaZaCuvanje);
                            break;
                        case Operacije.PRETRAZI_REZERVACIJE:
                            Rezervacija pretraziRezervacije = (Rezervacija) kz.getParametar();
                             so.setOdgovor(Kontroler.getInstance().pretraziRezervacije(pretraziRezervacije));
                             break;
                        case Operacije.VRATI_REZERVACIJU:
                             Rezervacija rezervacijaZaVracanje = (Rezervacija) kz.getParametar();
                             so.setOdgovor(Kontroler.getInstance().vratiRezervaciju(rezervacijaZaVracanje));
                             break;
                    }
                } catch (Exception e) {
                    so.setException(e);
                    Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, e);
                }
                     posiljalac.posalji(so);
//                    e.printStackTrace();
//                    so.setException(e);
                
                
            } catch (Exception ex) {
                this.ulogovan = null;
                this.server.refreshUlogovane();
                this.server.removeOkz(this);
                try {
                    this.socket.close();
                    this.socket = null;
                } catch(IOException exc){ }
                Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                break;
            }
        }
    }

    
}
