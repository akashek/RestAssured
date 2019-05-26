package com.restapi.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtil {

	public static String empname()
	
	{
	String generatedString=RandomStringUtils.randomAlphabetic(2);
	return("abc"+generatedString);
	
	}
	public static String empsal()
	{
		String generatedString=RandomStringUtils.randomNumeric(5);
		return(generatedString);
	}
	
	public static String empAge()
	{
		String generatedString=RandomStringUtils.randomNumeric(2);
		return(generatedString);
	}
}
