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
public class DANHSACHMON {
    private int idMon;
    private String tenMon;
    private boolean loai;
    private String hinhanh;
    private double donGia;

    public DANHSACHMON(){}
    
    public DANHSACHMON(int idMon, String tenMon, boolean loai, String hinhanh, double donGia) {
        this.idMon = idMon;
        this.tenMon = tenMon;
        this.loai = loai;
        this.hinhanh = hinhanh;
        this.donGia = donGia;
    }

    public int getIdMon() {
        return idMon;
    }

    public void setIdMon(int idMon) {
        this.idMon = idMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public boolean isLoai() {
        return loai;
    }

    public void setLoai(boolean loai) {
        this.loai = loai;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    @Override
    public String toString(){
        return getTenMon();
    }
}
