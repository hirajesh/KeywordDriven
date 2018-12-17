package operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class Readobject {

	Properties pro=new Properties();
	
	public Properties ReadProperties() throws IOException {

		InputStream stream = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\objects\\objectss.properties"));
	//	InputStream stream = new FileInputStream(new File(System.getProperty(“user.dir”)+"D:\\Eclipse workspace\\KeywordDriven\\src\\object\\objectss.properties")));
        //load all objects
        pro.load(stream);
        return pro;
		
	}

	
}
