package com.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Random;

import org.openqa.selenium.WebDriver;

public class JavaUtility {

	public int getRandomno()
	{
		Random ran=new Random();
		int random=ran.nextInt(500);
		return random;
	}
	public String getSystemdate()
	{
		java.util.Date dt=new java.util.Date();
		String date=dt.toString();
		return date;
	}
	public String getSystemDateinFormat()
	{
		SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		java.util.Date dt=new java.util.Date();
		String sysDateinFormat=dateformat.format(dt);
		return sysDateinFormat;
	}
	public Robot robotObj() throws AWTException {
		Robot rb= new Robot();
		
		return rb;
	}
	
	public void enterKeypress(WebDriver driver) throws AWTException {
		robotObj().keyPress(KeyEvent.VK_ENTER);
	}
	
	
	public void enterKeyrelease(WebDriver driver) throws AWTException {
		robotObj().keyRelease(KeyEvent.VK_ENTER);
	}
}
