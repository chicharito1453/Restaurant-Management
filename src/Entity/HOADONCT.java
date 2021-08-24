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
public class HOADONCT {
    private int idHD;
    private int idMon;
    private int soLuong;
    private double donGia;

    public HOADONCT(){}
    
    public HOADONCT(int idHD, int idMon, int soLuong, double donGia) {
        this.idHD = idHD;
        this.idMon = idMon;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public int getIdHD() {
        return idHD;
    }

    public void setIdHD(int idHD) {
        this.idHD = idHD;
    }

    public int getIdMon() {
        return idMon;
    }

    public void setIdMon(int idMon) {
        this.idMon = idMon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    
}
