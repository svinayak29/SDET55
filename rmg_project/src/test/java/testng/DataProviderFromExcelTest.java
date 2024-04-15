package testng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.GenericUtilities.IPathConstant;

public class DataProviderFromExcelTest {

	@DataProvider
	public Object[][] dataFromExcel() throws EncryptedDocumentException, IOException {
		FileInputStream fis =new FileInputStream(IPathConstant.ecxelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Data");
		int rowCount = sh.getLastRowNum()+1;
		int cellCount = sh.getRow(0).getLastCellNum();
		Object obj[][]= new Object[rowCount][cellCount];
		
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j <cellCount; j++) {
				obj[i][j]= sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
}
