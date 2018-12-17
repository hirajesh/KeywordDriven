package readexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	int row;
	
	public Sheet readfile() throws IOException {

		File excelfile=new File("D:\\Eclipse workspace\\KeywordDriven\\CHM KEYWORD DRIVEN2.xlsx");
		FileInputStream input=new FileInputStream(excelfile);
		XSSFWorkbook ExcelWorkbook=new XSSFWorkbook(input);
		XSSFSheet Sheet=ExcelWorkbook.getSheetAt(0);
		row=Sheet.getLastRowNum();
		return Sheet;
		
	}

	
}
