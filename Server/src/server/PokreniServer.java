/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import baza.Konekcija;
import domen.TuristickiAgent;
import forme.ServerskaForma;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import niti.ObradaKlijentskihZahteva;

/**
 *
 * @author Korisnik
 */
public class PokreniServer  extends Thread{
    
    private ServerSocket serverSocket;
    ServerskaForma sf;
    private List<ObradaKlijentskihZahteva> okz;

//    public PokreniServer() {
//    }

    public PokreniServer(ServerskaForma sf) {
        this.sf = sf;
        this.okz = new ArrayList<>();
    }

    
    
    
    @Override
    public void run() {
        try {
            this.serverSocket = new ServerSocket(9000);
            while (true) {

                System.out.println("Cekanje na konekciju...");
                Socket socket = serverSocket.accept();
                System.out.println("Klijent se povezao!");
                obradaKlijentskogZahteva(socket);
            }
        } catch (Exception ex) {
           // ex.printStackTrace();
            System.out.println("Server je ugasen.");
        }

    }

    private void obradaKlijentskogZahteva(Socket socket) throws Exception {
        ObradaKlijentskihZahteva nit = new ObradaKlijentskihZahteva(socket);
        nit.setPokreniServer(this);
        nit.start();
        this.okz.add(nit);
    }
    
    public void stopServer() throws SQLException, IOException
    {
        for(ObradaKlijentskihZahteva zahtev : this.okz) {
            zahtev.stopHandler();
        }
        
        if(serverSocket != null && !serverSocket.isClosed()) {
            serverSocket.close();
            serverSocket = null;
        }
            
        Konekcija.getInstance().disconnect();
    }
    
    public void refreshUlogovane()
    {
        this.sf.refreshList();
    }
    
    public void removeOkz(ObradaKlijentskihZahteva o)
    {
        this.okz.remove(o);
    }

    

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public ServerskaForma getSf() {
        return sf;
    }

    public void setSf(ServerskaForma sf) {
        this.sf = sf;
    }
    
    public List<TuristickiAgent> vratiUlogovane()
    {
        List<TuristickiAgent> lista = new ArrayList<>();
        for(ObradaKlijentskihZahteva o : this.okz) {
            if(o.vratiUlogovanogAgenta()!= null) {
                lista.add(o.vratiUlogovanogAgenta());
            }
        }
        return lista;
    }
    
    
    
}
