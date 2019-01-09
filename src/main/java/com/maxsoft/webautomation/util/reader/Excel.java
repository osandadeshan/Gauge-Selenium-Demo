package com.maxsoft.webautomation.util.reader;

import com.maxsoft.webautomation.common.Base;
import com.thoughtworks.gauge.Gauge;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Project Name : Gauge-UI-Automation-Demo
 * Developer    : Osanda Deshan
 * Version      : 1.0.0
 * Date         : 12/12/2018
 * Time         : 11:20
 * Description  :
**/


public class Excel {

    private static Base baseObj = new Base();
    private static String excelFilePath = baseObj.testDataExcelFilePath();
    private static final int DEFAULT_TEXT_DISTANCE = 40;
    private static final int TEXT_DISTANCE = 40;
    private static final String SPACE = " ";

    public static int findRowNumber(String sheetName, String cellContent) throws IOException {
        FileInputStream excelFile = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet workSheet = workbook.getSheet(sheetName);
        for (Row row : workSheet) {
            for (Cell cell : row) {
                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    if (cell.getRichStringCellValue().getString().trim().equals(cellContent)) {
                        return row.getRowNum();
                    }
                }
            }
        }
        return 0;
    }

    public static String getData(String sheetName, String cellContent) {
        String cellValue = "";
        int colNum = 1;
        try {
            FileInputStream excelFile = new FileInputStream(new File(excelFilePath));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet workSheet = workbook.getSheet(sheetName);
            cellValue = workSheet.getRow(Excel.findRowNumber(sheetName, cellContent)).getCell(colNum).getStringCellValue();
            System.out.println("Key: [" + cellContent + "] " + getSpaces(cellContent.length()) + " Value: [" + cellValue + "]");
            Gauge.writeMessage("<pre>Key: [" + cellContent + "] " + getSpaces(cellContent.length()) + " Value: [" + cellValue + "]</pre>");
            return cellValue;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cellValue;
    }

    public static String getSpaces(int charCount){
        String spaces = "";
        int noOfSpaces = TEXT_DISTANCE - charCount;
        if (noOfSpaces > 0) {
            for (int i = 0; i < noOfSpaces; i++) {
                spaces = spaces.concat(SPACE);
            }
        } else {
            for (int i = 0; i < DEFAULT_TEXT_DISTANCE; i++) {
                spaces = spaces.concat(SPACE);
            }
        }
        return spaces;
    }


}
