/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forme.putovanje;

import domen.Hotel;
import domen.Putovanje;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kontroler.Komunikacija;

/**
 *
 * @author Korisnik
 */
public class FrmNovoPutovanje extends javax.swing.JDialog {

    Putovanje putovanje;
    
    /**
     * Creates new form NovoPutovanje
     */
    public FrmNovoPutovanje(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        popuniCbHotel();
        
    }
    
    public void setPutovanje(Putovanje p){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        this.putovanje = p;
        Hotel h = p.getHotel();
        
//        for (int i = 0; i < cbHotel.getItemCount(); i++) {
//        Hotel hotel = (Hotel) cbHotel.getItemAt(i);
//        System.out.println("Comparing: " + h + " and " + hotel);
//            if (h.equals(hotel)) {
//        System.out.println("Found a match!");
//        break;
//        }
//     }
     
        cbHotel.setSelectedItem(h);
        cbPrevoz.setSelectedItem(p.getPrevoz());
        txtBrojNoci.setText(String.valueOf(p.getBrojNoci()));
        txtCena.setText(String.valueOf(p.getCena()));
        txtNaziv.setText(p.getNaziv());
        txtDatumPolaska.setText(sdf.format(p.getDatumPolaska()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbHotel = new javax.swing.JComboBox<>();
        cbPrevoz = new javax.swing.JComboBox<>();
        txtBrojNoci = new javax.swing.JTextField();
        txtCena = new javax.swing.JTextField();
        txtNaziv = new javax.swing.JTextField();
        txtDatumPolaska = new javax.swing.JTextField();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kreiraj putovanje", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setText("Hotel:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Prevoz:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setText("Broj noci:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setText("Cena:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setText("Naziv putovanja:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setText("Datum polaska:");

        cbHotel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbPrevoz.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Avion", "Autobus", "Voz", "Sopstveni prevoz" }));

        btnSacuvaj.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbHotel, 0, 325, Short.MAX_VALUE)
                    .addComponent(cbPrevoz, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBrojNoci)
                    .addComponent(txtCena)
                    .addComponent(txtNaziv)
                    .addComponent(txtDatumPolaska))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbPrevoz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBrojNoci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDatumPolaska, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
       SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        try {
        if(this.putovanje == null){
            this.putovanje = new Putovanje();
        }
        
        this.putovanje.setHotel((Hotel) cbHotel.getSelectedItem());
        this.putovanje.setPrevoz((String) cbPrevoz.getSelectedItem());
        this.putovanje.setBrojNoci(Integer.parseInt(txtBrojNoci.getText()));
        this.putovanje.setCena(Long.parseLong(txtCena.getText()));
        this.putovanje.setNaziv(txtNaziv.getText());
        this.putovanje.setDatumPolaska(sdf.parse(txtDatumPolaska.getText()));
        
        if(!validacija()){
            return;
        }
        
        Komunikacija.getInstance().zapamtiPutovanje(this.putovanje);
        
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio putovanje.");
        
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti putovanje.");
            Logger.getLogger(FrmNovoPutovanje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox<Object> cbHotel;
    private javax.swing.JComboBox<Object> cbPrevoz;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtBrojNoci;
    private javax.swing.JTextField txtCena;
    private javax.swing.JTextField txtDatumPolaska;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    private void popuniCbHotel() {
        try {
            ArrayList<Hotel> hoteli = Komunikacija.getInstance().vratiHotele();
            cbHotel.removeAllItems();
            
            for(Hotel h : hoteli){
                cbHotel.addItem(h);
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmNovoPutovanje.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    private boolean validacija() {
        if(txtBrojNoci.getText().isEmpty() || txtCena.getText().isEmpty() || txtNaziv.getText().isEmpty() || 
                txtDatumPolaska.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Morate da popunite sva polja");
            return false;
        }
        return true;
    }

}
