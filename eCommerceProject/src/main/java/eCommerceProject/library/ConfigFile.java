package eCommerceProject.library;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFile {

	public  String configProp(String parameterName) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Properties p = new Properties();
		//Writing into a file
		FileInputStream  fis = new FileInputStream("D:\\SeleniumWebdriver-Java-from-Scratch\\eCommerceProject\\src\\main\\resources\\config.properties");
		p.load(fis);
		System.out.println("Parametr paased ::::"+p.getProperty(parameterName));
		Thread.sleep(2000);
		return p.getProperty(parameterName);

		//
	}
}
