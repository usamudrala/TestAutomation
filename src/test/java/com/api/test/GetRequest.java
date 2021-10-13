package com.api.test;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequest {



	@Test(priority=1)
	public void test_getDetails(){
		
	//Response response = RestAssured.get("https://reqres.in/api/users?page=2");
	Response response = RestAssured.get("https://reqres.in/api/users");
	
	 
	 System.out.println("Response body is:"+response.getBody().asString());	 
	 System.out.println("Statuscode is:"+response.getStatusCode());
	 System.out.println("Content type is:"+response.contentType());
	 System.out.println("StatusLine is:"+response.getStatusLine());
	
	 
	 Assert.assertEquals(response.getStatusCode(), 200);
     Assert.assertEquals(response.getStatusLine(),"HTTP/1.1 200 OK");
	 
	 
	
	}
	

		@Test(priority=2)
		public void test_post() {
			

			JSONObject requestparams = new JSONObject();
			requestparams.put("name", "chaya");
			requestparams.put("job", "BA");
			Response response = RestAssured.get("https://reqres.in/api/users");

			System.out.println(requestparams);
			System.out.println(requestparams.toString());
			
        		
			given()
			    .body(requestparams.toJSONString())
			    .header("content-tpre","application/json")
			.when()
			    .post("https://reqres.in/api/users");    
		
			
			  int statuscode=response.getStatusCode(); 
			  Assert.assertEquals(statuscode, 201);
			
			
		}

       @Test (priority=3)
	  public void test_put() {

   		JSONObject requestparams = new JSONObject();
   		requestparams.put("name", "chaya");
   		requestparams.put("job", "BAA");

   		System.out.println(requestparams);
   		System.out.println(requestparams.toString());

   		given().
     		body(requestparams.toJSONString()).
   		when().
    		put("https://reqres.in/api/users/2").
   		then().statusCode(200);
   		
       }
       
       @Test(priority=4)
       public void test_patch() {
    	   JSONObject requestparams = new JSONObject();
   		requestparams.put("name", "chaya");
   		requestparams.put("job", "BAA");

   		System.out.println(requestparams);
   		System.out.println(requestparams.toString());

   		given().
   		   body(requestparams.toJSONString()).
   		when().
   		   patch("https://reqres.in/api/users").
   		then().statusCode(200);

       }

       @Test (priority=5)
       public void test_delete() {

   		JSONObject requestparams = new JSONObject();
   		given().
    		body(requestparams.toJSONString()).
   		when().
    		delete("https://reqres.in/api/users/2").
   		then().statusCode(204).
   		log().all();

       }

}
