/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TienIch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP PC
 */
public class JdbcHelper {
    public static void main(String[] args) {
        JdbcHelper s = new JdbcHelper();
        
    }

    static String drive = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String url = "jdbc:sqlserver://localhost:1433;databaseName=QUAN_AN";
    static String user = "sa";
    static String pass = "admin123";

    static {
        try {
            Class.forName(drive);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PreparedStatement GetStmt(String sql, Object... a) throws SQLException {

        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt;

        if (sql.trim().startsWith("{")) {
            stmt = con.prepareCall(sql);
        } else {
            stmt = con.prepareStatement(sql);
            
        }
        for (int i = 0; i < a.length; i++) {
            stmt.setObject(i + 1, a[i]);
        }

        return stmt;
    }

    //cau lenh query 
    public static ResultSet Query(String sql, Object... a) {
        PreparedStatement stmt;
        try {
            stmt = JdbcHelper.GetStmt(sql, a);
            return stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(JdbcHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //cau lenh truy van 1 gia tri
    public static Object Value(String sql, Object... a) {
        try {
            ResultSet rs = JdbcHelper.Query(sql, a);
            if (rs.next()) {
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //cau lenh lien quan thay doi du lieu
    public static int Update(String sql, Object... a) {
        try {
            PreparedStatement stmt = JdbcHelper.GetStmt(sql, a);
            try {
                return stmt.executeUpdate();
            } catch (Exception e) {
            } finally {
                stmt.getConnection().close();
            }
        } catch (Exception e) {
        }
        return -1;
    }
}
