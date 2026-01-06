package com.hatester.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;

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
            throw new RuntimeException(
                    "Cannot load Excel file: " + ExcelPath + " | Sheet: " + SheetName, e);
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
            case FORMULA:
                cellData = cell.getCellFormula();
                break;
            case ERROR:
                cellData = "";
                break;
            case BLANK:
                cellData = "";
                break;
        }
        return cellData;
    }

    //đọc data từng ô theo tên cột, vị trí dòng
    public String getCellData(String columnName, int rowIndex) {
        if (!columns.containsKey(columnName)) {
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
        try (FileOutputStream fileOut = new FileOutputStream(excelFilePath)) {
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

    //Đọc Excel để dùng cho TestNG DataProvider
    public Object[][] getExcelData(String filePath, String sheetName) {
        Object[][] data = null;
        try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = WorkbookFactory.create(fis)) {
            // load the sheet
            Sheet sh = workbook.getSheet(sheetName);

            // load the row
            Row row = sh.getRow(0);

            int noOfRows = sh.getPhysicalNumberOfRows();
            int noOfCols = row.getLastCellNum();

            System.out.println(noOfRows + " - " + noOfCols);

            Cell cell;
            data = new Object[noOfRows - 1][noOfCols];

            //
            for (int i = 1; i < noOfRows; i++) {
                for (int j = 0; j < noOfCols; j++) {
                    row = sh.getRow(i);
                    if (row == null) {
                        data[i - 1][j] = "";
                        continue;
                    }

                    cell = row.getCell(j);
                    if (cell == null) {
                        data[i - 1][j] = "";
                        continue;
                    }
                    switch (cell.getCellType()) {
                        case STRING:
                            data[i - 1][j] = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                Date date = cell.getDateCellValue();
                                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                                data[i - 1][j] = sdf.format(date);
                            } else {
                                double value = cell.getNumericCellValue();
                                if (value == (long) value) {
                                    data[i - 1][j] = String.valueOf((long) value);
                                } else {
                                    data[i - 1][j] = String.valueOf(value);
                                }
                            }
                            break;
                        case BOOLEAN:
                            data[i - 1][j] = String.valueOf(cell.getBooleanCellValue());
                            break;
                        case FORMULA:
                            data[i - 1][j] = cell.getCellFormula();
                            break;
                        case ERROR:
                            data[i - 1][j] = "";
                            break;
                        case BLANK:
                            data[i - 1][j] = cell.getStringCellValue();
                            break;
                        default:
                            data[i - 1][j] = cell.getStringCellValue();
                            break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("The exception is:" + e.getMessage());
            throw new RuntimeException(e);
        }
        return data;
    }

    //Hàm này dùng cho trường hợp nhiều Field trong File Excel
    public int getColumns() {
        Row row = sh.getRow(0);
        return row.getLastCellNum();
    }

    //Get last row number (lấy vị trí dòng cuối cùng tính từ 0)
    public int getLastRowNum() {
        return sh.getLastRowNum();
    }

    //Lấy số dòng có data đang sử dụng
    public int getPhysicalNumberOfRows() {
        return sh.getPhysicalNumberOfRows();
    }

    public Object[][] getDataMap(String excelPath, String sheetName, int startRow, int endRow) {
        // Mỗi testcase là 1 Map => Object[][1]
        Object[][] data = new Object[(endRow - startRow) + 1][1];

        File f = new File(excelPath);
        if (!f.exists()) {
            throw new RuntimeException("File Excel path not found: " + excelPath);
        }

        try (FileInputStream fis = new FileInputStream(excelPath); Workbook workbook = WorkbookFactory.create(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet name not found: " + sheetName);
            }

            // Header row (row 0)
            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                throw new RuntimeException("Header row (row 0) is empty");
            }

            int totalColumns = headerRow.getPhysicalNumberOfCells();

            System.out.println("Columns: " + totalColumns);
            System.out.println("StartRow: " + startRow + " - EndRow: " + endRow);

            for (int rowNum = startRow; rowNum <= endRow; rowNum++) {

                Row currentRow = sheet.getRow(rowNum);
                Map<String, String> rowData = new Hashtable<>();

                for (int colNum = 0; colNum < totalColumns; colNum++) {

                    // Lấy key từ header
                    Cell headerCell = headerRow.getCell(colNum);
                    String key = "";
                    if (headerCell != null && headerCell.getCellType() == CellType.STRING) {
                        key = headerCell.getStringCellValue().trim();
                    }

                    // Lấy value từ data row
                    String value = "";
                    if (currentRow != null) {
                        Cell dataCell = currentRow.getCell(colNum);

                        // Không dùng getCellData() vì method đó phụ thuộc state (wb, sh)
                        // DataProvider cần đọc workbook độc lập để thread-safe
                        value = getCellValueAsString(dataCell);
                    }
                    rowData.put(key, value);
                }
                data[rowNum - startRow][0] = rowData;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error reading Excel file for DataProvider", e);
        }
        return data;
    }

    private String getCellValueAsString(Cell cell) {
        if (cell == null) return "";

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();

            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return new SimpleDateFormat(DATE_FORMAT)
                            .format(cell.getDateCellValue());
                }
                double value = cell.getNumericCellValue();
                return (value == (long) value) ? String.valueOf((long) value) : String.valueOf(value);

            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());

            case FORMULA:
                return cell.getCellFormula();

            case BLANK:
            case ERROR:
            default:
                return "";
        }
    }
}
