/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.LICHLAM;
import TienIch.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public class LICHLAMDAO extends AbsDao<LICHLAM, Integer> {

    String Insert_lichLam = "INSERT INTO LICHLAM (idNV, ca, ngay, luongCa, vaitro) VALUES (?, ?, ?, ?, ?)";
    String Update_DiemDanh = "UPDATE LICHLAM SET diemDanh = ? WHERE stt = ?";
    String Delete_LichLam = "DELETE FROM LICHLAM WHERE stt = ?";
    String SELECT_ALL_LL = "SELECT * FROM LICHLAM";
    String SELECT_BY_sttLL = "SELECT * FROM LICHLAM WHERE stt = ?";
    String SELECT_LLNV = "SELECT * FROM LICHLAM WHERE idNV = ?";
    String SELECT_CHECKSONG_NV = "SELECT * FROM LICHLAM WHERE ca = ? and ngay = ? and vaitro = N'NHÂN VIÊN'";
    String SELECT_CHECKSONG_TN = "SELECT * FROM LICHLAM WHERE ca = ? and ngay = ? and vaitro = N'THU NGÂN'";
    String SELECT_LLNV_TG = "select * from LICHLAM where idNV = ? and YEAR(ngay) = ? and MONTH(ngay) = ? order by ngay";
    String SELECT_SCHEDULE = "select * from LICHLAM where ngay = ? order by ca";
    String DELETE_MANV_NGAY_CA = "DELETE FROM LICHLAM WHERE idNV = ?, ngay= ?, ca = ?";

    @Override
    public void insert(LICHLAM e) {
        JdbcHelper.Update(Insert_lichLam, e.getIdNV(), e.getCa(), e.getNgayLam(), e.getLuongCa(), e.getVaitro());
    }

    @Override
    public void update(LICHLAM e) {
        JdbcHelper.Update(Update_DiemDanh, e.isDiemDanh(), e.getStt());
    }

    @Override
    public void delete(Integer stt) {
        JdbcHelper.Update(Delete_LichLam, stt);
    }
    
    public void deleteMaNvNgayCa(String idNV, Date ngay, int ca) {
        JdbcHelper.Update(DELETE_MANV_NGAY_CA, idNV, ngay , ca);
    }

    @Override
    public LICHLAM selectById(Integer id) {
        List<LICHLAM> kh = this.selectBySql(SELECT_BY_sttLL, id);
        if (kh.isEmpty()) {
            return null;
        }
        return kh.get(0);
    }

    @Override
    public List<LICHLAM> selectAll() {
        return this.selectBySql(SELECT_ALL_LL);
    }

    @Override
    protected List<LICHLAM> selectBySql(String sql, Object... a) {
        List<LICHLAM> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.Query(sql, a);
            while (rs.next()) {
                LICHLAM ll = new LICHLAM();
                ll.setStt(rs.getInt("stt"));
                ll.setIdNV(rs.getString("idNV"));
                ll.setCa(rs.getInt("ca"));
                ll.setNgayLam(rs.getDate("ngay"));
                ll.setLuongCa(rs.getDouble("luongCa"));
                ll.setDiemDanh(rs.getBoolean("diemDanh"));
                list.add(ll);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//------------------------------------------------------------------------------------------------------
    //CHẾ
    public List<LICHLAM> selectLichNV(String idNV) {
        List<LICHLAM> list = this.selectBySql(SELECT_LLNV, idNV);
        return list;
    }
    
    public List<LICHLAM> selectLichNV_TG(String idNV, int nam, int thang) {
        List<LICHLAM> list = this.selectBySql(SELECT_LLNV_TG, idNV, nam, thang);
        return list;
    }
    
    public List<LICHLAM> selectBangSchedule(Date ngay) {
        List<LICHLAM> list = this.selectBySql(SELECT_SCHEDULE, ngay);
        return list;
    }

    public List<LICHLAM> checkSoNg_NV(int ca, Date ngay) {
        List<LICHLAM> list = this.selectBySql(SELECT_CHECKSONG_NV, ca, ngay);
        return list;
    }
    
    public List<LICHLAM> checkSoNg_TN(int ca, Date ngay) {
        List<LICHLAM> list = this.selectBySql(SELECT_CHECKSONG_NV, ca, ngay);
        return list;
    }
    
    public List<Integer> selectYears(){
        String sql = "select distinct YEAR(ngay) from LICHLAM order by YEAR(ngay) desc";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.Query(sql);
            while(rs.next()){
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
    
    public List<Integer> selectMonth(int a){
        String sql = "select distinct MONTH(ngay) from LICHLAM where YEAR(ngay) = ? order by MONTH(ngay) desc";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.Query(sql,a);
            while(rs.next()){
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }    
}
