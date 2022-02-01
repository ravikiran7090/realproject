package com.comcast.generalUtility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * this method will generate a random no and return it to the caller
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran= new Random();
		int random = ran.nextInt(1000);
		return random;
	}
	/**
	 * this method will return the current date
	 * @return
	 */
	public String getCurrentDate()
	{
		Date date=new Date();
		String currentDate = date.toString();
		return currentDate;
	}
	public String getFinalDateFormat()
	{
		Date date= new Date();
		String d = date.toString();
		String[] dte = d.split(" ");
		String YYYY = dte[5];
		String DD = dte[2];
		String MM = dte[1];
		String today = YYYY+"-"+MM+"-"+DD;
		return today;
	}
	

}
