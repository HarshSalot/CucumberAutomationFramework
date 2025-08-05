package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.*;
import java.util.*;

public class ExcelUtils {

    public static List<Map<String, String>> readExcelData(String filePath, String sheetName) throws IOException {
        List<Map<String, String>> dataList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) throw new IllegalArgumentException("Sheet " + sheetName + " not found");

            Row headerRow = sheet.getRow(0);
            if (headerRow == null) throw new IllegalStateException("Header row is missing");

            int lastRow = sheet.getLastRowNum();
            for (int i = 1; i <= lastRow; i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                Map<String, String> rowData = new HashMap<>();
                boolean isRowEmpty = true;

                for (int j = 0; j < headerRow.getLastCellNum(); j++) {
                    Cell headerCell = headerRow.getCell(j);
                    Cell dataCell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    if (headerCell != null) {
                        headerCell.setCellType(CellType.STRING);
                        dataCell.setCellType(CellType.STRING);

                        String value = dataCell.getStringCellValue().trim();
                        if (!value.isEmpty()) isRowEmpty = false;

                        rowData.put(headerCell.getStringCellValue().trim(), value);
                    }
                }

                if (!isRowEmpty) {
                    dataList.add(rowData);  // Only add non-empty rows
                }
            }
        }

        return dataList;
    }

    public static void writeResult(String filePath, String sheetName, int rowIndex, String columnName, String value) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet " + sheetName + " does not exist in " + filePath);
            }

            // Get the header row
            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                throw new IllegalStateException("Header row is missing in sheet: " + sheetName);
            }

            // Find column index for the given column name
            int colIndex = -1;
            for (Cell cell : headerRow) {
                if (cell.getStringCellValue().equalsIgnoreCase(columnName)) {
                    colIndex = cell.getColumnIndex();
                    break;
                }
            }

            // If column doesn't exist, create it at the end
            if (colIndex == -1) {
                colIndex = headerRow.getLastCellNum();
                Cell newHeaderCell = headerRow.createCell(colIndex);
                newHeaderCell.setCellValue(columnName);
            }

            // Get or create the row
            Row dataRow = sheet.getRow(rowIndex);
            if (dataRow == null) {
                dataRow = sheet.createRow(rowIndex);
            }

            // Write the result
            Cell resultCell = dataRow.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            resultCell.setCellValue(value);

            // Write back to file
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                workbook.write(fos);
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to write to Excel: " + e.getMessage(), e);
        }
    }

}
