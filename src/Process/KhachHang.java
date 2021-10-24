/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import Database.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author llong
 */
public class KhachHang {
    Connect conn = new Connect();
    public ResultSet getData() throws Exception{
        ResultSet rs = null;
        try {
            conn.Connection();
            String sql = "select * from KhachHang";
            rs = conn.GetData(sql,null);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet getData(String ma) throws Exception{
        ResultSet rs = null;
        try {
            conn.Connection();
            
            String sql = "select * from KhachHang where MaKH = ?";
            List <String> data = new LinkedList<>();
            data.add(ma);
            rs = conn.GetData(sql,data);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet getData_Name(String TenKH) throws Exception{
        ResultSet rs = null;
        try {
            conn.Connection();
            
            String sql = "select * from KhachHang where TenKH = ?";
            List <String> data = new LinkedList<>();
            data.add(TenKH);
            rs = conn.GetData(sql,data);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet search_Name(String TenKH) throws Exception{
        ResultSet rs = null;
        try {
            conn.Connection();
            
            String sql = "select * from KhachHang where TenKH like '%"+TenKH+"%'";
            List <String> data = new LinkedList<>();
            rs = conn.GetData(sql,null);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public void insertData(String ma, String ten, String sdt) throws Exception{
        try {
            conn.Connection();
            String sql = "insert into KhachHang values (? , ? , ?)";
            List <String> data = new LinkedList<>();
            data.add(ma);
            data.add(ten);
            data.add(sdt);
            conn.UpdateData(sql,data);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void UpdateData(String ma, String ten, String sdt) throws Exception{
        try {
            conn.Connection();
            String sql = "update KhachHang set TenKH = ? , SDT = ? where MaKH = ?";
            List <String> data = new LinkedList<>();
            data.add(ten);
            data.add(sdt);
            data.add(ma);
            conn.UpdateData(sql,data);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void DeleteData(String ma) throws Exception{
        try {
            conn.Connection();
            String sql = "delete from KhachHang where MaKH = ?";
            List <String> data = new LinkedList<>();
            data.add(ma);
            conn.UpdateData(sql,data);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
