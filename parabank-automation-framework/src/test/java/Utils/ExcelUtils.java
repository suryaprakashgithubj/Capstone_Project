package Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static final String filePath =
	        "src/test/resources/TestData/TestData.xlsx";
	public static void writeData(
	        String sheetName,
	        int rowNum,
	        int colNum,
	        String value) {

	    try {

	        FileInputStream fis =
	                new FileInputStream(
	                        filePath);

	        Workbook workbook =
	                WorkbookFactory.create(fis);

	        Sheet sheet =
	                workbook.getSheet(
	                        sheetName);

	        Row row =
	                sheet.getRow(rowNum);

	        if(row == null) {

	            row =
	                    sheet.createRow(rowNum);
	        }

	        Cell cell =
	                row.getCell(colNum);

	        if(cell == null) {

	            cell =
	                    row.createCell(colNum);
	        }

	        cell.setCellValue(value);

	        fis.close();

	        FileOutputStream fos =
	                new FileOutputStream(
	                        filePath);

	        workbook.write(fos);

	        fos.close();

	        workbook.close();

	    } catch (Exception e) {

	        e.printStackTrace();
	    }
	}
    public static String getCellData(
            String sheetName,
            int rowNum,
            int colNum) {

        try {

            FileInputStream fis =
                    new FileInputStream(
                            "src/test/resources/TestData/TestData.xlsx");

            XSSFWorkbook workbook =
                    new XSSFWorkbook(fis);

            XSSFSheet sheet =
                    workbook.getSheet(sheetName);

            String value =
                    sheet.getRow(rowNum)
                            .getCell(colNum)
                            .toString();

            workbook.close();

            return value;

        } catch (Exception e) {

            e.printStackTrace();

            return "";
        }
    }

    public static int getRowCount(
            String sheetName) {

        try {

            FileInputStream fis =
                    new FileInputStream(
                            "src/test/resources/TestData/TestData.xlsx");

            XSSFWorkbook workbook =
                    new XSSFWorkbook(fis);

            XSSFSheet sheet =
                    workbook.getSheet(sheetName);

            int rows =
                    sheet.getLastRowNum();

            workbook.close();

            return rows;

        } catch (Exception e) {

            e.printStackTrace();

            return 0;
        }
    }
}