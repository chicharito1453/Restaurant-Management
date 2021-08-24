/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.BANSUDUNG;
import TienIch.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public class BANSUDUNGDAO extends AbsDao<BANSUDUNG, Integer>{
    String INSERT_BSD = "INSERT INTO BANSUDUNG VALUES(?, ?, ?)";
    String UPDATE_BSD = "UPDATE BANSUDUNG SET idHD = ?, idBan = ?, ngay = ?";
    String DELETE_BSD = "DELETE FROM BANSUDUNG WHERE idBan = ?";
    String SELECTALL = "SELECT * FROM BANSUDUNG";
    String SELECTIDBAN = "SELECT * FROM BANSUDUNG WHERE idBan = ?";
    String SELECT_MB_FOR_HD = "SELECT * FROM BANSUDUNG WHERE idHD = ?";
    String DELETE_BSD_HDT = "DELETE FROM BANSUDUNG WHERE idHD = ?";
    
    @Override
    public void insert(BANSUDUNG e) {
        JdbcHelper.Update(INSERT_BSD, e.getIdHD(), e.getIdBan(), e.getNgay());
    }

    @Override
    public void update(BANSUDUNG e) {
        JdbcHelper.Update(UPDATE_BSD, e.getIdHD(), e.getIdBan(), e.getNgay());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.Update(DELETE_BSD, id);
    }
    
    public void deleteHDT(Integer id) {
        JdbcHelper.Update(DELETE_BSD_HDT, id);
    }

    @Override
    public BANSUDUNG selectById(Integer id) {
        List<BANSUDUNG> nv = this.selectBySql(SELECTIDBAN, id);
        if (nv.isEmpty()) {
            return null;
        }
       return nv.get(0);
    }

    @Override
    public List<BANSUDUNG> selectAll() {
       return this.selectBySql(SELECTALL);
    }

    @Override
    protected List<BANSUDUNG> selectBySql(String sql, Object... a) {
       List<BANSUDUNG> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.Query(sql, a);
            while (rs.next()) {
                BANSUDUNG bsd = new BANSUDUNG();
                bsd.setIdHD(rs.getInt("idHD"));
                bsd.setIdBan(rs.getInt("idBan"));
                bsd.setNgay(rs.getDate("ngay"));
                list.add(bsd);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public BANSUDUNG idBanForHD(Integer id) {
        List<BANSUDUNG> nv = this.selectBySql(SELECT_MB_FOR_HD, id);
        if (nv.isEmpty()) {
            return null;
        }
       return nv.get(0);
    }

}
