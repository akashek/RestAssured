package com.restapi.testcases;

import org.testng.annotations.Test;

import com.restapi.base.Base;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC2_getid extends Base{
 int empid=11251;
 
 @Test
	void getempid() throws InterruptedException 
	{
		logger.info("Get any one id");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpreq=RestAssured.given();
		
		logger.info("Emp ID:"+ empid);
		response=httpreq.request(Method.GET,"/employee/"+empid);

		//Delete method 
		//response=httpreq.request(Method.DELETE,"/delete/"+empid);
		Thread.sleep(2000);

}
 
 @Test(dependsOnMethods ="getempid")
	void checkresponsebody()
		{
		String responsebody = response.getBody().asString();
		logger.info(""+responsebody);
		Assert.assertTrue(responsebody!=null);
	}
	
}
