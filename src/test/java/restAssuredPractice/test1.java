package restAssuredPractice;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class test1 {
	
	public void openUrl() {
		
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		
	}
	@Test
	public void test2() {
		baseURI = "https://reqres.in/api";
		String res = given().
			queryParam("page", "2"). 
		when().get("/users").
		then().
			statusCode(200).extract().response().asString();
		JsonPath js = new JsonPath(res);
		int length = js.getInt("data.size()");
		System.out.print(length);
		for(int i = 0; i<= length; i++) {
			System.out.println(js.getString("data["+i+"].id"));
//			if (js.get("data["+i+"].id").equals(11)) {
//				System.out.print(js.getString("data["+i+"].email"));
//			}
		}
			
	}
	
//	@Test 
	public void makePost() {
		
		JSONObject reqBody = new JSONObject();
		reqBody.put("name", "morpheus");
		reqBody.put( "job", "leader");
		baseURI = "https://reqres.in/api";
		
		
		String response = given().
			body(reqBody.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
		extract().response().asString();
			
		System.out.println("response:"+response);
		JsonPath js = new JsonPath(response);
		String id = js.getJsonObject("id");
		System.out.println(id);
	}

}
