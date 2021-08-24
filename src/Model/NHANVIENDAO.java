/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.NHANVIEN;
import TienIch.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public class NHANVIENDAO extends AbsDao<NHANVIEN, String>{
    String INSERT_NV = "INSERT INTO NHANVIEN(idNV,tenNV,tuoi,gt,sdt,cmnd,vaitro,luongCa,pass,avatar) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_NV = "UPDATE NHANVIEN SET tenNV = ?, tuoi = ?, gt = ?, sdt = ?, cmnd = ?, vaitro = ?, luongCa = ?, pass = ?, avatar = ? WHERE idNV = ?";
    String DELETE_NV="DELETE FROM NHANVIEN WHERE idNV = ?";
    String SELECT_BY_IDNV="SELECT * FROM NHANVIEN WHERE idNV = ?";
    String SELECT_ALL_NV="SELECT * FROM NHANVIEN";

    @Override
    public void insert(NHANVIEN e) {
        JdbcHelper.Update(INSERT_NV, e.getIdNV(), e.getTenNV(), e.getTuoi(), e.isGt(), e.getSdt(), e.getCmnd(), e.getVaiTro(), e.getLuongCa(), e.getPass(), e.getAvatar());
    }

    @Override
    public void update(NHANVIEN e) {
        JdbcHelper.Update(UPDATE_NV, e.getTenNV(), e.getTuoi(), e.isGt(), e.getSdt(), e.getCmnd(), e.getVaiTro(), e.getLuongCa(), e.getPass(), e.getAvatar(), e.getIdNV());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.Update(DELETE_NV, id);
    }

    @Override
    public NHANVIEN selectById(String id) {
        List<NHANVIEN> nv = this.selectBySql(SELECT_BY_IDNV, id);
        if (nv.isEmpty()) {
            return null;
        }
       return nv.get(0);
    }

    @Override
    public List<NHANVIEN> selectAll() {
        return this.selectBySql(SELECT_ALL_NV);
    }

    @Override
    protected List<NHANVIEN> selectBySql(String sql, Object... a) {
       List<NHANVIEN> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.Query(sql, a);
            while (rs.next()) {                
                NHANVIEN nv = new NHANVIEN();
                nv.setIdNV(rs.getString("idNV"));
                nv.setTenNV(rs.getString("tenNV"));
                nv.setTuoi(rs.getInt("tuoi"));
                nv.setGt(rs.getBoolean("gt"));
                nv.setSdt(rs.getString("sdt"));
                nv.setCmnd(rs.getString("cmnd"));
                nv.setVaiTro(rs.getString("vaitro"));
                nv.setLuongCa(rs.getDouble("luongCa"));
                nv.setPass(rs.getString("pass"));
                nv.setAvatar(rs.getString("avatar"));
                list.add(nv);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
