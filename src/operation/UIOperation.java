package operation;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UIOperation {
	
	public UIOperation(WebDriver driver) {
		super();
		this.driver = driver;
	}

	WebDriver driver;
	
	    public void perform(Properties p,String operation,String objectName,String objectType,String value) throws Exception
		{

	        switch (operation.toUpperCase())
			{
	        case "CLICK":
	            driver.findElement(this.getObject(p,objectName,objectType)).click();
	            break;
	        case "SETTEXT":
	          driver.findElement(this.getObject(p,objectName,objectType)).sendKeys(value);
	            break;
	            
	        case "GOTOURL":

	            driver.get(p.getProperty(value));
	            break;
	        case "GETTEXT":
	           
	            driver.findElement(this.getObject(p,objectName,objectType)).getText();
	            break;
	        default:
	            break;
	        }
	    }
	    
	    /**
	     * Find element BY using object type and value
	     * @param p
	     * @param objectName
	     * @param objectType
	     * @return
	     * @throws Exception
	     **/
	    private By getObject(Properties p,String objectName,String objectType) throws Exception
		{
	       
	        if(objectType.equalsIgnoreCase("XPATH")){
	            
	            return By.xpath(p.getProperty(objectName));//P get the locator path set in this place
	        }
	      
	        else if(objectType.equalsIgnoreCase("CLASSNAME")){
	            
	            return By.className(p.getProperty(objectName));
	            
	        }
	      
	        else if(objectType.equalsIgnoreCase("NAME"))
			{
	            
	            return By.name(p.getProperty(objectName));  
	        }
	        else if(objectType.equalsIgnoreCase("ID"))
			{
	            
	            return By.id(p.getProperty(objectName));  
	        }
	    
	        else if(objectType.equalsIgnoreCase("CSS")){
	            
	            return By.cssSelector(p.getProperty(objectName));
	            
	        }
	     
	        else if(objectType.equalsIgnoreCase("LINK")){
	            
	            return By.linkText(p.getProperty(objectName));
	            
	        }
	      
	        else if(objectType.equalsIgnoreCase("PARTIALLINK")){
	            
	            return By.partialLinkText(p.getProperty(objectName));
	            
	        }else
	        {
	            throw new Exception("Wrong object type");
	        }
	    }
	
}
