/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author llong
 */
public class Excel {

    public Excel() {
    }
    
    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }
    public void WriteExcel(String Excel_Name, String []ColsName, ResultSet rs) throws Exception{
        FileOutputStream outFile = null;
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Báo Cáo");
            
         
            int rownum = 0;
            Cell cell;
            Row row;
            
            HSSFCellStyle style = createStyleForTitle(workbook);
            row = sheet.createRow(rownum);
            //head
            for (int i = 0; i < ColsName.length ; i ++) {
                cell = row.createCell(i, CellType.STRING);
                cell.setCellValue(ColsName[i]);
                cell.setCellStyle(style);
            }
            
            // Data
            while(rs.next()) {
                rownum++;
                row = sheet.createRow(rownum);
                // A
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(rs.getString(1));
                // B
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(rs.getString(2));
                // C
                cell = row.createCell(2, CellType.NUMERIC);
                cell.setCellValue(rs.getString(3));
                //
                cell = row.createCell(3, CellType.NUMERIC);
                cell.setCellValue(rs.getString(4));
                //
                cell = row.createCell(4, CellType.NUMERIC);
                cell.setCellValue(Integer.parseInt(rs.getString(5)));
                
            }
            row = sheet.createRow(rownum+2);
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Tổng Doanh Thu:");
            String formula = "SUM(E2:E"+(rownum + 1)+")";
            cell = row.createCell(4, CellType.FORMULA);
            cell.setCellFormula(formula);
            
            File file = new File("C:\\Users\\Acer\\Dropbox\\My PC (LAPTOP-JSV9TQI0)\\Desktop\\java\\Excel\\"+Excel_Name+".xls");
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);
            System.out.println("Created file: " + file.getAbsolutePath());
        
        
    }
}
