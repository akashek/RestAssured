package com.restapi.testcases;

import org.testng.annotations.Test;

import com.restapi.base.Base;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC5_del extends Base{
	
	int empid=10830;
	
	@Test
	void getempid() throws InterruptedException 
	{
		logger.info("Get any one id");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpreq=RestAssured.given();
		
		logger.info("Emp ID:"+ empid);
		response=httpreq.request(Method.GET,"/employee/"+empid);

		//Delete method 
		response=httpreq.request(Method.DELETE,"/delete/"+empid);
		Thread.sleep(2000);

}

}
