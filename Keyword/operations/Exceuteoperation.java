package operations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Exceuteoperation {
	
	Properties Allproperties=new Properties();
	
	public Properties readproperties() throws IOException
	{
    InputStream properties=new FileInputStream(new File(System.getProperty("user.dir")+"\\Keyword\\chmobject\\object.properties"));
   // InputStream stream = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\objects\\objectss.properties"));
    Allproperties.load(properties);
	return Allproperties;	
	}


}
