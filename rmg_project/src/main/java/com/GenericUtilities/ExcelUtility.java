package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	/**
	 * This method is used to read the data from excelSheet
	 * @author siddhi
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		String value = sh.getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
	/**
	 * This method is used to get the total number of row present in Excel
	 * @author siddhi
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getTotalRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		return rowCount;
	}
	/**
	 * This method is used to get the total number of cell present in Excel
	 * @author siddhi
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getTotalCellCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int cellCount = sh.getRow(0).getLastCellNum();
		return cellCount;
	}
	/**
	 * This method is used to write the data into ExcelSheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetName,int rowNo,int cellNo,String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		sh.createRow(rowNo).createCell(cellNo).setCellValue(data);
		
		FileOutputStream fout = new FileOutputStream(IPathConstant.ExcelPath);
		wb.write(fout);
		wb.close();
	}
	/**
	 * This method is used to read all the data from Excel in oneShot
	 * @author siddhi
	 * @param sheetName
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	/*public void readAllDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		int cellCount = sh.getRow(0).getLastCellNum();
		for(int i=0;i<=rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				String value = sh.getRow(i).getCell(j).getStringCellValue();
				System.out.print(value+" ");
			}
			System.out.println(" ");
		}	
	}*/
	
	public HashMap<String,String> readMultipleData(String sheetName,int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		
		HashMap<String,String> map= new HashMap<String,String>();
		for(int i=0;i<=rowCount;i++) {
			String key = sh.getRow(i).getCell(cellNo).getStringCellValue();
	        String value = sh.getRow(i).getCell(cellNo+1).getStringCellValue();
	        map.put(key, value);
		}
		return map;
	}
	
}



















