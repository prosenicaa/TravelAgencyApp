/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Putnik;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class ModelTabelePutnik extends AbstractTableModel{
    private final String[] kolone = {"Ime", "Prezime", "Broj pasosa", "Email", "Telefon"};
    private List<Putnik> putnici;

    public ModelTabelePutnik() {
        putnici = new ArrayList<>();
        
    }

    public ModelTabelePutnik(ArrayList<Putnik> lista) {
        putnici = lista;
    }

    @Override
    public int getRowCount() {
        return putnici.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Putnik p = putnici.get(rowIndex);
        switch(columnIndex){
            case 0: return p.getIme();
            case 1: return p.getPrezime();
            case 2: return p.getBrojPasosa();
            case 3: return p.getEmail();
            case 4: return p.getTelefon();
            default:
                return "n/a";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        if (column>kolone.length) return "n/a";
        return kolone[column]; 
    }

    public Putnik vratiPutnika(int i) {
        return putnici.get(i);
    }

    public void setPutnici(ArrayList<Putnik> lista) {
        putnici = lista;
    }

    public void obrisiPutnika(int i) {
        putnici.remove(i);
        fireTableDataChanged();
    }
    
    
    
}
