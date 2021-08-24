/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author TOSHIBA
 */
public class NHANVIEN {
    private String idNV ;
    private String tenNV;
    private int tuoi;
    private boolean gt;
    private String sdt;
    private String cmnd;
    private String vaiTro;
    private double luongCa;
    private String pass;
    private String avatar;

    public NHANVIEN(){}
    
    public NHANVIEN(String idNV, String tenNV, int tuoi, boolean gt, String sdt, String cmnd, String vaiTro, double luongCa, String pass, String avatar) {
        this.idNV = idNV;
        this.tenNV = tenNV;
        this.tuoi = tuoi;
        this.gt = gt;
        this.sdt = sdt;
        this.cmnd = cmnd;
        this.vaiTro = vaiTro;
        this.luongCa = luongCa;
        this.pass = pass;
        this.avatar = avatar;
    }
    
    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public boolean isGt() {
        return gt;
    }

    public void setGt(boolean gt) {
        this.gt = gt;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public double getLuongCa() {
        return luongCa;
    }

    public void setLuongCa(double luongCa) {
        this.luongCa = luongCa;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
}
