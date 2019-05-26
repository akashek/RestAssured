package com.restapi.testcases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.restapi.base.Base;
import com.restapi.utilities.RestUtil;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC4_update extends Base
{
	String empname = RestUtil.empname();
	String empsal = RestUtil.empsal();
	String empage = RestUtil.empAge(); 
	
	
	@Test
	void Post() throws InterruptedException 
	{
		logger.info("TC4");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpreq=RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		 requestParams.put("name", empname);
		 requestParams.put("salary", empsal);
		 requestParams.put("age", empage);
		 
		 httpreq.header("Content-Type", "application/json");
		 httpreq.body(requestParams.toJSONString());
		 response = httpreq.request(Method.PUT,"/update/"+10830);
		 Thread.sleep(5000);
		 
		 
	}

}
