package restAssuredPractice.courses;



import java.util.List;

import io.restassured.path.json.JsonPath;

public class JsonParse {
	public static void main(String arg[]) {
		JsonPath response = new JsonPath(JSONfile.getJson());
		System.out.println(response.toString());
		List<String> courses =  response.getJsonObject("courses");
		int noOfCourses = response.getInt("courses.size()");
		System.out.println(noOfCourses);
		String purchaseAmount = response.getString("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);
		String title = response.getString("courses[0].title");
		System.out.println(title);
//		for(course: courses) {
//			
//		}
	}

}
