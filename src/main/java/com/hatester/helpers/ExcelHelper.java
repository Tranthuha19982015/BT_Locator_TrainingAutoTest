package com.hatester.helpers;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

public class ExcelHelper {

    private FileInputStream fis;
    private FileOutputStream fileOut;
    private Workbook wb;
    private Sheet sh;
    private Cell cell;
    private Row row;
    private CellStyle cellstyle;
    private Color mycolor;
    private String excelFilePath;
    private Map<String, Integer> columns = new HashMap<>();

    //hàm này để đọc data từ sheet trong Excel
    public void setExcelFile(String ExcelPath, String SheetName) {
        try {
            File f = new File(ExcelPath);

            if (!f.exists()) {
                System.out.println("File doesn't exist.");
            }

            fis = new FileInputStream(ExcelPath);
            wb = WorkbookFactory.create(fis);
            sh = wb.getSheet(SheetName);

            if (sh == null) {
                throw new Exception("Sheet name doesn't exist.");
            }

            this.excelFilePath = ExcelPath;

            //adding all the column header names to the map 'columns'
            sh.getRow(0).forEach(cell -> {
                columns.put(cell.getStringCellValue(), cell.getColumnIndex());
            });

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //đọc data từng ô theo vị trí cột, vị trí dòng
    public String getCellData(int columnIndex, int rowIndex) {
        try {
            cell = sh.getRow(rowIndex).getCell(columnIndex);
            String CellData = null;
            switch (cell.getCellType()) {
                case STRING:
                    CellData = cell.getStringCellValue().trim();
                    break;
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                        CellData = sdf.format(date);
                    } else {
                        CellData = String.valueOf((long) cell.getNumericCellValue());
                    }
                    break;
                case BOOLEAN:
                    CellData = Boolean.toString(cell.getBooleanCellValue());
                    break;
                case BLANK:
                    CellData = "";
                    break;
            }
            return CellData;
        } catch (Exception e) {
            return "";
        }
    }

    //đọc data từng ô theo tên cột, vị trí dòng
    public String getCellData(String columnName, int rowIndex) {
        if (columns.get(columnName) == null) {
            throw new RuntimeException("Column name " + columnName + " does not exist.");
        }
        return getCellData(columns.get(columnName), rowIndex);
    }

    //set by column index
    public void setCellData(String text, int columnIndex, int rowIndex) {
        try {
            row = sh.getRow(rowIndex);
            if (row == null) {
                row = sh.createRow(rowIndex);
            }
            cell = row.getCell(columnIndex);

            if (cell == null) {
                cell = row.createCell(columnIndex);
            }
            cell.setCellValue(text);

            XSSFCellStyle style = (XSSFCellStyle) wb.createCellStyle();
            style.setFillPattern(FillPatternType.NO_FILL);
            style.setAlignment(HorizontalAlignment.CENTER);
            style.setVerticalAlignment(VerticalAlignment.CENTER);

            cell.setCellStyle(style);

            fileOut = new FileOutputStream(excelFilePath);
            wb.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    //set by column name
    public void setCellData(String text, String columnName, int rowIndex) {
        try {
            row = sh.getRow(rowIndex);
            if (row == null) {
                row = sh.createRow(rowIndex);
            }
            cell = row.getCell(columns.get(columnName));

            if (cell == null) {
                cell = row.createCell(columns.get(columnName));
            }
            cell.setCellValue(text); //set giá trị cho ô

            XSSFCellStyle style = (XSSFCellStyle) wb.createCellStyle();
            style.setFillPattern(FillPatternType.NO_FILL);
            style.setAlignment(HorizontalAlignment.CENTER);
            style.setVerticalAlignment(VerticalAlignment.CENTER);

            cell.setCellStyle(style); //set format cho ô

            fileOut = new FileOutputStream(excelFilePath);
            wb.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
