package Form;

import Entity.NHANVIEN;
import Model.NHANVIENDAO;
import TienIch.MsgBox;
import java.awt.Color;
import java.awt.Cursor;
import java.util.List;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nguye
 */
public class LOGIN extends javax.swing.JFrame {

    NHANVIENDAO nvdao = new NHANVIENDAO();
    List<NHANVIEN> list = nvdao.selectAll();
    Boolean hide = false;
    String check = null;
    String us = null;
    String pa = null;

    public Preferences pref = Preferences.userRoot().node("Rememberme");

    /**
     * Creates new form dangnhap
     */
    public LOGIN() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUndecorated(true);
        new WELCOME(this, true).setVisible(true);
        initComponents();

        init();
    }

    public LOGIN(boolean t) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUndecorated(true);
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPass = new javax.swing.JPasswordField();
        btnExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        btnDangNhap = new javax.swing.JButton();
        lblChangePass = new javax.swing.JLabel();
        ckbRemember = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("                                                                                                                        ĐĂNG NHẬP  ");
        setIconImages(null);
        setSize(new java.awt.Dimension(630, 480));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 310, 30));

        btnExit.setBackground(new java.awt.Color(255, 255, 255));
        btnExit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Stop.png"))); // NOI18N
        btnExit.setOpaque(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 50, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel1.setText("ĐĂNG NHẬP");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("TÀI KHOẢN");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 70, 31));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("MẬT KHẨU");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 70, 31));
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 310, 31));

        btnDangNhap.setBackground(new java.awt.Color(51, 51, 255));
        btnDangNhap.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setText("LOGIN");
        btnDangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDangNhapMouseEntered(evt);
            }
        });
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        getContentPane().add(btnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 233, 310, 60));

        lblChangePass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblChangePass.setText("Change password ?");
        lblChangePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblChangePassMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblChangePassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblChangePassMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblChangePassMouseReleased(evt);
            }
        });
        getContentPane().add(lblChangePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, 110, 20));

        ckbRemember.setText("NHỚ MẬT KHẨU");
        ckbRemember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ckbRememberMouseEntered(evt);
            }
        });
        getContentPane().add(ckbRemember, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, -1, 34));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_Login/lg4.jpg"))); // NOI18N
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 0, 280, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        login();
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void lblChangePassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChangePassMouseEntered
        lblChangePass.setText("<html><u>Change password ?</u></html>");
        lblChangePass.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblChangePass.setForeground(Color.blue);
    }//GEN-LAST:event_lblChangePassMouseEntered

    private void lblChangePassMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChangePassMouseReleased

    }//GEN-LAST:event_lblChangePassMouseReleased

    private void lblChangePassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChangePassMouseExited
        lblChangePass.setForeground(Color.black);
        lblChangePass.setText("<html>Change password ?</html>");
    }//GEN-LAST:event_lblChangePassMouseExited

    private void lblChangePassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChangePassMouseClicked
        openChangePass();
    }//GEN-LAST:event_lblChangePassMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void btnDangNhapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangNhapMouseEntered
        btnDangNhap.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnDangNhapMouseEntered

    private void ckbRememberMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ckbRememberMouseEntered
        ckbRemember.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_ckbRememberMouseEntered

    void init() {
        setLocationRelativeTo(this);
        try {
            check = pref.get("check", check);
            us = pref.get("username", us);
            pa = pref.get("pass", pa);
            if (check.equalsIgnoreCase("true")) {
                txtUser.setText(us);
                txtPass.setText(pa);
                ckbRemember.setSelected(true);
            }
        } catch (Exception e) {
        }
    }

    public boolean check() {

        if (txtUser.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống Tên tài khoản!");
            txtUser.requestFocus();
            return false;
        } else if (txtPass.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không để trống password!");
            txtPass.requestFocus();
            return false;
        }
        return true;
    }

    void login() {
        int count = 0;
        if (check()) {
            for (NHANVIEN nv : list) {
                if (nv.getIdNV().equalsIgnoreCase(txtUser.getText().trim())) {
                    count++;
                    if (nv.getPass().equalsIgnoreCase(txtPass.getText())) {
                        count++;
                        if (ckbRemember.isSelected()) {
                            NhoMatKhau(txtUser.getText().trim(), txtPass.getText(), "true");
                        } else {
                            NhoMatKhau(txtUser.getText().trim(), txtPass.getText(), "false");
                        }
                        HOME h = new HOME(nv);
                        h.setVisible(true);
                        this.dispose();
                    }
                    break;
                }
            }
            if (count == 0) {
                JOptionPane.showMessageDialog(this, "Sai tên đăng nhập!", "Hệ thống quản lý đào tạo", JOptionPane.ERROR_MESSAGE);
            } else if (count == 1) {
                JOptionPane.showMessageDialog(this, "Sai mật khẩu!", "Hệ thống quản lý đào tạo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    void openChangePass(){
        CHANGE_PASS cp = new CHANGE_PASS();
        cp.setVisible(true);
        dispose();
    }

    void NhoMatKhau(String username, String pass, String check) {
        pref.put("username", username);
        pref.put("pass", pass);
        pref.put("check", check);
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
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LOGIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnExit;
    private javax.swing.JCheckBox ckbRemember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblChangePass;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
