/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.GHIHOADON;
import TienIch.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public class GHIHOADONDAO extends AbsDao<GHIHOADON, String>{
    String INSERT_GHD = "INSERT INTO GHIHOADON VALUES(?, ?, ?)";
    String UPDATE_GHD = "UPDATE GHIHOADON SET NVghi = ?, idHD = ?, ngay = ?";
    String DELETE_GHD = "DELETE FROM GHIHOADON WHERE NVghi = ?";
    String SELECTALL_GHD = "SELECT * FROM GHIHOADON";
    String SELECTIDNV = "SELECT * FROM GHIHOADON WHERE NVghi = ?";
    String SELECTID_HD = "SELECT * FROM GHIHOADON WHERE idHD = ?";
    String DELETE_GHD_HDT = "DELETE FROM GHIHOADON WHERE idHD = ?";
    
    @Override
    public void insert(GHIHOADON e) {
        JdbcHelper.Update(INSERT_GHD, e.getNVghi(), e.getIdHD(), e.getNgayGhi());
    }

    @Override
    public void update(GHIHOADON e) {
        JdbcHelper.Update(UPDATE_GHD, e.getNVghi(), e.getIdHD(), e.getNgayGhi());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.Update(DELETE_GHD, id);
    }
    
    public void deleteHdTam(Integer id) {
        JdbcHelper.Update(DELETE_GHD_HDT, id);
    }

    @Override
    public GHIHOADON selectById(String id) {
       List<GHIHOADON> ghd = this.selectBySql(SELECTIDNV, id);
        if (ghd.isEmpty()) {
            return null;
        }
       return ghd.get(0);
    }
    
    public GHIHOADON selectById_HD(Integer id) {
       List<GHIHOADON> ghd = this.selectBySql(SELECTID_HD, id);
        if (ghd.isEmpty()) {
            return null;
        }
       return ghd.get(0);
    }

    @Override
    public List<GHIHOADON> selectAll() {
       return this.selectBySql(SELECTALL_GHD);
    }

    @Override
    protected List<GHIHOADON> selectBySql(String sql, Object... a) {
      List<GHIHOADON> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.Query(sql, a);
            while (rs.next()) {
                GHIHOADON ghd = new GHIHOADON();
                ghd.setIdHD(rs.getInt("idHD"));
                ghd.setNVghi(rs.getString("NVghi"));
                ghd.setNgayGhi(rs.getDate("ngay"));
                list.add(ghd);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
