package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelData {
	
	int row;
	
	public Sheet Read() throws IOException 
	{

		File Src=new File("C:\\Users\\Quality Analyst\\Desktop\\Test.xlsx");
		FileInputStream fstream=new FileInputStream(Src);
		XSSFWorkbook workbook=new XSSFWorkbook(fstream);
		XSSFSheet sheet=workbook.getSheetAt(0);
		row=sheet.getLastRowNum();
		return sheet;
		
	}


}
