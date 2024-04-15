package com.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImpClass implements ITestListener {
 
	@Override
	public void onFinish(ITestContext context) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriverUtility wUtils = new WebDriverUtility();
		String methodName = result.getMethod().getMethodName();
		try {
			wUtils.getScreenShotOfWebPage(BaseClass.sdriver,methodName );
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	}

	
	
}
