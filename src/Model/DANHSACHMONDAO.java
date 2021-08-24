/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.DANHSACHMON;
import TienIch.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public class DANHSACHMONDAO extends AbsDao<DANHSACHMON, Integer> {

    String INSERT_DSM = "INSERT INTO DANHSACHMON(tenMon,loai,hinhanh,dongia) values (?, ?, ?, ?)";
    String UPDATE_DSM = "UPDATE DANHSACHMON SET tenMon = ?, loai = ?, hinhanh = ?, dongia =? where idMon = ?";
    String DELETE_DSM = "DELETE FROM DANHSACHMON WHERE idMon = ?";
    String SELECT_ALL_DSM = "SELECT * FROM DANHSACHMON";
    String SELECT_ID_DSM = "SELECT * FROM DANHSACHMON WHERE idMon = ?";
    String SELECT_ALL_DSM_TA = "SELECT * FROM DANHSACHMON WHERE loai = 1";
    String SELECT_ALL_DSM_NU = "SELECT * FROM DANHSACHMON WHERE loai = 0";

    @Override
    public void insert(DANHSACHMON e) {
        JdbcHelper.Update(INSERT_DSM, e.getTenMon(), e.isLoai(), e.getHinhanh(), e.getDonGia());
    }

    @Override
    public void update(DANHSACHMON e) {
        JdbcHelper.Update(UPDATE_DSM, e.getTenMon(), e.isLoai(), e.getHinhanh(), e.getDonGia(), e.getIdMon());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.Update(DELETE_DSM, id);
    }

    @Override
    public DANHSACHMON selectById(Integer id) {
        List<DANHSACHMON> nv = this.selectBySql(SELECT_ID_DSM, id);
        if (nv.isEmpty()) {
            return null;
        }
       return nv.get(0);
    }

    @Override
    public List<DANHSACHMON> selectAll() {
        return this.selectBySql(SELECT_ALL_DSM);
    }
    
    public List<DANHSACHMON> selectAll_Mon(Integer loai) {
        if(loai==1){
            return this.selectBySql(SELECT_ALL_DSM_TA);
        }
        else{
            return this.selectBySql(SELECT_ALL_DSM_NU);
        }
    }

    @Override
    protected List<DANHSACHMON> selectBySql(String sql, Object... a) {
        List<DANHSACHMON> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.Query(sql, a);
            while (rs.next()) {
                DANHSACHMON dsm = new DANHSACHMON();
                dsm.setIdMon(rs.getInt("idMon"));
                dsm.setTenMon(rs.getString("tenMon"));
                dsm.setLoai(rs.getBoolean("loai"));
                dsm.setHinhanh(rs.getString("hinhanh"));
                dsm.setDonGia(rs.getDouble("dongia"));
                list.add(dsm);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
