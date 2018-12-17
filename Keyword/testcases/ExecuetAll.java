package testcases;


import java.util.Properties;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import operations.Exceuteoperation;
import operations.UIOpertaions;
import readexcel.ReadExcelFile;



public class ExecuetAll {
		WebDriver driver;
	int rowcount;
	Row getrows;
	
	@Test
	public void Exceute() throws Exception 
	{

		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\New folder\\chromedriver.exe"); 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
		Exceuteoperation operation=new Exceuteoperation();
		ReadExcelFile Readexcel=new ReadExcelFile();
		UIOpertaions Pass_UI_Values=new UIOpertaions(driver);
		
		Properties Access_Objects_From_OperationClass = operation.readproperties();
		Sheet Access_Objects_From_ExcelFile=Readexcel.readfile();
		
		rowcount=Access_Objects_From_ExcelFile.getLastRowNum()-Access_Objects_From_ExcelFile.getFirstRowNum();
		System.out.println("count is : "+rowcount);
		
		
		for(int i=1;i<rowcount+1;i++)
		{
			getrows=Access_Objects_From_ExcelFile.getRow(i);
			
			if(getrows.getCell(0).toString().trim().length()==0)
			{
				
				Pass_UI_Values.ui(Access_Objects_From_OperationClass, getrows.getCell(1).toString(), getrows.getCell(2).toString(), getrows.getCell(3).toString(), getrows.getCell(4).toString());
				Thread.sleep(2000);
				
				
			}
			else
			{
				System.out.println("Testcase->"+getrows.getCell(0).toString() +" Started");
			}
			
		}
		System.out.println("Testcase Exceuted Successfully");
	//	driver.close();
	}


}
