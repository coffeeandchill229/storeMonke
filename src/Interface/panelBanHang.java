/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Process.CTHoaDon;
import Process.HoaDon;
import Process.KhachHang;
import Process.MonAn;
import Process.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author llong
 */
public class panelBanHang extends javax.swing.JPanel {
    MonAn MA = new MonAn();
    NhanVien NV = new NhanVien();
    KhachHang KH = new KhachHang();
    HoaDon HD = new HoaDon();
    CTHoaDon CTHD = new CTHoaDon();
    // TB mon an 
    final DefaultTableModel tableModelMonAn = new DefaultTableModel();
    // TB hóa đơn : ds món ăn trong hóa đơn
    final DefaultTableModel tableModelMonAnHD = new DefaultTableModel();
    String MaHD;

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }
    /**
     * Creates new form panelBanHang
     */
    public panelBanHang() {
        initComponents();
        String []ColsnameMonAN = {"Mã SP","Tên SP", "Đơn Giá"};
        tableModelMonAn.setColumnIdentifiers(ColsnameMonAN);
        tbMonAn.setModel(tableModelMonAn);
        
        String []ColsnameHD = {"Mã SP","Tên SP", "Đơn Giá", "Số Lượng", "Thành Tiền"};
        tableModelMonAnHD.setColumnIdentifiers(ColsnameHD);
        tbCTHD.setModel(tableModelMonAnHD);
        ShowcbbNV();
        ShowcbbKH();
        LocalDate dateNow = LocalDate.now();
        txtNgayHD.setText(dateNow.toString());
        cbbLoai.hide();
    }
    
    private void ShowcbbNV(){
        ResultSet rs = null;
        try {
            rs = NV.getData();
            while(rs.next()){
                cbbNhanVien.addItem(rs.getString("TenNV"));
            }
        } catch (Exception e) {
        }
    }
    private void ShowcbbKH(){
        ResultSet rs = null;
        try {
            rs = KH.getData();
            while(rs.next()){
                cbbKhachHang.addItem(rs.getString("TenKH"));
            }
        } catch (Exception e) {
        }
    }
    
    private void ShowData(){
        try {
            ShowTBMonAn();
            ShowTBMonAnHD();
            ResultSet rs = HD.getData(getMaHD());
            System.out.println(getMaHD());
            if(rs.next()){
                lbTongTien.setText(rs.getString("TongTien"));
                System.out.println("getTong Tien : " + rs.getString("TongTien"));
            }
        } catch (Exception ex) {
            Logger.getLogger(panelBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void clearText(){
        txtMaMon.setText("");
        txtTenMon.setText("");
        txtDonGia.setText("");
        cbbLoai.setSelectedIndex(0);
        txtTimKiem.setText("");
        spSoLuong.setValue(0);
    }
    // Danh Sách SP ăn trogn hóa đơn
    private void ShowTBMonAn(){
        ResultSet rs = null;
        try {
            rs = MA.getData();
            while(rs.next()){
                String rows[] = new String[4];
                rows[0] = rs.getString("MaMon");
                rows[1] = rs.getString("TenMon");
                rows[2] = rs.getString("DonGia");
                tableModelMonAn.addRow(rows);
            }
        } catch (Exception e) {
            System.out.println("Err : " + e.getMessage());
        }
    }
     private void ShowTBMonAn(String Ten){
        
        ResultSet rs = null;
        try {
            if(Ten.equals("ThucAn") || Ten.equals("DoUong")){
                rs = MA.SearchData_Loai(Ten);
            }
            else{
                rs = MA.SearchData_Ten(Ten);
            }
            clearTBMonAn();
            while(rs.next()){
                String rows[] = new String[4];
                rows[0] = rs.getString("MaMon");
                rows[1] = rs.getString("TenMon");
                rows[2] = rs.getString("DonGia");
                tableModelMonAn.addRow(rows);
            }
        } catch (Exception e) {
            System.out.println("Err : " + e.getMessage());
        }
    }
    
    private void ShowTBMonAnHD(){
        ResultSet rs = null;
        try {
            rs = CTHD.getMonAnHD(getMaHD());
            while(rs.next()){
                String rows[] = new String[5];
                rows[0] = rs.getString("MaMon");
                rows[1] = rs.getString("TenMon");
                rows[2] = rs.getString("DonGia");
                rows[3] = rs.getString("SoLuong");
                rows[4] = rs.getString("ThanhTien");
                tableModelMonAnHD.addRow(rows);
            }
        } catch (Exception e) {
            System.out.println("Err : " + e.getMessage());
        }
    }
    private void clearTBMonAn(){
        int n = tableModelMonAn.getRowCount()-1;
        while(n>=0){
            tableModelMonAn.removeRow(n--);
        }
    }
    private void clearTBMonAnHD(){
        int n = tableModelMonAnHD.getRowCount()-1;
        while(n>=0){
            tableModelMonAnHD.removeRow(n--);
        }
    }

    private void clearData(){
        clearText();
        clearTBMonAn();
        clearTBMonAnHD();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jLabel8 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbbNhanVien = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbbKhachHang = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtNgayHD = new javax.swing.JTextField();
        lbMaKH = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbMaNV = new javax.swing.JLabel();
        cbbLoaiKhach = new javax.swing.JComboBox<>();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jLabel5 = new javax.swing.JLabel();
        spSoLuong = new javax.swing.JSpinner();
        cbbLoai = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenMon = new javax.swing.JTextField();
        txtMaMon = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        txtTimKiem = new javax.swing.JTextField();
        btnTimkiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMonAn = new javax.swing.JTable();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        btnTaoHD = new javax.swing.JButton();
        btnThemMon = new javax.swing.JButton();
        btnXoaMon = new javax.swing.JButton();
        jLayeredPane7 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCTHD = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        lbTongTien = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setMaximumSize(new java.awt.Dimension(1040, 610));
        setMinimumSize(new java.awt.Dimension(1040, 610));

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jLayeredPane4.setPreferredSize(new java.awt.Dimension(468, 211));

        jLabel8.setText("Mã Hóa Đơn :");

        jLabel6.setText("Nhân Viên :");

        cbbNhanVien.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbNhanVienItemStateChanged(evt);
            }
        });

        jLabel9.setText("Tên KH :");

        cbbKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khách Lẻ" }));
        cbbKhachHang.setEnabled(false);
        cbbKhachHang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbKhachHangItemStateChanged(evt);
            }
        });

        jLabel10.setText("SDT :");

        txtSDT.setEnabled(false);

        jLabel11.setText("Ngày HD :");

        txtNgayHD.setEnabled(false);

        lbMaKH.setText("TMP");

        jLabel12.setText("Mã KH :");

        jLabel15.setText("Mã NV :");

        lbMaNV.setText(" ");

        cbbLoaiKhach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khách Lẻ", "Khách Quen" }));
        cbbLoaiKhach.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbLoaiKhachItemStateChanged(evt);
            }
        });

        jLayeredPane4.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(txtMaHD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(cbbNhanVien, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(cbbKhachHang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(txtSDT, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(txtNgayHD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(lbMaKH, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(lbMaNV, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(cbbLoaiKhach, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(cbbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbKhachHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(21, 21, 21)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNgayHD)
                    .addComponent(lbMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbLoaiKhach, 0, 111, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLoaiKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMaNV)
                    .addComponent(jLabel15))
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cbbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(lbMaKH))))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtNgayHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10))
                .addGap(31, 31, 31))
        );

        jLayeredPane5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jLayeredPane5.setPreferredSize(new java.awt.Dimension(329, 209));

        jLabel5.setText("Số Lượng :");

        spSoLuong.setToolTipText("");
        spSoLuong.setRequestFocusEnabled(false);

        cbbLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thức Ăn", "Đồ Uống" }));
        cbbLoai.setEnabled(false);

        jLabel3.setText("Đơn Giá :");

        txtDonGia.setEnabled(false);

        jLabel2.setText("Tên SP :");

        txtTenMon.setEnabled(false);

        txtMaMon.setEnabled(false);

        jLabel7.setText("Mã SP :");

        jLayeredPane5.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(spSoLuong, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(cbbLoai, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(txtDonGia, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(txtTenMon, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(txtMaMon, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane5Layout = new javax.swing.GroupLayout(jLayeredPane5);
        jLayeredPane5.setLayout(jLayeredPane5Layout);
        jLayeredPane5Layout.setHorizontalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaMon, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jLayeredPane5Layout.setVerticalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMaMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cbbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(spSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLayeredPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jLayeredPane3.setPreferredSize(new java.awt.Dimension(530, 423));

        btnTimkiem.setText("Tìm kiếm");
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        tbMonAn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbMonAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMonAnMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMonAn);

        jLayeredPane3.setLayer(txtTimKiem, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btnTimkiem, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimkiem)
                .addGap(106, 271, Short.MAX_VALUE))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimkiem))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jLayeredPane6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jLayeredPane6.setPreferredSize(new java.awt.Dimension(180, 190));

        btnTaoHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnTaoHD.setText("Tạo Hóa Đơn");
        btnTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDActionPerformed(evt);
            }
        });

        btnThemMon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnThemMon.setText("Thêm SP");
        btnThemMon.setEnabled(false);
        btnThemMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMonActionPerformed(evt);
            }
        });

        btnXoaMon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png"))); // NOI18N
        btnXoaMon.setText("Xóa SP");
        btnXoaMon.setEnabled(false);
        btnXoaMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMonActionPerformed(evt);
            }
        });

        jLayeredPane6.setLayer(btnTaoHD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(btnThemMon, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(btnXoaMon, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane6Layout = new javax.swing.GroupLayout(jLayeredPane6);
        jLayeredPane6.setLayout(jLayeredPane6Layout);
        jLayeredPane6Layout.setHorizontalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnThemMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTaoHD))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jLayeredPane6Layout.setVerticalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnTaoHD)
                .addGap(26, 26, 26)
                .addComponent(btnThemMon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoaMon)
                .addGap(21, 21, 21))
        );

        jLayeredPane7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jLayeredPane7.setPreferredSize(new java.awt.Dimension(484, 423));

        tbCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbCTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCTHDMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbCTHD);

        jLabel13.setText("Tổng Tiên :");

        jLabel14.setText("VND");

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ref.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        lbTongTien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTongTien.setText("0");

        jLayeredPane7.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(btnReset, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(lbTongTien, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane7Layout = new javax.swing.GroupLayout(jLayeredPane7);
        jLayeredPane7.setLayout(jLayeredPane7Layout);
        jLayeredPane7Layout.setHorizontalGroup(
            jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane7Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(lbTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnReset)
                                .addGap(63, 63, 63)))))
                .addContainerGap())
        );
        jLayeredPane7Layout.setVerticalGroup(
            jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lbTongTien)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addComponent(btnReset)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jLayeredPane2.setLayer(jLayeredPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLayeredPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLayeredPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLayeredPane6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLayeredPane7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLayeredPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLayeredPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLayeredPane5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLayeredPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                    .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLayeredPane1.add(jLayeredPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 610));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/istockphoto-1185853633-612x612.jpg"))); // NOI18N
        jLayeredPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        // TODO add your handling code here:
        String TenMon = txtTimKiem.getText();
        if(TenMon.length() == 0){
            JOptionPane.showMessageDialog(this, "Không được bỏ trống thông tin");
            return;
        }
        clearTBMonAn();
        ShowTBMonAn(TenMon);
    }//GEN-LAST:event_btnTimkiemActionPerformed

    private void tbMonAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMonAnMouseClicked
        // TODO add your handling code here:
        try {
            int row = tbMonAn.getSelectedRow();
            String ma = tbMonAn.getModel().getValueAt(row, 0).toString();
            ResultSet rs = MA.getData(ma);
            if(rs.next()){
                txtMaMon.setText(rs.getString("MaMon"));
                txtTenMon.setText(rs.getString("TenMon"));
                txtDonGia.setText(rs.getString("DonGia"));
                cbbLoai.setSelectedItem(rs.getString("Loai").equals("ThucAn") ? "Thức Ăn" : "Đồ Uống");
                txtMaMon.setEnabled(false);
            }
            btnThemMon.setEnabled(true);
            btnXoaMon.setEnabled(false);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tbMonAnMouseClicked

    private void btnTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHDActionPerformed
        // TODO add your handling code here:
        try {
            String MaHD = txtMaHD.getText();
            String MaNV = lbMaNV.getText();
            String MaKH = lbMaKH.getText();
            String NgayHD = txtNgayHD.getText();
            if(MaHD.length() == 0 || MaNV.length() == 0 || MaKH.length() == 0){
                JOptionPane.showMessageDialog(this, "Không được bỏ trống thông tin");
                return;
            }
            setMaHD(MaHD);
            HD.InsertData(MaHD, MaNV, MaKH, NgayHD);
            btnTaoHD.setEnabled(false);
            txtMaHD.setEnabled(false);
            cbbKhachHang.setEnabled(false);
            cbbLoaiKhach.setEnabled(false);
            cbbNhanVien.setEnabled(false);
            ShowTBMonAn();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Có Lỗi Sảy Ra!");
        }
    }//GEN-LAST:event_btnTaoHDActionPerformed

    private void btnThemMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMonActionPerformed
        // TODO add your handling code here:
        try {
            String MaMon = txtMaMon.getText();
            int sl = Integer.parseInt(spSoLuong.getValue().toString());
            if(sl <= 0){
                JOptionPane.showMessageDialog(this, "Số Lượng Phải Lớn Hơn 0 !");
                return;
            }
            String soluong = ""+sl;
            CTHD.InsertData(getMaHD(), MaMon, soluong);
            clearData();
            ShowData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Có Lỗi Xảy Ra !");
        }

    }//GEN-LAST:event_btnThemMonActionPerformed

    private void btnXoaMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMonActionPerformed
        // TODO add your handling code here:
        try {
            String MaMon = txtMaMon.getText();
            if(MaMon.length() == 0){
                JOptionPane.showMessageDialog(this, "Chọn SP Cần Xóa !");
                return;
            }
            CTHD.DeleteData(getMaHD(), MaMon);
            clearData();
            ShowData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Có Lỗi Xảy Ra !");
        }
    }//GEN-LAST:event_btnXoaMonActionPerformed

    private void tbCTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCTHDMouseClicked
        // TODO add your handling code here:
        try {
            int row = tbCTHD.getSelectedRow();
            String ma = tbCTHD.getModel().getValueAt(row, 0).toString();
            ResultSet rs = CTHD.getOneMonAnHD(getMaHD(), ma);
            if(rs.next()){
                txtMaMon.setText(rs.getString("MaMon"));
                txtTenMon.setText(rs.getString("TenMon"));
                txtDonGia.setText(rs.getString("DonGia"));
                spSoLuong.setValue(rs.getInt("SoLuong"));
                cbbLoai.setSelectedItem(rs.getString("Loai").equals("ThucAn") ? "Thức Ăn" : "Đồ Uống");
            }
            btnThemMon.setEnabled(false);
            btnXoaMon.setEnabled(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tbCTHDMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this, "Chắc Chắn Hoàn Thành Hóa Đơn Này ?") == JOptionPane.YES_OPTION){
            clearData();
            btnTaoHD.setEnabled(true);
            btnXoaMon.setEnabled(false);
            btnThemMon.setEnabled(false);
            txtMaHD.setEnabled(true);
            cbbLoaiKhach.setEnabled(true);
            cbbNhanVien.setEnabled(true);
            setMaHD("");
            txtMaHD.setText("");
            txtSDT.setText("");
            lbTongTien.setText("");
        }

    }//GEN-LAST:event_btnResetActionPerformed

    private void cbbNhanVienItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbNhanVienItemStateChanged
        // TODO add your handling code here:
        ResultSet rs= null;
        try {
            String TenNV = cbbNhanVien.getSelectedItem().toString();
            rs = NV.getData_Name(TenNV);
            if(rs.next()){
                lbMaNV.setText(rs.getString("MaNV"));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbbNhanVienItemStateChanged

    private void cbbKhachHangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbKhachHangItemStateChanged
        // TODO add your handling code here:
        ResultSet rs= null;
        try {
            String TenKH = cbbKhachHang.getSelectedItem().toString();
            rs = KH.getData_Name(TenKH);
            if(rs.next()){
                lbMaKH.setText(rs.getString("MaKH"));
                txtSDT.setText(rs.getString("SDT"));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbbKhachHangItemStateChanged

    private void cbbLoaiKhachItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbLoaiKhachItemStateChanged
        // TODO add your handling code here:
        if(cbbLoaiKhach.getSelectedItem().equals("Khách Lẻ")){
            String TenNV = cbbKhachHang.getSelectedItem().toString();
            cbbKhachHang.setEnabled(false);
            cbbKhachHang.addItem("Khách Lẻ");
            cbbKhachHang.setSelectedItem("Khách Lẻ");
        }else{
            cbbKhachHang.setEnabled(true);
        }

    }//GEN-LAST:event_cbbLoaiKhachItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTaoHD;
    private javax.swing.JButton btnThemMon;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnXoaMon;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbKhachHang;
    private javax.swing.JComboBox<String> cbbLoai;
    private javax.swing.JComboBox<String> cbbLoaiKhach;
    private javax.swing.JComboBox<String> cbbNhanVien;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JLayeredPane jLayeredPane7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbMaKH;
    private javax.swing.JLabel lbMaNV;
    private javax.swing.JLabel lbTongTien;
    private javax.swing.JSpinner spSoLuong;
    private javax.swing.JTable tbCTHD;
    private javax.swing.JTable tbMonAn;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaMon;
    private javax.swing.JTextField txtNgayHD;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenMon;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
