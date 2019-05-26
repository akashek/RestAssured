package com.restapi.testcases;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.restapi.base.Base;
import com.restapi.utilities.RestUtil;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class TC3_post extends Base {

	String empname=RestUtil.empname();
	String empsal=RestUtil.empsal();
	String empage=RestUtil.empAge();
	
	
@Test

void Post() throws InterruptedException {
	logger.info("******* Started TC2_post*");
	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/";
	httpreq=RestAssured.given();
	
	JSONObject requestParams= new JSONObject();
	requestParams.put("name", empname);
	requestParams.put("salary",empsal);
	requestParams.put("age", empage);
	
	httpreq.header("Content-type","application/json");
	httpreq.body(requestParams.toJSONString());
	response=httpreq.request(Method.POST,"/create");
	Thread.sleep(2000);
	
}
	
	

@Test
void checkresponsebody() throws InterruptedException

    {
    String responsebody = response.getBody().asString();
    logger.info("Post Message"+responsebody);
    System.out.println(responsebody);
   Assert.assertEquals(responsebody.contains(empname),true);
    Assert.assertEquals(responsebody.contains(empsal),true);
    Assert.assertEquals(responsebody.contains(empage),true);
}
public static String getid() throws InterruptedException
{
	JsonPath jsonPathEvaluator=response.jsonPath();
	String employeeID=jsonPathEvaluator.getString("id");
	System.out.println("Employee ID received from Response "+ employeeID);
	Thread.sleep(3000);
	
	return(employeeID);
	
}
@Test
void checkStatuscode()
{
    int statuscode = response.getStatusCode();
    logger.info(""+statuscode);
    Assert.assertEquals(statuscode,200);
    String statusline = response.getStatusLine();
    System.out.println(statusline);
}

@Test
void checkresponsetime()
{
    
    logger.info("******Checking Response Time********");
    long responsetime = response.getTime();
    logger.info("Response time is:"+ responsetime);
    
    if(responsetime>2000)
        logger.warn("Response time is greater than 2000");
        
        Assert.assertTrue(responsetime<10000);
        
}
//@Test
//void Checkstatusline()
//{
//logger.info("*********** Checking status Line*********");
//String statusline = response.getStatusLine();
//System.out.println(statusline);
//logger.info("Statusline:" + statusline);
//Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
//
//}

@Test

void checkcontenttype()
{
logger.info("******* Checking content type **********");
String contenttype  = response.header("content-type");
logger.info("Content type is:" + contenttype);
Assert.assertEquals(contenttype, "text/html; charset=UTF-8");


}

@AfterClass

void teardown()
{
	logger.info("******* End of TC3 POST **********");	
}
	
}
