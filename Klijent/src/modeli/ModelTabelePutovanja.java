/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Putovanje;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class ModelTabelePutovanja extends AbstractTableModel{
     private final String[] kolone = {"Naziv putovanja", "Hotel", "Destinacija" ,"Broj noci", "Cena", "Datum polaska", "Prevoz"};
    private List<Putovanje> putovanja;

    public ModelTabelePutovanja() {
        putovanja = new ArrayList<>();
        
    }

    public ModelTabelePutovanja(ArrayList<Putovanje> lista) {
        putovanja = lista;
    }


    @Override
    public int getRowCount() {
        return putovanja.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
public Object getValueAt(int rowIndex, int columnIndex) {
    try {
    Putovanje p = putovanja.get(rowIndex);
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        
        
    switch (columnIndex) {
        case 0: return p.getNaziv();
        case 1:
            return p.getHotel() != null ? p.getHotel().getNaziv()  : "N/A";
        case 2:
            return p.getHotel().getMesto().getNaziv();
        case 3:
            return p.getBrojNoci();
        case 4:
            return p.getCena();
        case 5:
            return p.getDatumPolaska() != null ? sdf.format(p.getDatumPolaska()) : "N/A";
        case 6: return p.getPrevoz();
        
        default:
            return "N/A";
    }
     } catch (Exception ex) {
             //System.out.println("greska u modelu");
             Logger.getLogger(ModelTabelePutovanja.class.getName()).log(Level.SEVERE, null, ex);
         }
     return "NA";
}

    
    @Override
    public String getColumnName(int column) {
        if (column>kolone.length) return "n/a";
        return kolone[column]; 
    }

    public Putovanje vratiPutovanje(int i) {
        return putovanja.get(i);
    }

    public void setPutovanje(ArrayList<Putovanje> lista) {
        putovanja = lista;
    }

    public void obrisiPutovanje(int i) {
        putovanja.remove(i);
        fireTableDataChanged();
    }
}
