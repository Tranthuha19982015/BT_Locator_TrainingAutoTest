package com.hatester.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.poi.ss.usermodel.*;

public class ExcelHelper {

    private FileInputStream fis;
    private Workbook workbook;
    private Sheet sheet;
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
            workbook = WorkbookFactory.create(fis);  //WorkbookFactory.create() → tự nhận .xls hay .xlsx
            fis.close();
            sheet = workbook.getSheet(SheetName);

            if (sheet == null) {
                throw new Exception("Sheet name doesn't exist.");
            }

            this.excelFilePath = ExcelPath;
            columns.clear();

            Row headerRow = sheet.getRow(0);
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
        if (sheet == null) {
            throw new RuntimeException("Excel file is not loaded. Call setExcelFile() first.");
        }
        Row row = sheet.getRow(rowIndex);
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
            defaultStyle = workbook.createCellStyle();
            defaultStyle.setAlignment(HorizontalAlignment.CENTER);
            defaultStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        }
        return defaultStyle;
    }

    //set by column index
    public void setCellData(String text, int columnIndex, int rowIndex) {
        if (sheet == null) {
            throw new RuntimeException("Excel file is not loaded. Call setExcelFile() first.");
        }
        try (FileOutputStream fileOut = new FileOutputStream(excelFilePath)) {
            Row row = sheet.getRow(rowIndex);

            //Nếu row chưa tồn tại → create
            if (row == null) {
                row = sheet.createRow(rowIndex);
            }
            Cell cell = row.getCell(columnIndex);

            if (cell == null) {
                cell = row.createCell(columnIndex);
            }
            cell.setCellValue(text); //set giá trị cho ô

            cell.setCellStyle(getDefaultStyle()); //set format cho ô

            workbook.write(fileOut);
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
            if (workbook != null) workbook.close();
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
        try {
            Row row = sheet.getRow(0);
            return row.getLastCellNum();
        } catch (Exception e) {
//            LogUtils.error(e.getMessage());
            throw (e);
        }
    }

    //Get last row number (lấy vị trí dòng cuối cùng tính từ 0)
    public int getLastRowNum() {
        return sheet.getLastRowNum();
    }

    //Lấy số dòng có data đang sử dụng
    public int getPhysicalNumberOfRows() {
        return sheet.getPhysicalNumberOfRows();
    }

    //Sau khi đọc xong Excel thì 👉 Gộp toàn bộ cột của 1 dòng → thành 1 Map
    //Kết quả sau khi đọc xong thì có n dòng, 1 cột (Mỗi cell là 1 map chứa đầy đủ thông tin của dòng đó trong Excel)
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

    // Get data from specific rows
    public Object[][] getDataFromSpecificRows(String excelPath, String sheetName, int[] rowNumbers) {
        System.out.println("Excel File: " + excelPath);
        System.out.println("Sheet Name: " + sheetName);
        System.out.println("Reading data from specific rows: " + Arrays.toString(rowNumbers));

        Object[][] data = null;

        try {
            File f = new File(excelPath);

            if (!f.exists()) {
                System.out.println("File Excel path not found.");
                throw new FileNotFoundException("File Excel path not found.");
            }

            fis = new FileInputStream(excelPath);
            workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                System.out.println("Sheet name not found.");
                throw new RuntimeException("Sheet name not found.");
            }

            int columns = getColumns();
            System.out.println("Column count: " + columns);

            // Khởi tạo mảng data với kích thước bằng số lượng dòng được chỉ định
            data = new Object[rowNumbers.length][columns];

            // Đọc dữ liệu từ các dòng được chỉ định
            for (int i = 0; i < rowNumbers.length; i++) {
                int rowNum = rowNumbers[i];
                // Kiểm tra xem dòng có tồn tại không
                if (rowNum > sheet.getLastRowNum()) {
                    System.out.println("WARNING: Row " + rowNum + " does not exist in the sheet.");
                    // Gán giá trị rỗng cho dòng không tồn tại
                    for (int j = 0; j < columns; j++) {
                        data[i][j] = "";
                    }
                    continue;
                }

                for (int j = 0; j < columns; j++) {
                    data[i][j] = getCellData(j, rowNum);
                }
            }

            // Đóng workbook và FileInputStream
            workbook.close();
            fis.close();

        } catch (Exception e) {
            System.out.println("Exception in getDataFromSpecificRows: " + e.getMessage());
            e.printStackTrace();
        }

        return data;
    }

    // Get data from specific rows with Hashtable
    public Object[][] getDataHashTableFromSpecificRows(String excelPath, String sheetName, int[] rowNumbers) {
        System.out.println("Excel File: " + excelPath);
        System.out.println("Sheet Name: " + sheetName);
        System.out.println("Reading data from specific rows: " + Arrays.toString(rowNumbers));

        Object[][] data = null;

        try {
            File f = new File(excelPath);

            if (!f.exists()) {
                System.out.println("File Excel path not found.");
                throw new FileNotFoundException("File Excel path not found.");
            }

            fis = new FileInputStream(excelPath);
            workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                System.out.println("Sheet name not found.");
                throw new RuntimeException("Sheet name not found.");
            }

            int columns = getColumns();
            // Khởi tạo mảng data với kích thước bằng số lượng dòng được chỉ định
            data = new Object[rowNumbers.length][1];

            // Đọc dữ liệu từ các dòng được chỉ định
            for (int i = 0; i < rowNumbers.length; i++) {
                int rowNum = rowNumbers[i];
                // Kiểm tra xem dòng có tồn tại không
                if (rowNum > sheet.getLastRowNum()) {
                    System.out.println("WARNING: Row " + rowNum + " does not exist in the sheet.");
                    data[i][0] = new Hashtable<String, String>();
                    continue;
                }

                Hashtable<String, String> table = new Hashtable<>();
                for (int j = 0; j < columns; j++) {
                    // Lấy tên cột từ dòng đầu tiên (header)
                    String columnName = getCellData(j, 0);
                    // Lấy giá trị từ dòng hiện tại và cột j
                    String cellValue = getCellData(j, rowNum);
                    // Thêm vào Hashtable
                    table.put(columnName, cellValue);
                }
                data[i][0] = table;
            }

            // Đóng workbook và FileInputStream
            workbook.close();
            fis.close();

        } catch (Exception e) {
            System.out.println("Exception in getDataHashTableFromSpecificRows: " + e.getMessage());
            e.printStackTrace();
        }

        return data;
    }
}
