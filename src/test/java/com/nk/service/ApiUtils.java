package com.nk.service;

import org.apache.http.HttpRequest;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.testng.Assert;

import com.nk.commons.FileUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiUtils {
	
	public static void verifyUsersApi() {

	RestAssured.baseURI = FileUtils.getProperty("base_url");
	RequestSpecification httpRequest = RestAssured.given();
	Response response = httpRequest.request(Method.GET, "/public/v1/users");
	Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode(), "Status code validated");
	System.out.println("Response Body is => " + response.prettyPrint());
	
	JSONObject respObj = new JSONObject(response.asString());
	JSONObject metaObj = (JSONObject)respObj.get("meta");
	JSONObject pagObj = (JSONObject) metaObj.get("pagination");
	Assert.assertNotNull(pagObj.get("total"), "Total value Validation");
	Assert.assertNotNull(pagObj.get("pages"), "Pages value Validation");
	Assert.assertEquals(pagObj.get("page"), 1, "Page value Validation");
	Assert.assertEquals(pagObj.get("limit"), 20,  "Limit value Validation");

 }
	
}
