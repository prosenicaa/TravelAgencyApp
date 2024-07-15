/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Korisnik
 */
public class Posiljalac {
    private Socket socket;

    public Posiljalac (Socket socket) {
        this.socket = socket;
    }
    
    public void posalji(Object object) throws Exception{
        try {
            ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(object);
            out.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Greska prilikom slanja objekta.\n"+ex.getMessage());
        }
    }
}
