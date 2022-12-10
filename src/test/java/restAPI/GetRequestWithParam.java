package restAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestWithParam {
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:3000";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.param("id", "3").get("employees");
		System.out.println(response.getBody().asString());
		
		int responseCode = response.getStatusCode();
		Assert.assertEquals(200, responseCode);
		System.out.println("Printing headers");

		System.out.println(response.headers().toString());
		
		String ResponseBody = response.getBody().asString();
		Assert.assertTrue(ResponseBody.contains("Rohan"));
		
		JsonPath jpath = response.jsonPath();
		List<String> names = jpath.get("name");
		System.out.println("The name is :" + names.get(1));
		
		Assert.assertEquals(names.get(0), "Rohan");
		
		
		
		


}
}