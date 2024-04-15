package com.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpClass implements IRetryAnalyzer{

	
	int lowercount =0;
	int uperrCount =3;
	@Override
	public boolean retry(ITestResult arg0) {
		
		if(lowercount<uperrCount) {
			lowercount++;
			return true;
		}
				return false;
	}
	
	
}
