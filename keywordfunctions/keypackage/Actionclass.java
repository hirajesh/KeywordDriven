package keypackage;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Actionclass {

	public static WebDriver driver;
	public static String sitename;
	public static ITestResult TestResult; 
	

	public static void OpenChrome() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\New folder\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	
	public static void GetCHMURL() throws InterruptedException {

		driver.get("http://122.165.236.133/CHM01nov/#!");
		Thread.sleep(2000);
	}
	
	public static void Loginchmapplication() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id='txtlip']")).sendKeys("122.165.236.133");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='txtlname']")).sendKeys("administrator");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='txtlpwd']")).sendKeys("cctvware");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='btnlogin']")).click();
		Thread.sleep(2000);

	}
	
	public static void CreateSite() throws InterruptedException {
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='navigation']/ul/li[2]/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='txtsitename']")).sendKeys("SITE001");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='txtsitecode']")).sendKeys("0011");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='txtsiteip']")).sendKeys("192.168.137.124");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='txtsiteurl']")).sendKeys("http://192.168.137.124:8081/VmChm");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='btnsubmit']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[3]/div[7]/div/button")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void Edit_Site() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='tblsite_filter']/label/input")).sendKeys("192.168.137.124");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='tblsite']/tbody/tr/td[2]/div/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='txtsitename']")).clear();
		driver.findElement(By.xpath("//*[@id='txtsitename']")).sendKeys("SITE0001");
		driver.findElement(By.xpath("//*[@id='btnsubmit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div[7]/div/button")).click();
		Thread.sleep(2000);
	
	}
	
	public static void Delete_Site() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id='tblsite_filter']/label/input")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='tblsite_filter']/label/input")).sendKeys("192.168.137.124");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='tblsite']/tbody/tr/td[2]/div/button[2]")).click();
		Thread.sleep(2000);
	//	driver.findElement(By.xpath("/html/body/div[3]/div[7]/button")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div[7]/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div[7]/div/button")).click();
		Thread.sleep(2000);
	}
	
	public static void Validate_Edit_Site() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id='tblsite_filter']/label/input")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='tblsite_filter']/label/input")).sendKeys("192.168.137.124");
		Thread.sleep(2000);
		sitename=driver.findElement(By.xpath("//*[@id='tblsite']/tbody/tr[1]/td[3]")).getText().trim();
		Thread.sleep(2000);
		if(sitename.equals("SITE0001"))
		{
			System.out.println("SITE WAS EDITED SUCCESSFULLY");
		}
		else
		{
			System.out.println("EDIT FUNCTION IS NOT WORKING");
		}
		
	}
	
	public static void Signout() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='topnav']/div[1]/div/div[2]/ul/li[4]/a/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='topnav']/div[1]/div/div[2]/ul/li[4]/div/a")).click();
		Thread.sleep(2000);
	}

}
