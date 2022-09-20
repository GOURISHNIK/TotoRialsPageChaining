package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excel {
	
public static String excelPath=System.getProperty("user.dir")+"\\src\\main\\java\\util\\TestData.xlsx";
	
	
	public static Object[][] getTestData(String sheetName) throws IOException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		XSSFWorkbook book = new XSSFWorkbook(file);

		XSSFSheet sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.print(data[i][k]+"   ");
			}
			System.out.println();
		}
		return data;
	}


}
