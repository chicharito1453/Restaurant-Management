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
public class BAN {
    private int idBan;
    private String tenBan;
    private String vitri;
    private String trangthai;

    public BAN(){}

    public BAN(int idBan, String tenBan, String vitri, String trangthai) {
        this.idBan = idBan;
        this.tenBan = tenBan;
        this.vitri = vitri;
        this.trangthai = trangthai;
    }

    public int getIdBan() {
        return idBan;
    }

    public void setIdBan(int idBan) {
        this.idBan = idBan;
    }

    public String getTenBan() {
        return tenBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

    public String getVitri() {
        return vitri;
    }

    public void setVitri(String vitri) {
        this.vitri = vitri;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
    
    @Override
   public String toString(){
       return this.getIdBan()+"";
   }
}
