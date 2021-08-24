/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Entity.HOADONCT;
import Entity.NHANVIEN;
import Model.HOADONCTDAO;
import Model.NHANVIENDAO;
import Model.THONGKEDAO;
import TienIch.Auth;
import TienIch.XImage;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author LENOVO
 */
public class THONGKE extends javax.swing.JFrame {

    THONGKEDAO dao = new THONGKEDAO();
    HOADONCTDAO hdctdao = new HOADONCTDAO();
    NHANVIENDAO nvdao = new NHANVIENDAO();

    /**
     * Creates new form QLNV
     */
    public THONGKE() {
        this.setIconImage(XImage.getAppIcon());
        initComponents();
        this.setLocationRelativeTo(this);
        fillCBBYears_DoanhThu();
        fillCBBYears_Luong();
        fillCBBMonth_Luong();
        fillmonan();
        filldoanhthu();
        fillluong();
        fillUser();
        

    }
    public void barchartmonan (){
        Double mon1 = Double.parseDouble( tblmonan.getValueAt(0, 1).toString());
        Double mon2 = Double.parseDouble( tblmonan.getValueAt(1, 1).toString());
        Double mon3 = Double.parseDouble( tblmonan.getValueAt(2, 1).toString());
        String tenmon1 = tblmonan.getValueAt(0, 2).toString();
        String tenmon2 = tblmonan.getValueAt(1, 2).toString();
        String tenmon3 = tblmonan.getValueAt(2, 2).toString();
        
        DefaultCategoryDataset dataMA = new DefaultCategoryDataset();
        dataMA.setValue(new Double(mon1), "Giá trị hiển thị", tenmon1);
        dataMA.setValue(new Double(mon2), "Giá trị hiển thị", tenmon2);
        dataMA.setValue(new Double(mon3), "Giá trị hiển thị", tenmon3);
        JFreeChart chart = ChartFactory.createBarChart("Top 3 món ăn được yêu thích nhất", "Tên món", "Số lượng bán(lượt)", dataMA);
        ChartFrame ch = new ChartFrame("Món an", chart);
        ch.setVisible(true);
        ch.setSize(625,255);
        ch.setLocationRelativeTo(panelmonan);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.yellow);
        
    }
    public void barchartdoanhthu (){
        Double HDCN = Double.parseDouble( tbldoanhthu.getValueAt(0, 2).toString());
        Double HDTN = Double.parseDouble( tbldoanhthu.getValueAt(0, 3).toString());
        Double DT = Double.parseDouble( tbldoanhthu.getValueAt(0, 4).toString());
        
        DefaultCategoryDataset dataMA = new DefaultCategoryDataset();
        dataMA.setValue(new Double(HDCN), "Hóa đơn có giá trị cao nhất năm", "");
        dataMA.setValue(new Double(HDTN), "Hóa đơn có giá trị thấp nhất năm", "");
        dataMA.setValue(new Double(DT), "Tổng doanh thu của năm", "");
        JFreeChart chart = ChartFactory.createBarChart("Chi tiết doanh thu của năm", "Danh mục", "Đồng(VND)", dataMA);
        ChartFrame ch = new ChartFrame("Doanh thu", chart);
        ch.setVisible(true);
        ch.setSize(625,262);
        ch.setLocationRelativeTo(panelDT);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.yellow);
        
        
        
    }
    public void barchartluong (){
        Double LUONG1 = Double.parseDouble( tblluong.getValueAt(0, 3).toString());
        Double LUONG2 = Double.parseDouble( tblluong.getValueAt(1, 3).toString());
        Double LUONG3 = Double.parseDouble( tblluong.getValueAt(2, 3).toString());
        String a = tblluong.getValueAt(0, 2).toString() + ":" + tblluong.getValueAt(0, 1).toString();
        String b = tblluong.getValueAt(1, 2).toString() + ":" + tblluong.getValueAt(1, 1).toString();
        String c = tblluong.getValueAt(2, 2).toString() + ":" + tblluong.getValueAt(2, 1).toString();
        DefaultCategoryDataset dataMA = new DefaultCategoryDataset();
        dataMA.setValue(new Double(LUONG1), "Giá trị hiển thị", a);
        dataMA.setValue(new Double(LUONG2), "Giá trị hiển thị", b);
        dataMA.setValue(new Double(LUONG3), "Giá trị hiển thị", c);
        JFreeChart chart = ChartFactory.createBarChart("Top 3 nhân viên lương cao nhất năm", "Nhân viên", "Đồng(VND)", dataMA);
        ChartFrame ch = new ChartFrame("Lương", chart);
        ch.setVisible(true);
        ch.setSize(625,262);
        ch.setLocationRelativeTo(panelluong);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.yellow);
        
        
        
    }

    public void fillCBBYears_DoanhThu() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbonam2.getModel();
        DefaultComboBoxModel model2 = (DefaultComboBoxModel) cbnam1.getModel();
        model.removeAllElements();
        model2.removeAllElements();
        List<Integer> list = dao.selectYearsHD();
        for (Integer year : list) {
            model.addElement(year);
            model2.addElement(year);
        }
    }
    public void fillCBBYears_Luong(){
        DefaultComboBoxModel model3 = (DefaultComboBoxModel) cbonam3.getModel();
        model3.removeAllElements();
        List<Integer> list = dao.selectYearsL();
        for (Integer year : list) {
            model3.addElement(year);
        }
    }
    public void fillCBBMonth_Luong(){
        DefaultComboBoxModel model4 = (DefaultComboBoxModel) cbothang3.getModel();
        model4.removeAllElements();
        List<Integer> list = dao.selectMonthL();
        for (Integer month : list) {
            model4.addElement(month);
        }
    }

    public void fillmonan() {
        try {
            DefaultTableModel model = (DefaultTableModel) tblmonan.getModel();
            model.setRowCount(0);
            int year = Integer.parseInt(cbnam1.getSelectedItem().toString());
            List<Object[]> list = dao.getMonAn(year);
            for (Object[] row : list) {
                model.addRow(row);

            }
        } catch (Exception e) {
        }
    }

    public void filldoanhthu() {
        try {
            DefaultTableModel model = (DefaultTableModel) tbldoanhthu.getModel();
            model.setRowCount(0);
            int year = Integer.parseInt(cbonam2.getSelectedItem().toString());
            List<Object[]> list = dao.getDoanhthu(year);
            for (Object[] row : list) {
                model.addRow(row);

            }
        } catch (Exception e) {
        }
    }
    public void fillluong(){
    try {
            List<NHANVIEN> listql = nvdao.selectAll();
            DefaultTableModel model = (DefaultTableModel) tblluong.getModel();
            model.setRowCount(0);
            int month = Integer.parseInt(cbothang3.getSelectedItem().toString());
            int year = Integer.parseInt(cbonam3.getSelectedItem().toString());
            List<Object[]> list = dao.getLuong(month,year);
            for(NHANVIEN nv:listql){
                if(nv.getVaiTro().equalsIgnoreCase("QUẢN LÍ")){
                    model.addRow(new Object[]{
                            nv.getIdNV(),nv.getTenNV(),nv.getVaiTro(),nv.getLuongCa()*90
                        });
                }
            }
            for (Object[] row : list) {
                model.addRow(row);

            }
        } catch (Exception e) {
        }
    }
    public void fillUser(){
    try {
            DefaultTableModel model = (DefaultTableModel) tbluser.getModel();
            model.setRowCount(0);
            
            List<Object[]> list = dao.getUser();
            for (Object[] row : list) {
                model.addRow(row);

            }
        } catch (Exception e) {
        }
    }
    public void timkey() {
        try {
            DefaultTableModel model = (DefaultTableModel) tbluser.getModel();
            model.setRowCount(0);

            String keyword = txtTim.getText();
            List<Object[]> list = dao.Timtheokey(keyword);
            for (Object[] row : list) {
                model.addRow(row);
            }

        } catch (Exception e) {
        }

    }

    /* public void timid(){
        DefaultTableModel model = (DefaultTableModel) tbluser.getModel();
        model.setRowCount(0);
        String id = txtTim.getText();
        List<Object[]> list = dao.Timtheoid(id);
            for (Object[] row : list) {
                model.addRow(row);}
         
    }*/
    

    public void selectTab(int index) {
        tabs.setSelectedIndex(index);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblmonan = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cbnam1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        panelmonan = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbldoanhthu = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cbonam2 = new javax.swing.JComboBox<>();
        panelDT = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblluong = new javax.swing.JTable();
        cbothang3 = new javax.swing.JComboBox<>();
        cbonam3 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelluong = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbluser = new javax.swing.JTable();
        txtTim = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("                                                                            THỐNG KÊ");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblmonan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Món", "Số lượng bán", "Tên món"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblmonan);
        if (tblmonan.getColumnModel().getColumnCount() > 0) {
            tblmonan.getColumnModel().getColumn(1).setResizable(false);
            tblmonan.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TOP 3 MÓN ĂN ĐƯỢC YÊU THÍCH NHẤT ");

        cbnam1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbnam1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Năm:");

        javax.swing.GroupLayout panelmonanLayout = new javax.swing.GroupLayout(panelmonan);
        panelmonan.setLayout(panelmonanLayout);
        panelmonanLayout.setHorizontalGroup(
            panelmonanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelmonanLayout.setVerticalGroup(
            panelmonanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        jButton2.setText("Xem biểu đồ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jLabel4)
                        .addGap(27, 27, 27)
                        .addComponent(cbnam1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                            .addComponent(panelmonan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jButton2)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbnam1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelmonan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        tabs.addTab("Món ăn", jPanel1);

        tbldoanhthu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tổng lượt bán", "Số lượng món bán được", "Hóa đơn thấp nhất", "Hóa đơn cao nhất", "Tổng doanh thu"
            }
        ));
        jScrollPane2.setViewportView(tbldoanhthu);

        jLabel2.setText("Năm:");

        cbonam2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbonam2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDTLayout = new javax.swing.GroupLayout(panelDT);
        panelDT.setLayout(panelDTLayout);
        panelDTLayout.setHorizontalGroup(
            panelDTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelDTLayout.setVerticalGroup(
            panelDTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        jButton1.setText("Xem biểu đồ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(panelDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbonam2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(252, 252, 252))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbonam2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Doanh thu", jPanel3);

        tblluong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Chức vụ", "Lương"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblluong);

        cbothang3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "11", "12" }));
        cbothang3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbothang3ActionPerformed(evt);
            }
        });

        cbonam3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2020" }));
        cbonam3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbonam3ActionPerformed(evt);
            }
        });

        jLabel5.setText("Tháng:");

        jLabel6.setText("Năm:");

        javax.swing.GroupLayout panelluongLayout = new javax.swing.GroupLayout(panelluong);
        panelluong.setLayout(panelluongLayout);
        panelluongLayout.setHorizontalGroup(
            panelluongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelluongLayout.setVerticalGroup(
            panelluongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 231, Short.MAX_VALUE)
        );

        jButton3.setText("Xem biểu đồ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(panelluong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbothang3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbonam3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jButton3)))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbothang3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbonam3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Lương", jPanel2);

        tbluser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "ID", "Pass"
            }
        ));
        jScrollPane3.setViewportView(tbluser);

        txtTim.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtTim.setForeground(new java.awt.Color(204, 204, 204));
        txtTim.setText("Nhập tên hoặc mã NV");
        txtTim.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimFocusLost(evt);
            }
        });
        txtTim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTimMousePressed(evt);
            }
        });
        txtTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimActionPerformed(evt);
            }
        });

        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Xem tất cả");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(167, 167, 167))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton5)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        tabs.addTab("User", jPanel4);

        getContentPane().add(tabs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 43, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("TỔNG HỢP - THỐNG KÊ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 0, 184, 37));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbonam2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbonam2ActionPerformed
        // TODO add your handling code here:
        filldoanhthu();

    }//GEN-LAST:event_cbonam2ActionPerformed

    private void cbnam1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbnam1ActionPerformed
        // TODO add your handling code here:
        fillmonan();
    }//GEN-LAST:event_cbnam1ActionPerformed

    private void cbothang3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbothang3ActionPerformed
        // TODO add your handling code here:
        fillluong();
    }//GEN-LAST:event_cbothang3ActionPerformed

    private void cbonam3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbonam3ActionPerformed
        // TODO add your handling code here:
        fillluong();
    }//GEN-LAST:event_cbonam3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        barchartmonan();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        barchartdoanhthu ();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        barchartluong();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtTimFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimFocusLost
        // TODO add your handling code here:
        if (txtTim.getText().trim().equalsIgnoreCase("")) {
            txtTim.setText("Nhập tên hoặc mã nv cần tìm");
            txtTim.setFont(new Font("Tahoma", Font.ITALIC, 12));
            txtTim.setForeground(new Color(204, 204, 204));

        }
    }//GEN-LAST:event_txtTimFocusLost

    private void txtTimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimMouseClicked
        // TODO add your handling code here:
        if (txtTim.getForeground() != Color.black) {
            txtTim.setText("");
            txtTim.setFont(new Font("Tahoma", Font.PLAIN, 12));
            txtTim.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtTimMouseClicked

    private void txtTimMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimMousePressed
        // TODO add your handling code here:
        if (txtTim.getForeground() != Color.black) {
            txtTim.setText("");
            txtTim.setFont(new Font("Tahoma", Font.PLAIN, 12));
            txtTim.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtTimMousePressed

    private void txtTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        timkey();

        // timid();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        fillUser();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(THONGKE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(THONGKE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(THONGKE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(THONGKE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new THONGKE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbnam1;
    private javax.swing.JComboBox<String> cbonam2;
    private javax.swing.JComboBox<String> cbonam3;
    private javax.swing.JComboBox<String> cbothang3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel panelDT;
    private javax.swing.JPanel panelluong;
    private javax.swing.JPanel panelmonan;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tbldoanhthu;
    private javax.swing.JTable tblluong;
    private javax.swing.JTable tblmonan;
    private javax.swing.JTable tbluser;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
