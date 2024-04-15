package testng;

import org.testng.annotations.Test;

public class DPTest {

	@Test(dataProviderClass = DataProviderFromExcelTest.class,dataProvider = "dataFromExcel")
	public void getData(String org,String loc,String course) {
		System.out.println(org +"-->"+loc+"-->"+course);
	}
}
