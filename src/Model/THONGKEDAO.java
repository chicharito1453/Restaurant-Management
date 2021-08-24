/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import TienIch.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class THONGKEDAO {

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = JdbcHelper.Query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getMonAn(int year) {
        String sql = "{CALL sp_monan(?)}";
        String[] cols = {"soluotban", "mamon", "tenMon"};
        return this.getListOfArray(sql, cols, year);
    }

    public List<Object[]> getDoanhthu(int year) {
        String sql = " {CALL sp_doanhthu(?)} ";
        String[] cols = {"Soluotban", "Somonban", "HoaDonThapNhat", "HoaDonCaoNhat", "TongDoanhThu"};
        return this.getListOfArray(sql, cols, year);
    }
    public List<Object[]> getLuong(int month, int year) {
        String sql = " {CALL sp_Luong(?, ?)} ";
        String[] cols = {"MaNV", "TenNV", "ChucVu", "TongLuong"};
        return this.getListOfArray(sql, cols, month, year);
    }
    public List<Object[]> getUser() {
        String sql = " Select tenNV, idNV, pass From NHANVIEN ";
        String[] cols = { "TenNV", "IDNV", "Pass"};
        return this.getListOfArray(sql, cols);
    }
    public List<Object[]> Timtheokey(String keyword) {
        String sql = " Select tenNV, idNV, pass FROM NHANVIEN WHERE TenNV LIKE ?";
        String[] cols = { "TenNV", "IDNV", "Pass"};
        return this.getListOfArray(sql, cols, "%"+keyword+ "%");
    }
    public List<Object[]> Timtheoid(String id) {
        String sql = " Select tenNV, idNV, pass FROM NHANVIEN WHERE idNV = ?";
        String[] cols = { "TenNV", "IDNV", "Pass"};
        return this.getListOfArray(sql, cols, id);
    }

    public List<Integer> selectYearsHD(){
        String sql = "select distinct YEAR(ngay) from HOADON order by YEAR(ngay) desc";
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
    public List<Integer> selectYearsL(){
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
    public List<Integer> selectMonthL(){
        String sql = "select distinct Month(ngay) from LICHLAM order by MONTH(ngay) desc";
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
    
    public List<Object[]> TimtheokeyTB(String keyword) {
        String sql = " Select * FROM BAN WHERE tenBan LIKE ?";
        String[] cols = { "idBan", "TenBan", "vitri", "trangthai"};
        return this.getListOfArray(sql, cols, "%"+keyword+ "%");
    }
  
    
}
