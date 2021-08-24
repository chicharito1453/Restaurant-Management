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
public class GHIHOADON {
    private String NVghi;
    private int idHD;
    private Date ngayGhi;

    public GHIHOADON(){}
    
    public GHIHOADON(String NVghi, int idHD, Date ngayGhi) {
        this.NVghi = NVghi;
        this.idHD = idHD;
        this.ngayGhi = ngayGhi;
    }

    public String getNVghi() {
        return NVghi;
    }

    public void setNVghi(String NVghi) {
        this.NVghi = NVghi;
    }

    public int getIdHD() {
        return idHD;
    }

    public void setIdHD(int idHD) {
        this.idHD = idHD;
    }

    public Date getNgayGhi() {
        return ngayGhi;
    }

    public void setNgayGhi(Date ngayGhi) {
        this.ngayGhi = ngayGhi;
    }
    
}
