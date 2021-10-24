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
public class HoaDon {
    Connect conn = new Connect();
    public ResultSet getData() throws Exception{
        ResultSet rs = null;
        try {
            conn.Connection();
            String sql = "select * from HoaDon order by TongTien desc";
            rs = conn.GetData(sql,null);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet getData(String ma) throws Exception{
        ResultSet rs = null;
        try {
            conn.Connection();
            
            String sql = "select * from HoaDon where MaHD = ?";
            List <String> data = new LinkedList<>();
            data.add(ma);
            rs = conn.GetData(sql,data);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public void InsertData(String MaHD, String MaNV, String MaKH, String NgayHD) throws Exception{
        ResultSet rs = null;
        try {
            conn.Connection();
            String sql = "insert into HoaDon values (?, ?, ?, ?, 0, 'No')";
            List <String> data = new LinkedList<>();
            data.add(MaHD); data.add(MaNV); data.add(MaKH); data.add(NgayHD);
            conn.UpdateData(sql,data);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DeleteData(String ma) throws Exception{
        try {
            conn.Connection();
            String sql = "delete from HoaDon where MaHD = ?";
            List <String> data = new LinkedList<>();
            data.add(ma);
            conn.UpdateData(sql,data);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
