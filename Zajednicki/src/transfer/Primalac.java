/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author Korisnik
 */
public class Primalac {
     private Socket socket;

    public Primalac(Socket socket) {
        this.socket = socket;
    }
    
    public Object primi() throws Exception{
        try {
            ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Greska prilikom primanja objekta.\n"+ex.getMessage());
        }
    }
    
}
