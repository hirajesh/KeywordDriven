package operations;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class UIOpertaions {
	
	Select select;
	
	public UIOpertaions(WebDriver driver) {
		super();
		this.driver = driver;
	}

	WebDriver driver;
	
public void ui(Properties pro,String Operation,String Objectname,String Objecttype,String sendkeysvalues) throws Exception {

	switch (Operation.toUpperCase())
	{
	case "CLICK":
		driver.findElement(this.getobject(pro,Objectname,Objecttype)).click();	
		break;
		
	case "SETTEXT":
		driver.findElement(this.getobject(pro,Objectname,Objecttype)).sendKeys(sendkeysvalues);	
		break;
		
	case "GOTOURL":
		driver.get(pro.getProperty(sendkeysvalues));
		break;
		
	case "GETTEXT":
			driver.findElement(this.getobject(pro,Objectname,Objecttype)).click();	
			break;
	
	}
	
}

private By getobject(Properties pro,String Objectname,String Objecttype) throws Exception {
	// TODO Auto-generated method stub
	
	if(Objecttype.equalsIgnoreCase("XPATH"))
	{
		 return By.xpath(pro.getProperty(Objectname));
	}
	else if(Objecttype.equalsIgnoreCase("ID"))
	{
		return By.id(pro.getProperty(Objectname));
	}
	else if(Objecttype.equalsIgnoreCase("LINKTEXT"))
	{
		return By.linkText(pro.getProperty(Objectname));
	}
	
	else
    {
        throw new Exception("Wrong object type");
    }
	
}


}
