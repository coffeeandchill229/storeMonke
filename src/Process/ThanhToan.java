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
public class ThanhToan {
    Connect conn = new Connect();
    public ResultSet getData(String ma) throws Exception{
        ResultSet rs = null;
        try {
            conn.Connection();
            
            String sql = "select CTHoaDon.MaHD,CTHoaDon.MaMon, MonAn.TenMon,MonAn.DonGia, CTHoaDon.SoLuong, Sum(CTHoaDon.SoLuong*MonAn.DonGia) as ThanhTien\n" +
                        "from CTHoaDon, MonAn\n" +
                        "where CTHoaDon.MaMon = MonAn.MaMon and\n" +
                        "		CTHoaDon.MaHD = ? \n" +
                        "group by CTHoaDon.MaHD, CTHoaDon.MaMon, MonAn.TenMon, CTHoaDon.SoLuong,MonAn.DonGia";
            List <String> data = new LinkedList<>();
            data.add(ma);
            rs = conn.GetData(sql,data);
        } catch (SQLException ex) {
            Logger.getLogger(MonAn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet getThongTin(String ma) throws Exception{
        ResultSet rs = null;
        try {
            conn.Connection();
            
            String sql = "select TenNV, TenKH, NgayHD, TongTien\n" +
                            "from HoaDon, NhanVien, KhachHang\n" +
                            "where	HoaDon.MaKH = KhachHang.MaKH and NhanVien.MaNV = HoaDon.MaNV\n" +
                            "		and HoaDon.MaHD = ? ";
            List <String> data = new LinkedList<>();
            data.add(ma);
            rs = conn.GetData(sql,data);
        } catch (SQLException ex) {
            Logger.getLogger(MonAn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public void UpdateData(String MaHD){
        try {
            conn.Connection();
            
            String sql = "update HoaDon set TrangThai = 'Yes' where MaHD = ?";
            List <String> data = new LinkedList<>();
            data.add(MaHD);
            conn.UpdateData(sql, data);
        } catch (SQLException ex) {
            Logger.getLogger(MonAn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
