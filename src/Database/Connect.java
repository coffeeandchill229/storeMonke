/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
/**
 *
 * @author llong
 */
public class Connect {
    String host = "localhost";
    int port = 1433;
    String dbName = "QLCHDoAn_Java";
    String Username = "sa";
    String Password = "123456";
    Connection conn = null;
   
    public Connect() {
    }

    public Connect(String host, int port, String dbName, String Username, String Password) {
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.Username = Username;
        this.Password = Password;
    }
    
    public void Connection(){
        String dbURL = "jdbc:sqlserver://"+host+":"+port+";databaseName="+dbName+";";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, Username, Password);
//            System.out.println("Kết nối thành công!");
            
        } catch (Exception ex) {
            System.out.println("Lỗi kết nối: " + ex.getMessage());
        }
    }

    public ResultSet GetData(String sql, List<String> data) throws SQLException{
        ResultSet rs = null;
        if(conn==null){
            Connection();
        }
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            if(data!=null){
                for (int i = 1; i <= data.size(); i++) {
                    ps.setString(i, data.get(i-1));
                    
                }
            }
            rs = ps.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Có Lỗi Xảy Ra !");
            System.out.println("Err getdata : " + e.getMessage());
        }
        return rs;
    }
    
    public void UpdateData(String sql, List<String> data) throws SQLException{
        if(conn==null){
            Connection();
        }
        try {
            PreparedStatement  ps = conn.prepareStatement(sql);
            if(data!=null){
                for (int i = 1; i <= data.size(); i++) {
                    ps.setString(i, data.get(i-1));
                }
            }
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Có Lỗi Xảy Ra !");
            System.out.println("Err updatedata : " + e.getMessage());
        }
    }
    
    public void Close(){ 
       try {
           conn.close();
           System.out.println("Đóng kết nối");
       } catch (SQLException ex) {
           System.out.println("Lỗi Đóng kết nối: " + ex.getMessage());
       }
    }

}
