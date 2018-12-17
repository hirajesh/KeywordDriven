package testcase;

import java.util.Properties;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import excel.ReadExcelData;
import operation.Readobject;
import operation.UIOperation;

public class ExecuteTest {
	
	@Test
    public void testLogin() throws Exception 
	{
       
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\New folder\\chromedriver.exe"); 
WebDriver webdriver = new ChromeDriver();
webdriver.manage().window().maximize();

ReadExcelData file = new ReadExcelData();
UIOperation operation = new UIOperation(webdriver);
Readobject object = new Readobject();
Properties allObjects = object.ReadProperties();


Sheet guru99Sheet = file.Read();



    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
    System.out.println("count is : "+rowCount);
  
    for (int i = 1; i < rowCount+1; i++) {
  
        Row row = guru99Sheet.getRow(i);
      
        if(row.getCell(0).toString().trim().length()==0)
		{
operation.perform(allObjects, row.getCell(1).toString(), row.getCell(2).toString(),row.getCell(3).toString(), row.getCell(4).toString());
        }		
        else
		{            
System.out.println("New Testcase->"+row.getCell(0).toString() +" Started");

        }
     }
    System.out.println("Testcase Exceuted Successfully");
	webdriver.close();
	}

}
