package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet s;

	public static String getStringData(int a, int b, String sheet) {
		try {

			f = new FileInputStream(
					"C:\\Users\\Dell-i5\\git\\SeleniumProjectssRepo\\SeleniumProjects\\src\\test\\resources\\TestData.xlsx");
			w = new XSSFWorkbook(f); // reference created
			s = w.getSheet(sheet);
			XSSFRow row = s.getRow(a); // XSSFRow class
			XSSFCell column = row.getCell(b); // XSSFCell class
			return column.getStringCellValue();
		} catch (Exception error) {
			throw new RuntimeException("Excel sheet not found");
		}

	}

	public static String getIntegerData(int a, int b, String sheet) {
		try {
			f = new FileInputStream(
					"C:\\Users\\Dell-i5\\git\\SeleniumProjectssRepo\\SeleniumProjects\\src\\test\\resources\\TestData.xlsx");
			w = new XSSFWorkbook(f); // reference created
			s = w.getSheet(sheet);
			XSSFRow row = s.getRow(a); // XSSFRow class
			XSSFCell column = row.getCell(b); // XSSFCell class
			int cellValue = (int) column.getNumericCellValue(); // get cell value
			return String.valueOf(cellValue);
		} catch (Exception error) {
			throw new RuntimeException("Excel sheet not found");
		}

	}
}
