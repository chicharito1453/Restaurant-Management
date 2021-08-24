/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.HOADON;
import TienIch.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public class HOADONDAO extends AbsDao<HOADON, Integer>{
    String INSERT_HD = "INSERT INTO HOADON(ngay) values (?)";
    String UPDATE_HD = "UPDATE HOADON SET ngay = ?, tongtien = ?, trangthai = ? where idHD = ?";
    String DELETE_HD = "DELETE FROM HOADON WHERE idHD = ?";
    String SELECTALLHD = "SELECT * FROM HOADON";
    String SELECTIDHD = "SELECT * FROM HOADON WHERE idHD = ?";
    String SELECTLAST ="SELECT * FROM HOADON WHERE idHD = (SELECT MAX(idHD) FROM HOADON)";
    String SELECTHD_CHUAXUAT = "SELECT * FROM HOADON WHERE trangthai = N'Chưa thanh toán'";
    String SELECTHD_DAXUAT = "SELECT * FROM HOADON WHERE trangthai = N'Đã thanh toán'";

    @Override
    public void insert(HOADON e) {
        JdbcHelper.Update(INSERT_HD, e.getNgayXuat());
    }

    @Override
    public void update(HOADON e) {
       JdbcHelper.Update(UPDATE_HD, e.getNgayXuat(), e.getTongTien(), e.getTrangthai(), e.getIdHD());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.Update(DELETE_HD, id);
    }

    @Override
    public HOADON selectById(Integer id) {
        List<HOADON> nv = this.selectBySql(SELECTIDHD, id);
        if (nv.isEmpty()) {
            return null;
        }
       return nv.get(0);
    }

    @Override
    public List<HOADON> selectAll() {
        return this.selectBySql(SELECTALLHD);
    }

    @Override
    protected List<HOADON> selectBySql(String sql, Object... a) {
        List<HOADON> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.Query(sql, a);
            while (rs.next()) {
                HOADON hd = new HOADON();
                hd.setIdHD(rs.getInt("idHD"));
                hd.setNgayXuat(rs.getDate("ngay"));
                hd.setTongTien(rs.getDouble("tongtien"));
                hd.setTrangthai(rs.getString("trangthai"));
                list.add(hd);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public HOADON selectLastHD() {
        List<HOADON> nv = this.selectBySql(SELECTLAST);
        if (nv.isEmpty()) {
            return null;
        }
       return nv.get(0);
    }
    
    public List<HOADON> selectHdChuaXuat() {
        return this.selectBySql(SELECTHD_CHUAXUAT);
    }
    
    public List<HOADON> selectHdDaXuat() {
        return this.selectBySql(SELECTHD_DAXUAT);
    }
    
}
