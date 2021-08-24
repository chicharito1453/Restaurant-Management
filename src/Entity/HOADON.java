/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author TOSHIBA
 */
public class HOADON {
    private int idHD;
    private Date ngayXuat;
    private double tongTien;
    private String trangthai;

    public HOADON(){}

    public HOADON(int idHD, Date ngayXuat, double tongTien, String trangthai) {
        this.idHD = idHD;
        this.ngayXuat = ngayXuat;
        this.tongTien = tongTien;
        this.trangthai = trangthai;
    }

    public int getIdHD() {
        return idHD;
    }

    public void setIdHD(int idHD) {
        this.idHD = idHD;
    }

    public Date getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(Date ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
    
}
