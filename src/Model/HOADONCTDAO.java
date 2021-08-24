/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.HOADONCT;
import TienIch.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public class HOADONCTDAO extends AbsDao<HOADONCT, Integer>{
    String INSERT_HD_CT = "INSERT INTO HOADONCT values (?, ?, ?, ?)";
    String UPDATE_HD_CT = "UPDATE HOADONCT SET idMon = ?, soluong = ?, donGia = ? WHERE idHD = ?";
    String DELETE_HD_CT = "DELETE FROM HOADONCT WHERE idHD = ?";//Có thể là idHD or idMon
    String SELECTALLHD_CT = "SELECT * FROM HOADONCT";
    String SELECTIDHD_CT = "SELECT * FROM HOADONCT WHERE idHD = ?";
    String DELETE_HD_CT_IDMON = "DELETE FROM HOADONCT WHERE idMon ?";

    @Override
    public void insert(HOADONCT e) {
        JdbcHelper.Update(INSERT_HD_CT, e.getIdHD(), e.getIdMon(), e.getSoLuong(), e.getDonGia());
    }

    @Override
    public void update(HOADONCT e) {
       JdbcHelper.Update(UPDATE_HD_CT, e.getIdMon(), e.getSoLuong(), e.getDonGia(), e.getIdHD());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.Update(DELETE_HD_CT, id);
    }
    
    public void deleteTheoMon(Integer id) {
        JdbcHelper.Update(DELETE_HD_CT_IDMON, id);
    }

    @Override
    public HOADONCT selectById(Integer id) {
       List<HOADONCT> nv = this.selectBySql(SELECTIDHD_CT, id);
        if (nv.isEmpty()) {
            return null;
        }
       return nv.get(0);
    }

    @Override
    public List<HOADONCT> selectAll() {
        return this.selectBySql(SELECTALLHD_CT);
    }

    @Override
    protected List<HOADONCT> selectBySql(String sql, Object... a) {
        List<HOADONCT> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.Query(sql, a);
            while (rs.next()) {
                HOADONCT hdct = new HOADONCT();
                hdct.setIdHD(rs.getInt("idHD"));
                hdct.setIdMon(rs.getInt("idMon"));
                hdct.setSoLuong(rs.getInt("soluong"));
                hdct.setDonGia(rs.getDouble("donGia"));
                list.add(hdct);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<HOADONCT> selectHDCT(Integer id) {
       List<HOADONCT> list = this.selectBySql(SELECTIDHD_CT, id);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

}
