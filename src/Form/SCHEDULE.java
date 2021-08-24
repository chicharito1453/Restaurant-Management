/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Entity.LICHLAM;
import Entity.NHANVIEN;
import Model.LICHLAMDAO;
import Model.NHANVIENDAO;
import TienIch.Auth;
import TienIch.XDate;
import TienIch.XImage;
import java.awt.Image;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author LENOVO
 */
public class SCHEDULE extends javax.swing.JFrame {
    
    LICHLAMDAO lldao = new LICHLAMDAO();
    
    /**
     * Creates new form QLNV
     */
    public SCHEDULE() {
        initComponents();
        init();
    }
    
    public SCHEDULE(NHANVIEN nv) {
        initComponents();
        init();
        if(nv.getVaiTro().equalsIgnoreCase("QUẢN LÍ")){
            btnDK.setVisible(false);
        }
        else{
            btnDiemDanh.setVisible(false);
        }
        try {
            Image img = this.read(nv.getAvatar());
            Image resizedImage = img.getScaledInstance(lblAvtNV.getWidth(), lblAvtNV.getHeight(), Image.SCALE_SMOOTH);
            lblAvtNV.setIcon(new ImageIcon(resizedImage));
            lblAvtNV.setToolTipText(nv.getAvatar());
        } catch (Exception e) {
        }
    }

    public Image read(String file) {
        File f = new File("logos", file);
        try {
            Image img = ImageIO.read(f);
            return img;
        } catch (Exception ex) {

        }
        return null;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDK = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSchedule = new javax.swing.JTable();
        btnDiemDanh = new javax.swing.JButton();
        cbbNam = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblAvtNV = new javax.swing.JLabel();
        cbbNgay = new javax.swing.JComboBox();
        cbbThang = new javax.swing.JComboBox();
        btnXem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(700, 650));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDK.setText("ĐĂNG KÍ CA LÀM");
        btnDK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDKActionPerformed(evt);
            }
        });
        getContentPane().add(btnDK, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 520, -1, -1));

        tblSchedule.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nv", "Tên nv", "Ca", "Ngày", "Lương ca", "Điểm danh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSchedule);
        if (tblSchedule.getColumnModel().getColumnCount() > 0) {
            tblSchedule.getColumnModel().getColumn(2).setPreferredWidth(20);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 680, 390));

        btnDiemDanh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDiemDanh.setText("ĐIỂM DANH HÔM NAY");
        btnDiemDanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiemDanhActionPerformed(evt);
            }
        });
        getContentPane().add(btnDiemDanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, -1, -1));

        cbbNam.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(cbbNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 70, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Ngày");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tháng");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("LỊCH LÀM");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Năm");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));

        lblAvtNV.setBackground(new java.awt.Color(0, 0, 255));
        lblAvtNV.setOpaque(true);
        getContentPane().add(lblAvtNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 70, 70));

        cbbNgay.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(cbbNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 70, -1));

        cbbThang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(cbbThang, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 70, -1));

        btnXem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnXem.setText("XEM");
        btnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemActionPerformed(evt);
            }
        });
        getContentPane().add(btnXem, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDKActionPerformed
        openDKLich();
    }//GEN-LAST:event_btnDKActionPerformed

    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemActionPerformed
        fillTable();
    }//GEN-LAST:event_btnXemActionPerformed

    private void btnDiemDanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiemDanhActionPerformed
        openDiemDanh();
    }//GEN-LAST:event_btnDiemDanhActionPerformed

    void init(){
        this.setIconImage(XImage.getAppIcon());
        setLocationRelativeTo(this);
        fillCbbNam();
        fillCbbThang();
        fillCBBNgay();
        fillTable();
    }
    
    void fillCbbNam(){
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbNam.getModel();
        model.removeAllElements();
        Calendar c = Calendar.getInstance();
        int thisYear = c.get(Calendar.YEAR);
        try {
            List<Integer> list = lldao.selectYears();
        for (Integer year : list) {
            model.addElement(year);
            if(thisYear==year){
                model.setSelectedItem(year);
            }
        }
        } catch (Exception e) {
        }
    }
    
    void fillCbbThang(){
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbThang.getModel();
        model.removeAllElements();
        Calendar c = Calendar.getInstance();
        int thisMonth = c.get(Calendar.MONTH);
        try {
            List<Integer> list = lldao.selectMonth(Integer.parseInt(cbbNam.getSelectedItem().toString()));
        for (Integer thang : list) {
            model.addElement(thang);
            if(thisMonth==thang){
                model.setSelectedItem(thang);
            }
        }
        } catch (Exception e) {
        }
    }
    
    void fillCBBNgay() {
        Calendar c = Calendar.getInstance();
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbNgay.getModel();
        model.removeAllElements();
        try {
            int songay = soNgaycuaThang((int) cbbThang.getSelectedItem());
        int today = c.get(Calendar.DATE);
        for (int i = 1; i <= songay; i++) {
            model.addElement(i);
            if(today==i){
                model.setSelectedItem(i);
            }
        }
        } catch (Exception e) {
        }
    }
    
    void fillTable(){
        NHANVIENDAO nvdao = new NHANVIENDAO();
        DefaultTableModel model = (DefaultTableModel) tblSchedule.getModel();
        model.setRowCount(0);
        try {
            Date lichNgay = XDate.toDate(getDate(), "MM/dd/yyyy");
        List<LICHLAM> list = lldao.selectBangSchedule(lichNgay);
        for(LICHLAM l:list){
            NHANVIEN nv = nvdao.selectById(l.getIdNV());
            model.addRow(new Object[]{
                l.getIdNV(), nv.getTenNV(), l.getCa(), l.getNgayLam(), l.getLuongCa(), l.isDiemDanh() ? "Có":"Vắng"
            });
        }
        } catch (Exception e) {
        }
    }
    
    String getDate() {
        Calendar c = Calendar.getInstance();
        String thang = cbbThang.getSelectedItem().toString();
        String ngay = cbbNgay.getSelectedItem().toString();
        String nam = cbbNam.getSelectedItem().toString();;
        String date = thang + "/" + ngay + "/" + nam;
        return date;
    }
    
    public int soNgaycuaThang(int thang) {
        Calendar c = Calendar.getInstance();
        if (thang == 12) {
            return 31;
        } else if (thang == 11) {
            return 30;
        } else if (thang == 10) {
            return 31;
        } else if (thang == 9) {
            return 30;
        } else if (thang == 8) {
            return 31;
        } else if (thang == 7) {
            return 30;
        } else if (thang == 6) {
            return 31;
        } else if (thang == 5) {
            return 30;
        } else if (thang == 4) {
            return 31;
        } else if (thang == 3) {
            return 30;
        } else if (thang == 2) {
            if ((c.get(Calendar.YEAR) % 4 == 0 && c.get(Calendar.YEAR) % 100 != 0) || (c.get(Calendar.YEAR) % 400 == 0)) {
                return 29;
            } else {
                return 28;
            }
        } else {
            return 30;
        }
    }
    
    void openDKLich(){
        DKILICH dk = new DKILICH(Auth.user);
        dk.setVisible(true);
    }
    
    void openDiemDanh(){
        DIEMDANH dd = new DIEMDANH(Auth.user);
        dd.setVisible(true);
    }
    
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
            java.util.logging.Logger.getLogger(SCHEDULE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SCHEDULE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SCHEDULE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SCHEDULE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SCHEDULE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDK;
    private javax.swing.JButton btnDiemDanh;
    private javax.swing.JButton btnXem;
    private javax.swing.JComboBox cbbNam;
    private javax.swing.JComboBox cbbNgay;
    private javax.swing.JComboBox cbbThang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAvtNV;
    private javax.swing.JTable tblSchedule;
    // End of variables declaration//GEN-END:variables
}
