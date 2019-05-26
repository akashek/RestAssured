package com.restapi.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.restapi.base.Base;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC1_get extends  Base {

@BeforeClass

void getAllEmployees()
{
	logger.info("****Started TC1_get******");
	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	httpreq=RestAssured.given();
	response=httpreq.request(Method.GET,"/employees");
	
}
@Test
void checkresponsebody()
    {
    String responsebody = response.getBody().asString();
    logger.info(""+responsebody);
    Assert.assertTrue(responsebody!=null);
}

@Test
void checkStatuscode()
{
    int statuscode = response.getStatusCode();
    logger.info(""+statuscode);
    Assert.assertEquals(statuscode,200);
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
@Test
void Checkstatusline()
{
logger.info("*********** Checking status Line*********");
String statusline = response.getStatusLine();
logger.info("Statusline:" + statusline);
Assert.assertEquals(statusline, "HTTP/1.1 200 OK");

}

@Test

void checkcontenttype()
{
logger.info("******* Checking content type **********");
String contenttype  = response.header("content-type");
logger.info("Content type is:" + contenttype);
Assert.assertEquals(contenttype, "text/html; charset=UTF-8");


}




}
