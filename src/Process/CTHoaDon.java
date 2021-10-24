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
public class CTHoaDon {
    Connect conn = new Connect();


    public ResultSet getData(String ma) throws Exception{
        ResultSet rs = null;
        try {
            conn.Connection();
            
            String sql = "select HoaDon.MaHD , TenNV, TenKH, NgayHD, TongTien\n" +
                        "from HoaDon, NhanVien, KhachHang \n" +
                        "where HoaDon.MaNV = NhanVien.MaNV and HoaDon.MaKH = KhachHang.MaKH and TrangThai = 'Yes'"
                    + "and HoaDon.MaHD = ?";
            List <String> data = new LinkedList<>();
            data.add(ma);
            rs = conn.GetData(sql,data);
        } catch (SQLException ex) {
            Logger.getLogger(MonAn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet getOneMonAnHD(String MaHD, String MaMon) throws Exception{
        ResultSet rs = null;
        try {
            conn.Connection();
            
            String sql = "select MonAn.MaMon, MonAn.TenMon, MonAn.DonGia, MonAn.Loai , CTHoaDon.SoLuong, Sum(CTHoaDon.SoLuong*MonAn.DonGia) as 'Tong'\n" +
                            "from HoaDon, CTHoaDon, MonAn\n" +
                            "where HoaDon.MaHD = CTHoaDon.MaHD and MonAn.MaMon = CTHoaDon.MaMon and HoaDon.MaHD = ? and MonAn.MaMon = ? \n" +
                            "group by HoaDon.MaHD, MonAn.MaMon, MonAn.TenMon, MonAn.DonGia, CTHoaDon.SoLuong, MonAn.Loai";
            List <String> data = new LinkedList<>();
            data.add(MaHD); data.add(MaMon);
            rs = conn.GetData(sql,data);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet getMonAnHD(String MaHD) throws Exception{
        ResultSet rs = null;
        try {
            conn.Connection();
            
            String sql = "select MonAn.MaMon, MonAn.TenMon, MonAn.DonGia, CTHoaDon.SoLuong, Sum(CTHoaDon.SoLuong*MonAn.DonGia) as 'ThanhTien'\n" +
                            "from HoaDon, CTHoaDon, MonAn\n" +
                            "where HoaDon.MaHD = CTHoaDon.MaHD and MonAn.MaMon = CTHoaDon.MaMon and HoaDon.MaHD = ? \n" +
                            "group by HoaDon.MaHD, MonAn.MaMon, MonAn.TenMon, MonAn.DonGia, CTHoaDon.SoLuong";
            List <String> data = new LinkedList<>();
            data.add(MaHD);
            rs = conn.GetData(sql,data);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public void InsertData(String MaHD, String MaMon, String SoLuong) throws Exception{
        ResultSet rs = null;
        try {
            conn.Connection();
            String sql = "insert into CTHoaDon values (?, ?, ?)";
            List <String> data = new LinkedList<>();
            data.add(MaHD); data.add(MaMon); data.add(SoLuong);
            conn.UpdateData(sql,data);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void UpdateData(String MaHD, String MaMon, String SoLuong) throws Exception{
        ResultSet rs = null;
        try {
            conn.Connection();
            String sql = "update CTHoaDon set MaMon = ? , Soluong = ?  where MaHD = ? and MaMon = ?";
            List <String> data = new LinkedList<>();
            data.add(MaMon); data.add(SoLuong); data.add(MaHD); data.add(MaMon);
            conn.UpdateData(sql,data);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void DeleteData(String MaHD, String MaMon) throws Exception{
        try {
            conn.Connection();
            String sql = "delete from CTHoaDon where MaHD = ? and MaMon = ?";
            List <String> data = new LinkedList<>();
            data.add(MaHD); data.add(MaMon);
            conn.UpdateData(sql,data);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
