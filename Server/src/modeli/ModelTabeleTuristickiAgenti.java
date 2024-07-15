/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.TuristickiAgent;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class ModelTabeleTuristickiAgenti extends AbstractTableModel{
    List<TuristickiAgent> agenti;
    String[] kolone = {"Ime", "Prezime", "Korisnicko ime"};

    public ModelTabeleTuristickiAgenti(List<TuristickiAgent> agenti) {
        this.agenti = agenti;
    }
    
    
    
    @Override
    public int getRowCount() {
        return agenti.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TuristickiAgent t = agenti.get(rowIndex);
        switch(columnIndex){
            case 0: return t.getIme();
            case 1: return t.getPrezime();
            case 2: return t.getKorisnickoIme();
            default:
                return "n/a";
        }
    }
    
     @Override
    public String getColumnName(int column) {
        if (column>kolone.length) return "n/a";
        return kolone[column]; 
    }
    
    public TuristickiAgent getTuristickiAgentAt(int i) {
        return this.agenti.get(i);
    }
    
    public void obrisiTuristickogAgenta(int i) {
        this.agenti.remove(i);
    }
    
    public int count() {
        return this.agenti.size();
    }
    
    
}
