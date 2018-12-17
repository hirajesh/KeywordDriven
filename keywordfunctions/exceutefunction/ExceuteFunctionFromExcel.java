package exceutefunction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

import junit.framework.TestListener;
import keypackage.Actionclass;




public class ExceuteFunctionFromExcel {

	
	public static XSSFWorkbook ExcelWorkbook;
	public static XSSFSheet ExcelSheet;
	public static File ExcelFile;
	public static FileInputStream ExcelFileInputStrame;
	public static int rownumber,i;
	public static Row getrows;
	public static Actionclass Exceuteaction;
	public static WebDriver driver;
	public static	Row row ;
	public static Cell cell;
	public static ITestResult TestResults; 
	
	@Test
	public static void ReadExcel_And_Run_Functions() throws IOException, InterruptedException {

		ExcelFile=new File("D:\\Eclipse workspace\\KeywordDriven\\fuctions.xlsx");
		ExcelFileInputStrame=new FileInputStream(ExcelFile);
		ExcelWorkbook=new XSSFWorkbook(ExcelFileInputStrame);
		ExcelSheet=ExcelWorkbook.getSheetAt(0);
		rownumber=ExcelSheet.getLastRowNum()-ExcelSheet.getFirstRowNum();
		
		for(i=1;i<rownumber+1;i++)
		{
			getrows=ExcelSheet.getRow(i);
			
			if(getrows.getCell(3).toString().trim().equalsIgnoreCase("OpenChrome()"))
			{
				Actionclass.OpenChrome();
				System.out.println("===============================================");
				System.out.println("Test Case ID :-" +getrows.getCell(0).toString().trim()+"\nTest Scenario ID :-"+getrows.getCell(1).toString().trim()+"\nTest Case Description :-" +getrows.getCell(2).toString().trim());	
			
				
			}
			else if(getrows.getCell(3).toString().trim().equalsIgnoreCase("GetCHMURL()"))
			{
				System.out.println("===============================================");
				System.out.println("Test Case ID :-" +getrows.getCell(0).toString().trim()+"\nTest Scenario ID :-"+getrows.getCell(1).toString().trim()+"\nTest Case Description :-" +getrows.getCell(2).toString().trim());
				Actionclass.GetCHMURL();
			

			}
			else if(getrows.getCell(3).toString().trim().equalsIgnoreCase("Loginchmapplication()"))
			{
				System.out.println("===============================================");
				System.out.println("Test Case ID :-" +getrows.getCell(0).toString().trim()+"\nTest Scenario ID :-"+getrows.getCell(1).toString().trim()+"\nTest Case Description :-" +getrows.getCell(2).toString().trim());
				Actionclass.Loginchmapplication();
			

			}
			else if(getrows.getCell(3).toString().trim().equalsIgnoreCase("CreateSite()"))
			{
				System.out.println("===============================================");
				System.out.println("Test Case ID :-" +getrows.getCell(0).toString().trim()+"\nTest Scenario ID :-"+getrows.getCell(1).toString().trim()+"\nTest Case Description :-" +getrows.getCell(2).toString().trim());
				Actionclass.CreateSite();
				

			}
			else if(getrows.getCell(3).toString().trim().equalsIgnoreCase("Edit_Site()"))
			{
				System.out.println("===============================================");
				System.out.println("Test Case ID :-" +getrows.getCell(0).toString().trim()+"\nTest Scenario ID :-"+getrows.getCell(1).toString().trim()+"\nTest Case Description :-" +getrows.getCell(2).toString().trim());
				Actionclass.Edit_Site();
			
			}
			else if(getrows.getCell(3).toString().trim().equalsIgnoreCase("Validate_Edit_Site()"))
			{
				System.out.println("===============================================");
				System.out.println("Test Case ID :-" +getrows.getCell(0).toString().trim()+"\nTest Scenario ID :-"+getrows.getCell(1).toString().trim()+"\nTest Case Description :-" +getrows.getCell(2).toString().trim());
				Actionclass.Validate_Edit_Site();
				
			
			}
			else if(getrows.getCell(3).toString().trim().equalsIgnoreCase("Delete_Site()"))
			{
				System.out.println("===============================================");
				System.out.println("Test Case ID :-" +getrows.getCell(0).toString().trim()+"\nTest Scenario ID :-"+getrows.getCell(1).toString().trim()+"\nTest Case Description :-" +getrows.getCell(2).toString().trim());
				Actionclass.Delete_Site();
			
		
			}
			
			else if(getrows.getCell(3).toString().trim().equalsIgnoreCase("Signout()"))
			{
				System.out.println("===============================================");
				System.out.println("Test Case ID :-" +getrows.getCell(0).toString().trim()+"\nTest Scenario ID :-"+getrows.getCell(1).toString().trim()+"\nTest Case Description :-" +getrows.getCell(2).toString().trim());
				Actionclass.Signout();
			}
			
			
		}
		driver.close();
		
	}

public static void UpdateStatus() throws IOException {
	
	if(TestResults.getStatus()==ITestResult.SUCCESS)
	{
		if (cell == null)
			cell = ExcelSheet.getRow(i).createCell(4);
			cell.setCellValue("PASS");
	}
	else
	{
		if (cell == null)
			cell = ExcelSheet.getRow(i).createCell(4);
			cell.setCellValue("FAIL");
		
	}
	
	FileOutputStream output=new FileOutputStream("C:\\Users\\Quality Analyst\\Desktop\\fuctions.xlsx");
	ExcelWorkbook.write(output);
    output.close();	


}


}
