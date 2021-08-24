/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.BAN;
import TienIch.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public class BANDAO extends AbsDao<BAN, Integer>{
    String INSERT_BAN = "INSERT INTO BAN(tenBan,vitri) values (?, ?)";
    String UPDATE_BAN = "UPDATE BAN SET tenBan = ?, vitri = ? WHERE idBan = ?";
    String DELETE_BAN = "DELETE FROM BAN WHERE idBan = ?";
    String SELECT_ALL_BAN = "SELECT * FROM BAN";
    String SELECTID = "SELECT * FROM BAN WHERE idBan = ?";
    String SELECT_BAN_TRONG = "SELECT * FROM BAN WHERE trangthai = N'Trống'";
    String UPDATE_TT_BAN_DSD = "UPDATE BAN SET trangthai = N'Đang sử dụng' WHERE idBan = ?";
    String UPDATE_TT_BAN_Trong = "UPDATE BAN SET trangthai = N'Trống' WHERE idBan = ?";
    
    @Override
    public void insert(BAN e) {
        JdbcHelper.Update(INSERT_BAN, e.getTenBan(), e.getVitri());
    }

    @Override
    public void update(BAN e) {
        JdbcHelper.Update(UPDATE_BAN, e.getTenBan(), e.getVitri(), e.getIdBan());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.Update(DELETE_BAN, id);
    }

    @Override
    public BAN selectById(Integer id) {
        List<BAN> nv = this.selectBySql(SELECTID, id);
        if (nv.isEmpty()) {
            return null;
        }
       return nv.get(0);
    }

    @Override
    public List<BAN> selectAll() {
       return this.selectBySql(SELECT_ALL_BAN);
    }

    @Override
    protected List<BAN> selectBySql(String sql, Object... a) {
       List<BAN> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.Query(sql, a);
            while (rs.next()) {
                BAN b = new BAN();
                b.setIdBan(rs.getInt("idBan"));
                b.setTenBan(rs.getString("tenBan"));
                b.setVitri(rs.getString("vitri"));
                b.setTrangthai(rs.getString("trangthai"));
                list.add(b);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<BAN> selectBanTrong() {
       return this.selectBySql(SELECT_BAN_TRONG);
    }
    
    public void updateTrangThaiBan(Integer id) {
        JdbcHelper.Update(UPDATE_TT_BAN_DSD, id);
    }
    
    public void updateTrangThaiBanTrong(Integer id) {
        JdbcHelper.Update(UPDATE_TT_BAN_Trong, id);
    }
}
    

