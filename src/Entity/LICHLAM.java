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
public class LICHLAM {
    private int stt;
    private String idNV;
    private int ca;
    private Date ngayLam;
    private double luongCa;
    private String vaitro;
    private boolean diemDanh;

    public LICHLAM(){}

    public LICHLAM(int stt, String idNV, int ca, Date ngayLam, double luongCa, String vaitro, boolean diemDanh) {
        this.stt = stt;
        this.idNV = idNV;
        this.ca = ca;
        this.ngayLam = ngayLam;
        this.luongCa = luongCa;
        this.vaitro = vaitro;
        this.diemDanh = diemDanh;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public Date getNgayLam() {
        return ngayLam;
    }

    public void setNgayLam(Date ngayLam) {
        this.ngayLam = ngayLam;
    }

    public double getLuongCa() {
        return luongCa;
    }

    public void setLuongCa(double luongCa) {
        this.luongCa = luongCa;
    }

    public String getVaitro() {
        return vaitro;
    }

    public void setVaitro(String vaitro) {
        this.vaitro = vaitro;
    }

    public boolean isDiemDanh() {
        return diemDanh;
    }

    public void setDiemDanh(boolean diemDanh) {
        this.diemDanh = diemDanh;
    }
    
}
