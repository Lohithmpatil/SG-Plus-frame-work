package com.sgplus.erp.genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;

public class ExcelUtility {

    // ✅ ONE SINGLE PATH (NO QUOTES)
    private static final String EXCEL_PATH =
            "C:\\Seleniumwebdriver\\Automation.xlsx";

    // ---------------- READ DATA ----------------
    public String getDataFromExcel(String sheetName, int rowNum, int cellNum)
            throws Exception {

        FileInputStream fis = new FileInputStream(EXCEL_PATH);
        Workbook wb = WorkbookFactory.create(fis);

        Sheet sh = wb.getSheet(sheetName);
        Row row = sh.getRow(rowNum);
        Cell cell = row.getCell(cellNum);

        String data = cell.getStringCellValue();

        wb.close();
        fis.close();

        return data;
    }

    // ---------------- ROW COUNT ----------------
    public int getRowCount(String sheetName) throws Exception {

        FileInputStream fis = new FileInputStream(EXCEL_PATH);
        Workbook wb = WorkbookFactory.create(fis);

        Sheet sh = wb.getSheet(sheetName);
        int rowCount = sh.getLastRowNum();

        wb.close();
        fis.close();

        return rowCount;
    }

    // ---------------- WRITE DATA ----------------
    public void setDataExcel(String sheetName, int rowNum, int cellNum, String data)
            throws Exception {

        FileInputStream fis = new FileInputStream(EXCEL_PATH);
        Workbook wb = WorkbookFactory.create(fis);

        Sheet sh = wb.getSheet(sheetName);
        Row row = sh.getRow(rowNum);
        if (row == null) {
            row = sh.createRow(rowNum);
        }

        Cell cell = row.createCell(cellNum);
        cell.setCellValue(data);

        FileOutputStream fos = new FileOutputStream(EXCEL_PATH);
        wb.write(fos);

        wb.close();
        fis.close();
        fos.close();
    }
}
