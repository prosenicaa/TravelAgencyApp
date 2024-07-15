/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Rezervacija;
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
public class ModelTabeleRezervacija extends AbstractTableModel{
    private final String[] kolone = {"Br. rezervacije", "Putovanje", "Broj pasosa", "Putnik", "Datum", "Status", "Turisticki agent"};
    private List<Rezervacija> rezervacije;

    public ModelTabeleRezervacija() {
    }

    public ModelTabeleRezervacija(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    
    
    @Override
    public int getRowCount() {
        return rezervacije.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
            try {
        Rezervacija r = rezervacije.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        
        switch(columnIndex){
            case 0: return r.getBrojRezervacije();
            case 1: return r.getPutovanje() != null ? r.getPutovanje().getNaziv() : "N/A";
            case 2: return r.getPutnik() != null ? r.getPutnik().getBrojPasosa() : "N/A";
            case 3: return r.getPutnik() != null ? r.getPutnik().toString() : "N/A";
            case 4: return r.getDatumRezervacije() != null ? sdf.format(r.getDatumRezervacije()) : "N/A";
            case 5: return r.getStatus();
            case 6: return r.getTuristickiAgent() != null ? r.getTuristickiAgent().toString() : "N/A";
            default:
                return "n/a";
        }
        } catch (Exception ex) {
             System.out.println("aaaaa");
             Logger.getLogger(ModelTabeleRezervacija.class.getName()).log(Level.SEVERE, null, ex);
         }
     return "NA";
    }
    
    @Override
    public String getColumnName(int column) {
        if (column>kolone.length) return "n/a";
        return kolone[column]; 
    }

    public Rezervacija vratiRezervaciju(int i) {
        return rezervacije.get(i);
    }

    public void setRezervaciju(ArrayList<Rezervacija> lista) {
        rezervacije = lista;
    }

    public void obrisiRezervaciju(int i) {
        rezervacije.remove(i);
        fireTableDataChanged();
    }
    
}
