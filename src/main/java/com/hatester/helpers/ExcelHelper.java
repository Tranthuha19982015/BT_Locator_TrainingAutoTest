package com.hatester.helpers;

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
    private Workbook wb;
    private Sheet sh;
    private String excelFilePath; //Lưu path file Excel để dùng khi ghi lại

    private Map<String, Integer> columns = new HashMap<>(); //Dùng Map để lưu tên cột và vị trí cột

    private CellStyle defaultStyle;
    private static final String DATE_FORMAT = "dd-MM-yyyy";

    //hàm này để đọc data từ sheet trong Excel
    public void setExcelFile(String ExcelPath, String SheetName) {
        try {
            File file = new File(ExcelPath);

            if (!file.exists()) {
                throw new RuntimeException("File doesn't exist.");
            }
            fis = new FileInputStream(file);  //Vì file đã chứa TẤT CẢ thông tin của excelPath rồi nên truyền file
            wb = WorkbookFactory.create(fis);  //WorkbookFactory.create() → tự nhận .xls hay .xlsx
            fis.close();
            sh = wb.getSheet(SheetName);

            if (sh == null) {
                throw new Exception("Sheet name doesn't exist.");
            }

            this.excelFilePath = ExcelPath;
            columns.clear();

            Row headerRow = sh.getRow(0);
            if (headerRow == null) {
                throw new RuntimeException("Header row (row 0) is empty");
            }

            //adding all the column header names to the map 'columns'
            headerRow.forEach(cell -> {
                columns.put(cell.getStringCellValue(), cell.getColumnIndex());
            });

        } catch (Exception e) {
            throw new RuntimeException("Cannot load Excel file", e);
        }
    }

    //đọc data từng ô theo vị trí cột, vị trí dòng
    public String getCellData(int columnIndex, int rowIndex) {
        if (sh == null) {
            throw new RuntimeException("Excel file is not loaded. Call setExcelFile() first.");
        }
        Row row = sh.getRow(rowIndex);
        if (row == null) return "";

        Cell cell = row.getCell(columnIndex);
        if (cell == null) return "";

        String cellData = null;
        switch (cell.getCellType()) {
            case STRING:
                cellData = cell.getStringCellValue().trim();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    Date date = cell.getDateCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                    cellData = sdf.format(date);
                } else {
                    double value = cell.getNumericCellValue();
                    if (value == (long) value) {
                        cellData = String.valueOf((long) value);
                    } else {
                        cellData = String.valueOf(value);
                    }
                }
                break;
            case BOOLEAN:
                cellData = String.valueOf(cell.getBooleanCellValue());
                break;
            case BLANK:
                cellData = "";
                break;
        }
        return cellData;
    }

    //đọc data từng ô theo tên cột, vị trí dòng
    public String getCellData(String columnName, int rowIndex) {
        if (columns.get(columnName) == null) {
            throw new RuntimeException("Column name " + columnName + " does not exist.");
        }
        return getCellData(columns.get(columnName), rowIndex);
    }

    private CellStyle getDefaultStyle() {
        if (defaultStyle == null) {
            defaultStyle = wb.createCellStyle();
            defaultStyle.setAlignment(HorizontalAlignment.CENTER);
            defaultStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        }
        return defaultStyle;
    }

    //set by column index
    public void setCellData(String text, int columnIndex, int rowIndex) {
        if (sh == null) {
            throw new RuntimeException("Excel file is not loaded. Call setExcelFile() first.");
        }
        try(FileOutputStream fileOut = new FileOutputStream(excelFilePath)) {
            Row row = sh.getRow(rowIndex);

            //Nếu row chưa tồn tại → create
            if (row == null) {
                row = sh.createRow(rowIndex);
            }
            Cell cell = row.getCell(columnIndex);

            if (cell == null) {
                cell = row.createCell(columnIndex);
            }
            cell.setCellValue(text); //set giá trị cho ô

            cell.setCellStyle(getDefaultStyle()); //set format cho ô

            wb.write(fileOut);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //set by column name
    public void setCellData(String text, String columnName, int rowIndex) {
        if (!columns.containsKey(columnName)) {
            throw new RuntimeException("Column name " + columnName + " does not exist.");
        }
        setCellData(text, columns.get(columnName), rowIndex);
    }

    public void close() {
        try {
            if (wb != null) wb.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
