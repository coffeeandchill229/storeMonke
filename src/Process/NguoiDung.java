/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;
import Database.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author llong
 */
public class NguoiDung {
    Connect conn = new Connect();
    public ResultSet getAll(){
        ResultSet rs = null;
        try {
            conn.Connection();
            String sql = "select * from Nguoidung";
            rs = conn.GetData(sql,null);
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDung.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet getOne1(String tk, String mk){
        ResultSet rs = null;
        conn.Connection();
        String sql = "select * from NguoiDung where taikhoan = '"+ tk +"' and matkhau = '" + mk+"'";
        System.out.println(sql);
        //rs = conn.GetData(sql);
        return rs;
    }
    public ResultSet getOne(String tk, String mk){
        ResultSet rs = null;
        try {
            conn.Connection();
            
            String sql = "select * from NguoiDung where taikhoan = ? and matkhau = ?";
            List <String> data = new LinkedList<>();
            data.add(tk);
            data.add(mk);
            rs = conn.GetData(sql,data);
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDung.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
}
