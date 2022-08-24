/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi;

import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
/**
 *
 * @author user
 */
public class Nilai extends javax.swing.JPanel {

    /**
     * Creates new form Nilai
     */
    
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    
    protected void kosong(){
        CbRelasiNis.setSelectedIndex(0);
        CbRelasiKdKelas.setSelectedIndex(0);
        CbRelasiKdMapel.setSelectedIndex(0);
        tTugasHarian.setText("");
        tUts.setText("");
        tUas.setText("");
    }
    
    protected void statusKosong(){
        nilaiAkhir.setText("");
        statusKet.setText("");
        panelStatusNilai.setVisible(false);
    }
    
    protected void datatable(){
        Object[] Baris = {
            "nis",
            "kd_kelas",
            "kd_mapel",
            "tugas_harian",
            "uts",
            "uas",
            "nilai_akhir",
            "keterangan"
        };
        
        tabmode = new DefaultTableModel(null, Baris);
        tableKelas.setModel(tabmode);

        String sql = "SELECT * FROM nilai";
        
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("nis");
                String b = hasil.getString("kd_kelas");
                String c = hasil.getString("kd_mapel");
                String d = hasil.getString("tugas_harian");
                String e = hasil.getString("uts");
                String f = hasil.getString("uas");
                String g = hasil.getString("nilai_akhir");
                String h = hasil.getString("keterangan");
                
                String[] data={a, b, c, d, e, f, g, h};
                tabmode.addRow(data);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    protected void getRelasiNis(){
     
        String sql = "SELECT DISTINCT siswa.nis FROM siswa left join nilai On siswa.nis = nilai.nis;";
        
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("siswa.nis");
                
                String[] data={a};
                CbRelasiNis.addItem(a);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    protected void getRelasiKdKelas(){
     
        String sql = "SELECT DISTINCT absen.kd_kelas FROM absen left join nilai On absen.kd_kelas = nilai.kd_kelas;";
        
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("absen.kd_kelas");
                
                String[] data={a};
                CbRelasiKdKelas.addItem(a);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    protected void getRelasiKdMapel(){
     
        String sql = "SELECT DISTINCT pelajaran.kd_mapel FROM pelajaran left join nilai On pelajaran.kd_mapel = nilai.kd_mapel";
        
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("pelajaran.kd_mapel");
                
                String[] data={a};
                CbRelasiKdMapel.addItem(a);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    protected double getHitung(){
            
            int nilaiTugas = Integer.parseInt(tTugasHarian.getText());
            int nilaiUts = Integer.parseInt(tUts.getText());
            int nilaiUas = Integer.parseInt(tUas.getText());
            
            double akhir = ((0.2*nilaiTugas)+(0.3*nilaiUts)+(0.5*nilaiUas));
            
            return akhir;
    }
    
    protected String getKet(){
        double hitung = getHitung();
        String Ket = "";
        
        if((hitung >= 75) && (hitung <= 100)){
            Ket = "Lulus";
        }else if ((hitung >= 45 )&&(hitung < 75)){
            Ket = "Remedial";
        }else if ((hitung >= 0)&&(hitung < 45)){
            Ket = "Tidak Lulus";
        }
        
        return Ket;
    }
    
    protected void statusHitung(){
        panelStatusNilai.setVisible(true);
        statusNilai.setText(" "+getHitung());
        statusKet.setText(" "+getKet());
    }
    
    public Nilai() {
        initComponents();
        datatable();
        getRelasiNis();
        getRelasiKdKelas();
        getRelasiKdMapel();
        panelStatusNilai.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        Judul1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        nis = new javax.swing.JLabel();
        kdKelas = new javax.swing.JLabel();
        kdMapel = new javax.swing.JLabel();
        CbRelasiNis = new javax.swing.JComboBox<>();
        CbRelasiKdKelas = new javax.swing.JComboBox<>();
        CbRelasiKdMapel = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        judul2 = new javax.swing.JLabel();
        tugasHarian = new javax.swing.JLabel();
        uts = new javax.swing.JLabel();
        tUas = new javax.swing.JTextField();
        uas = new javax.swing.JLabel();
        tTugasHarian = new javax.swing.JTextField();
        tUts = new javax.swing.JTextField();
        panelStatusNilai = new javax.swing.JPanel();
        nilaiAkhir = new javax.swing.JLabel();
        keterangan = new javax.swing.JLabel();
        statusNilai = new javax.swing.JLabel();
        statusKet = new javax.swing.JLabel();
        bClear = new javax.swing.JButton();
        bSimpan = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        bEdit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableKelas = new javax.swing.JTable();

        jScrollPane1.setViewportView(jEditorPane1);

        setBackground(new java.awt.Color(255, 71, 71));

        Judul1.setBackground(new java.awt.Color(255, 255, 255));
        Judul1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Judul1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Judul1.setText("FORM NILAI");
        Judul1.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        nis.setText("Nama Siswa (input NIS)");

        kdKelas.setText("Kode Kelas");

        kdMapel.setText("Kode Pelajaran");

        CbRelasiNis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih NIS Siswa -" }));

        CbRelasiKdKelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kode Kelas -" }));

        CbRelasiKdMapel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kode Pelajaran -" }));

        jPanel1.setBackground(new java.awt.Color(0, 255, 204));

        judul2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        judul2.setText("Peniliaian");
        judul2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        tugasHarian.setText("Tugas Harian");

        uts.setText("UTS");

        tUas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tUasActionPerformed(evt);
            }
        });

        uas.setText("UAS");

        tTugasHarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tTugasHarianActionPerformed(evt);
            }
        });

        tUts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tUtsActionPerformed(evt);
            }
        });

        panelStatusNilai.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        nilaiAkhir.setText(" Nilai Akhir      :");

        keterangan.setText("Keterangan    :");

        statusNilai.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        statusNilai.setText(" ");

        statusKet.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        statusKet.setText(" ");

        javax.swing.GroupLayout panelStatusNilaiLayout = new javax.swing.GroupLayout(panelStatusNilai);
        panelStatusNilai.setLayout(panelStatusNilaiLayout);
        panelStatusNilaiLayout.setHorizontalGroup(
            panelStatusNilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelStatusNilaiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelStatusNilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(keterangan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelStatusNilaiLayout.createSequentialGroup()
                        .addComponent(nilaiAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelStatusNilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(statusNilai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(statusKet, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        panelStatusNilaiLayout.setVerticalGroup(
            panelStatusNilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStatusNilaiLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelStatusNilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nilaiAkhir)
                    .addComponent(statusNilai, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelStatusNilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keterangan)
                    .addComponent(statusKet, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelStatusNilai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tugasHarian)
                            .addComponent(uts)
                            .addComponent(uas))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tUas, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tUts, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tTugasHarian, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 86, Short.MAX_VALUE))
                    .addComponent(judul2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judul2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tugasHarian)
                    .addComponent(tTugasHarian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uts)
                    .addComponent(tUts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uas)
                    .addComponent(tUas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(panelStatusNilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        bClear.setText("Clear");
        bClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClearActionPerformed(evt);
            }
        });

        bSimpan.setText("Simpan");
        bSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSimpanActionPerformed(evt);
            }
        });

        bHapus.setText("Hapus");
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        bEdit.setText("Edit");
        bEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nis)
                            .addComponent(kdKelas)
                            .addComponent(kdMapel))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CbRelasiNis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CbRelasiKdKelas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CbRelasiKdMapel, 0, 156, Short.MAX_VALUE))
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(bSimpan)
                        .addGap(18, 18, 18)
                        .addComponent(bClear, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nis)
                            .addComponent(CbRelasiNis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kdKelas)
                            .addComponent(CbRelasiKdKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kdMapel)
                            .addComponent(CbRelasiKdMapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bSimpan)
                            .addComponent(bClear)
                            .addComponent(bHapus)
                            .addComponent(bEdit)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tableKelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NIS", "Kode Kelas", "Kode Pelajaran", "Tugas Harian", "UTS", "UAS", "Nilai Akhir", "Keterangan"
            }
        ));
        tableKelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKelasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableKelas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Judul1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Judul1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tTugasHarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tTugasHarianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tTugasHarianActionPerformed

    private void tUasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tUasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tUasActionPerformed

    private void tUtsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tUtsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tUtsActionPerformed

    private void bSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimpanActionPerformed
        // TODO add your handling code here:
        String sql = "INSERT INTO nilai VALUES (?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setString(1, CbRelasiNis.getSelectedItem().toString());
            stat.setString(2, CbRelasiKdKelas.getSelectedItem().toString());
            stat.setString(3, CbRelasiKdMapel.getSelectedItem().toString());
            stat.setString(4, tTugasHarian.getText());
            stat.setString(5, tUts.getText());
            stat.setString(6, tUas.getText());
            
            statusHitung();
            String hit = Double.toString(getHitung());
            stat.setString(7, hit);
            stat.setString(8, getKet());
            
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "DATA Berhasil Disimpan");
            kosong();
            tTugasHarian.requestFocus();
            datatable();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan "+e);
        }
        
    }//GEN-LAST:event_bSimpanActionPerformed

    private void bClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClearActionPerformed
        // TODO add your handling code here:
        datatable();
        kosong();
        statusKosong();
    }//GEN-LAST:event_bClearActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null,"hapus","Konfirmasi Dialog",JOptionPane.YES_NO_CANCEL_OPTION);
        if(ok == 0){
            String sql = "DELETE FROM nilai WHERE nis='"+CbRelasiNis.getSelectedItem()+"'";
            try{
                PreparedStatement stat = conn.prepareStatement(sql);

                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil diUbah ");
                kosong();
                tTugasHarian.requestFocus();
                datatable();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Data Gagal DiUbah " + e);
            }
        }
    }//GEN-LAST:event_bHapusActionPerformed

    private void bEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditActionPerformed
        // TODO add your handling code here:

        try{
            String sql = "UPDATE nilai set kd_kelas=?, kd_mapel=?, tugas_harian=?, uts=?, uas=?, nilai_akhir=?, keterangan=? WHERE nis=?";
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setString(1, CbRelasiKdKelas.getSelectedItem().toString());
            stat.setString(2, CbRelasiKdMapel.getSelectedItem().toString());
            stat.setString(3, tTugasHarian.getText());
            stat.setString(4, tUts.getText());
            stat.setString(5, tUas.getText());
            
            statusHitung();
            String hit = Double.toString(getHitung());
            stat.setString(6, hit);                   
            stat.setString(7, getKet());
            stat.setString(8, CbRelasiNis.getSelectedItem().toString());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil diUbah ");
            kosong();
            tTugasHarian.requestFocus();
            datatable();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Data Gagal DiUbah " + e);
        }
    }//GEN-LAST:event_bEditActionPerformed

    private void tableKelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKelasMouseClicked
        // TODO add your handling code here:
        int bar = tableKelas.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        
        CbRelasiNis.setSelectedItem(a);
        CbRelasiKdKelas.setSelectedItem(b);
        CbRelasiKdMapel.setSelectedItem(c);
        tTugasHarian.setText(d);
        tUts.setText(e);
        tUas.setText(f);
        
    }//GEN-LAST:event_tableKelasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbRelasiKdKelas;
    private javax.swing.JComboBox<String> CbRelasiKdMapel;
    private javax.swing.JComboBox<String> CbRelasiNis;
    private javax.swing.JLabel Judul1;
    private javax.swing.JButton bClear;
    private javax.swing.JButton bEdit;
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bSimpan;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel judul2;
    private javax.swing.JLabel kdKelas;
    private javax.swing.JLabel kdMapel;
    private javax.swing.JLabel keterangan;
    private javax.swing.JLabel nilaiAkhir;
    private javax.swing.JLabel nis;
    private javax.swing.JPanel panelStatusNilai;
    private javax.swing.JLabel statusKet;
    private javax.swing.JLabel statusNilai;
    private javax.swing.JTextField tTugasHarian;
    private javax.swing.JTextField tUas;
    private javax.swing.JTextField tUts;
    private javax.swing.JTable tableKelas;
    private javax.swing.JLabel tugasHarian;
    private javax.swing.JLabel uas;
    private javax.swing.JLabel uts;
    // End of variables declaration//GEN-END:variables
}
