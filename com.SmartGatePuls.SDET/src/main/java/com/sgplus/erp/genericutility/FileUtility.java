package com.sgplus.erp.genericutility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class FileUtility {
	
	//its used to read the data from commonData.properties File based on Key which you pass as an argument
/*	
    public String getPropertyKeyValue(String key) throws Throwable {
   	 FileInputStream fis = new FileInputStream("C:\\Seleniumwebdriver\\commondata.properties");
   	 Properties pobj = new Properties();
   	 pobj.load(fis);
   	 String value = pobj.getProperty(key);
		return value;
    }

	public int getRandomNumber() {
		// TODO Auto-generated method stub
		return 0;   
	}
*/


	

	public String getPropertyKeyValue(String key) throws Throwable {

	    Properties prop = new Properties();

	    InputStream fis = getClass()
	            .getClassLoader()
	            .getResourceAsStream("commondata.properties");

	    if (fis == null) {
	        throw new RuntimeException("commondata.properties NOT FOUND");
	    }

	    prop.load(fis);

	   // System.out.println("==== PROPERTIES FILE LOADED ====");
	    //System.out.println("URL FROM FILE = " + prop.getProperty("url"));
	    //System.out.println("================================");

	    return prop.getProperty(key);
	}
}


