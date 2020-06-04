
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lenovo
 */
public class transaksi extends javax.swing.JFrame {

    /**
     * Creates new form transaksi
     */
    //private Konfig db = new Konfig();
    public void idPelToComboBox(){
        try{
            String sql = "SELECT*FROM pelanggan";
            java.sql.Connection conn = (Connection)Konfig.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                combo_pel.addItem(res.getString("id_pelanggan"));
            }
            res.last();
            int jumlah_data =res.getRow();
        }catch(SQLException e){
        }
    }
    public void idBarToComboBox(){
        try{
            String sql = "SELECT*FROM barang";
            java.sql.Connection conn = (Connection)Konfig.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                combo_bar.addItem(res.getString("id_barang"));
            }
            res.last();
            int jumlah_data =res.getRow();
        }catch(SQLException e){
        }
    }
    private void kosongkan_form(){
        txt_idtrans.setEditable(true);
        txt_idtrans.setText(null);
        combo_pel.setSelectedItem("--Pilih--");
        combo_bar.setSelectedItem("--Pilih--");
        txt_harga.setText(null);
        txt_jumlah.setText(null);
        txt_total.setText(null);
        txt_ket.setText(null);
    }
    private void tampilkan_data(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID Transaksi");
        model.addColumn("ID Pelanggan");
        model.addColumn("ID Barang");
        model.addColumn("Harga");
        model.addColumn("Jumlah");
        model.addColumn("Total");
        model.addColumn("Keterangan");
        try{
            int no = 1;
            String sql = "SELECT * FROM transaksi";
            java.sql.Connection conn = (Connection)Konfig.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{no++,res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6),
                    res.getString(7)});
            }
            tabeltrans.setModel(model);
        }catch(SQLException e){
            System.out.println("Eror: "+ e.getMessage());
        }
    }
    public transaksi(){
        initComponents();
        idPelToComboBox();
        idBarToComboBox();
        tampilkan_data();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabeltrans = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        label_idtrans = new javax.swing.JLabel();
        label_idpel = new javax.swing.JLabel();
        label_idbar = new javax.swing.JLabel();
        label_jumlah = new javax.swing.JLabel();
        label_harga = new javax.swing.JLabel();
        txt_harga = new javax.swing.JTextField();
        label_total = new javax.swing.JLabel();
        txt_idtrans = new javax.swing.JTextField();
        bt_save = new javax.swing.JButton();
        bt_cancel = new javax.swing.JButton();
        bt_edit = new javax.swing.JButton();
        bt_delete = new javax.swing.JButton();
        bt_back = new javax.swing.JButton();
        combo_pel = new javax.swing.JComboBox<>();
        combo_bar = new javax.swing.JComboBox<>();
        label_ket = new javax.swing.JLabel();
        txt_ket = new javax.swing.JTextField();
        txt_jumlah = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();

        jButton5.setText("jButton5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabeltrans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabeltrans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabeltransMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabeltrans);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 266, 490, 130));

        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Transaksi");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 11, -1, -1));

        label_idtrans.setText("ID Transaksi");
        jPanel1.add(label_idtrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 53, -1, -1));

        label_idpel.setText("ID Pelanggan");
        jPanel1.add(label_idpel, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 79, -1, -1));

        label_idbar.setText("ID Barang");
        jPanel1.add(label_idbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 105, -1, -1));

        label_jumlah.setText("Jumlah Barang");
        jPanel1.add(label_jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 155, -1, -1));

        label_harga.setText("Harga");
        jPanel1.add(label_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 128, -1, -1));
        jPanel1.add(txt_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 128, 180, -1));

        label_total.setText("Total");
        jPanel1.add(label_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 183, -1, -1));
        jPanel1.add(txt_idtrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 50, 180, -1));

        bt_save.setText("Save");
        bt_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_saveActionPerformed(evt);
            }
        });
        jPanel1.add(bt_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 237, -1, -1));

        bt_cancel.setText("Cancel");
        bt_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelActionPerformed(evt);
            }
        });
        jPanel1.add(bt_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 237, -1, -1));

        bt_edit.setText("Edit");
        bt_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editActionPerformed(evt);
            }
        });
        jPanel1.add(bt_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 237, -1, -1));

        bt_delete.setText("Delete");
        bt_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deleteActionPerformed(evt);
            }
        });
        jPanel1.add(bt_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 237, -1, -1));

        bt_back.setText("Back");
        bt_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_backActionPerformed(evt);
            }
        });
        jPanel1.add(bt_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 402, -1, -1));

        combo_pel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--" }));
        combo_pel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_pelActionPerformed(evt);
            }
        });
        jPanel1.add(combo_pel, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 76, 180, -1));

        combo_bar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--" }));
        combo_bar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_barActionPerformed(evt);
            }
        });
        jPanel1.add(combo_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 102, 180, -1));

        label_ket.setText("Keterangan");
        jPanel1.add(label_ket, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 209, -1, -1));
        jPanel1.add(txt_ket, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 206, 180, -1));
        jPanel1.add(txt_jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 154, 179, -1));
        jPanel1.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 180, 179, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combo_pelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_pelActionPerformed
        // TODO add your handling code here:
        idPelToComboBox();
    }//GEN-LAST:event_combo_pelActionPerformed

    private void bt_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_backActionPerformed
        // TODO add your handling code here:
        new home().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bt_backActionPerformed

    private void combo_barActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_barActionPerformed
        // TODO add your handling code here:
        idBarToComboBox();
    }//GEN-LAST:event_combo_barActionPerformed

    private void bt_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_saveActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "INSERT INTO transaksi VALUES ('"
                    +txt_idtrans.getText()+"','"
                    +combo_pel.getSelectedItem()+"','"
                    +combo_bar.getSelectedItem()+"','"
                    +txt_harga.getText()+"','"
                    +txt_jumlah.getText()+"','"
                    +txt_total.getText()+"','"
                    +txt_ket.getText()+"')";
            java.sql.Connection Conn = (Connection)Konfig.configDB();
            java.sql.PreparedStatement pstm = Conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null,"Proses simpan data berhasil");
            tampilkan_data();
            kosongkan_form();
       }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_bt_saveActionPerformed

    private void bt_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelActionPerformed
        // TODO add your handling code here:
        kosongkan_form();
    }//GEN-LAST:event_bt_cancelActionPerformed

    private void bt_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editActionPerformed
        // TODO add your handling code here:
         try{
            String sql = "UPDATE transaksi set id_transaksi ='"+txt_idtrans.getText()
                    +"',id_pelangganFK='"+combo_pel.getSelectedItem()
                    +"',id_barangFK='"+combo_bar.getSelectedItem()
                    +"',harga='"+txt_harga.getText()
                    +"',jumlah='"+txt_jumlah.getText()
                    +"',total='"+txt_total.getText()
                    +"',keterangan='"+txt_ket.getText()
                    +"' WHERE id_transaksi='"+txt_idtrans.getText()+"'";
            java.sql.Connection Conn = (Connection)Konfig.configDB();
            java.sql.PreparedStatement pstm = Conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null,"Edit data berhasil");
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampilkan_data();
        kosongkan_form();
    }//GEN-LAST:event_bt_editActionPerformed

    private void bt_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deleteActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "DELETE FROM transaksi WHERE id_transaksi='"+txt_idtrans.getText()+"'";
            java.sql.Connection conn =(Connection) Konfig.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Hapus data berhasil");
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampilkan_data();
        kosongkan_form();
    }//GEN-LAST:event_bt_deleteActionPerformed

    private void tabeltransMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeltransMouseClicked
        // TODO add your handling code here:
        int baris = tabeltrans.rowAtPoint(evt.getPoint());
        String idtrans = tabeltrans.getValueAt(baris,1).toString();
        txt_idtrans.setText(idtrans);
        
        String idpel = tabeltrans.getValueAt(baris,2).toString();
        combo_pel.setSelectedItem(idpel);
        
        String idbar = tabeltrans.getValueAt(baris,3).toString();
        combo_bar.setSelectedItem(idbar);
        
        String harga = tabeltrans.getValueAt(baris,4).toString();
        txt_harga.setText(harga);
        
        String jumlah = tabeltrans.getValueAt(baris,5).toString();
        txt_jumlah.setText(jumlah);
        
        String total = tabeltrans.getValueAt(baris,6).toString();
        txt_total.setText(total);
        
        String keterangan = tabeltrans.getValueAt(baris,7).toString();
        txt_ket.setText(keterangan);
    }//GEN-LAST:event_tabeltransMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_back;
    private javax.swing.JButton bt_cancel;
    private javax.swing.JButton bt_delete;
    private javax.swing.JButton bt_edit;
    private javax.swing.JButton bt_save;
    private javax.swing.JComboBox<String> combo_bar;
    private javax.swing.JComboBox<String> combo_pel;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_harga;
    private javax.swing.JLabel label_idbar;
    private javax.swing.JLabel label_idpel;
    private javax.swing.JLabel label_idtrans;
    private javax.swing.JLabel label_jumlah;
    private javax.swing.JLabel label_ket;
    private javax.swing.JLabel label_total;
    private javax.swing.JTable tabeltrans;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_idtrans;
    private javax.swing.JTextField txt_jumlah;
    private javax.swing.JTextField txt_ket;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
