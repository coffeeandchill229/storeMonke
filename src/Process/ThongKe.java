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
public class ThongKe {
    Connect conn = new Connect();
    
    public ResultSet getData_BCDoanhThu() throws Exception{
        ResultSet rs = null;
        try {
            conn.Connection();
            
            String sql = "select HoaDon.MaHD , TenNV, TenKH, NgayHD, TongTien\n" +
                        "from HoaDon, NhanVien, KhachHang \n" +
                        "where HoaDon.MaNV = NhanVien.MaNV and HoaDon.MaKH = KhachHang.MaKH and TrangThai = 'Yes'\n" +
                        "order by TongTien DESC";
            rs = conn.GetData(sql,null);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet getData_BCDoanhThu(String NgayBD, String NgayKT) throws Exception{
        ResultSet rs = null;
        try {
            conn.Connection();
            
            String sql = "select HoaDon.MaHD , TenNV, TenKH, NgayHD, TongTien\n" +
                        "from HoaDon, NhanVien, KhachHang \n" +
                        "where HoaDon.MaNV = NhanVien.MaNV and HoaDon.MaKH = KhachHang.MaKH and TrangThai = 'Yes'\n" +
                        "	and NgayHD >= CONVERT(date, '"+NgayBD+"') and NgayHD <= CONVERT(date, '"+NgayKT+"')  \n" +
                        "order by TongTien DESC";
//            List <String> data = new LinkedList<>();
//            data.add(NgayBD); data.add(NgayKT);
            rs = conn.GetData(sql,null);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet getData_BCMonAn() throws Exception{
        ResultSet rs = null;
        try {
            conn.Connection();
            
            String sql = "select TOP 10 MonAn.MaMon, MonAn.TenMon, DonGia, SUM(SoLuong) as 'SoLuong', Sum(SoLuong * DonGia) as 'TongTien' \n" +
                        "from MonAn, CTHoaDon\n" +
                        "where MonAn.MaMon = CTHoaDon.MaMon\n" +
                        "group by MonAn.MaMon, MonAn.TenMon, DonGia \n" +
                        "order by SoLuong DESC";
            rs = conn.GetData(sql,null);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet getData_BCMonAn(String NgayBD, String NgayKT) throws Exception{
        ResultSet rs = null;
        try {
            conn.Connection();
            
            String sql = "select TOP 10 MonAn.MaMon, MonAn.TenMon, DonGia, SUM(SoLuong) as 'SoLuong', Sum(SoLuong * DonGia) as 'TongTien' \n" +
                        "from MonAn, CTHoaDon, HoaDon\n" +
                        "where MonAn.MaMon = CTHoaDon.MaMon and HoaDon.MaHD = CTHoaDon.MaHD\n" +
                        "and Hoadon.NgayHD >= CONVERT(date, '"+NgayBD+"') and Hoadon.NgayHD <= CONVERT(date, '"+NgayKT+"') \n" +
                        "group by MonAn.MaMon, MonAn.TenMon, DonGia \n" +
                        "order by SoLuong DESC";
            List <String> data = new LinkedList<>();
            data.add(NgayBD); data.add(NgayKT);
            rs = conn.GetData(sql,null);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
