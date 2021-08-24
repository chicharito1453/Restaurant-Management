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
public class BANSUDUNG {
    private int idBan;
    private int idHD;
    private Date ngay;
    
    public BANSUDUNG(){}

    public BANSUDUNG(int idBan, int idHD, Date ngay) {
        this.idBan = idBan;
        this.idHD = idHD;
        this.ngay = ngay;
    }

    public int getIdBan() {
        return idBan;
    }

    public void setIdBan(int idBan) {
        this.idBan = idBan;
    }

    public int getIdHD() {
        return idHD;
    }

    public void setIdHD(int idHD) {
        this.idHD = idHD;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }
    
}
