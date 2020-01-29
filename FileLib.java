package com.crm.acute.generics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib 
{
	/**
	 * read data from properties file based on key
	 * @param key
	 * @return
	 * @throws Exception
	 */
    public String getDataFromProp(String key) throws Exception
    {
    	FileInputStream fis= new FileInputStream("./DataResources/CommonData.properties") ;
    	Properties pObj=  new Properties();
    	pObj.load(fis);
    	String value=pObj.getProperty(key);
    	return value;
    }
    /**
     * get (read) the input data from the Excel sheet  
     * @param sheetName
     * @param rowNum
     * @param cellNum
     * @return
     */
    
    public String getExceldata(String sheetName,int rowNum,int cellNum) 
	{
		String data="";
		try 
		{
		String datapath = getDataFromProp("DataPath");
		Workbook wb= WorkbookFactory.create(new FileInputStream(datapath));
		data=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
		wb.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return data;	
	}
    /**
     * write data back to excel
     * @param sheetName
     * @param rowNum
     * @param cellNum
     * @param data
     * @throws Exception
     */
    public void setExceldata(String sheetName,int rowNum,int cellNum, String data) throws Exception 
	{
		String datapath = getDataFromProp("DataPath");
		Workbook wb= WorkbookFactory.create(new FileInputStream(datapath));
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(data);
		
		FileOutputStream fos= new FileOutputStream(datapath);
		wb.write(fos);
		wb.close();
		
	}
    
    /**
     * get the last used row Count from Excel sheet
     * @param sheetName
     * @return
     * @throws Throwable
     */
    public int getLastRowCount(String sheetName) throws Throwable
	{
    	String datapath = getDataFromProp("DataPath");
    	FileInputStream fis= new FileInputStream(datapath);
		Workbook wb= WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		return rowCount;
	}
	
}
