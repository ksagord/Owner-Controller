import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Step {
	public RequestSpecification request = RestAssured.given();
	public Response response;
	public static  ExtentReports report = new ExtentReports("C:\\Users\\Admin\\Desktop\\OwnerRestController\\FuctionalTest.html", true);
	public ExtentTest test;
	
	

	@Given("^a owner exists in the database$")
	public void a_owner_exists_in_the_database(){
		test = report.startTest("Get all owners");
		test.log(LogStatus.INFO, "request sent for owners");
		response = request.when().get("http://10.0.10.10:9966/petclinic/api/owners");
	}

	@When("^the owner retrieves data on the owners$")
	public void the_owner_retrieves_data_on_the_owners(){
//		response.prettyPrint();
		
	}

	@Then("^check get function$")
	public void check_get_function() {
		response.then().statusCode(200);
		if (response.statusCode() == 200) {
			test.log(LogStatus.PASS, "owners succesfully retrived");
				}
		else {
			test.log(LogStatus.FAIL, "owners not succesfully retrived");
		}
		
		report.endTest(test);
	}

	@Given("^a new Owner is to be added$")
	public void a_new_Owner_is_to_be_added(){
	//	response = request.when().get("http://10.0.10.10:9966/petclinic/api/owners");
		test = report.startTest("Add new owner");
		test.log(LogStatus.INFO, "owner details inserted");
		request.header("Content-Type","application/json");
		
		JSONObject h1 = new JSONObject();
		h1.put("address", "Jimi");
		h1.put("city", "Mode");
		h1.put("firstName", "Street");
		h1.put("id", 6);
		h1.put("lastName", "Bristol");
		h1.put("telephone", "7904279235");
		h1.put("pets", "[]");
		
		request.body(h1);
	}

	@When("^the parametes for the new Owner are added$")
	public void the_parametes_for_the_new_Owner_are_added() {
		response = request.post("http://10.0.10.10:9966/petclinic/api/owners");
	}

	@Then("^check post function$")
	public void check_post_function(){
		System.out.println("hello");
		response.then().statusCode(201);
	//	System.out.println("hello1");
		if (response.statusCode() == 201) {
		//	System.out.println("hello2");
			test.log(LogStatus.PASS, "owner succesfully added");
				}
		else {
		//	System.out.println("hello3");
			test.log(LogStatus.FAIL, "owner not succesfully added");
		}
		
		report.endTest(test);
	}

	@Given("^a owner exists with the last name Coleman$")
	public void a_owner_exists_with_the_last_name_Coleman() {
		test = report.startTest("Search last name");
		test.log(LogStatus.INFO, "Seaching for owner with last name Bond");
		response = request.when().get("http://10.0.10.10:9966/petclinic/api/owners/*/lastname/Bond");
	}

	@When("^the manager retrives the owner with the last name Coleman$")
	public void the_manager_retrives_the_owner_with_the_last_name_Coleman(){
		//response.prettyPrint();
	}

	@Then("^check get paramater function$")
	public void check_get_paramater_function(){
		response.then().statusCode(200);
		if (response.statusCode() == 200) {
			test.log(LogStatus.PASS, "owner found");
				}
		else {
			test.log(LogStatus.FAIL, "owner not found");
		}
		
		report.endTest(test);
	}

	@Given("^a owner exists$")
	public void a_owner_exists(){
		test = report.startTest("delete owner");
		test.log(LogStatus.INFO, "Seaching for owner with specific id");
		response = request.when().get("http://10.0.10.10:9966/petclinic/api/owners/17");
	}

	@When("^the manage deletes a owner with a specific id$")
	public void the_manage_deletes_a_owner_with_a_specific_id(){
		response = request.when().delete("http://10.0.10.10:9966/petclinic/api/owners/17");
	}

	@Then("^check delete function$")
	public void check_delete_function() {
		response.then().statusCode(204);
		if (response.statusCode() == 204) {
			test.log(LogStatus.PASS, "owner deleted");
				}
		else {
			test.log(LogStatus.FAIL, "owner not deleted");
		}
		
		report.endTest(test);
	}

	@Given("^a owner exists with the id$")
	public void a_owner_exists_with_the_id(){
		test = report.startTest("look for owner with id");
		test.log(LogStatus.INFO, "Seaching for owner with specific id");
		response = request.when().get("http://10.0.10.10:9966/petclinic/api/owners/1");
	}

	@When("^the manager retrives the owner with the id$")
	public void the_manager_retrives_the_owner_with_the_id(){
		response.prettyPrint();
	}

	@Then("^check get by id function$")
	public void check_get_by_id_function(){
		response.then().statusCode(200);
		if (response.statusCode() == 200) {
			test.log(LogStatus.PASS, "owner found");
				}
		else {
			test.log(LogStatus.FAIL, "owner not found");
		}
		
		report.endTest(test);
	}
	@Given("^a owner already exists$")
	public void a_owner_already_exists()  {
		test = report.startTest("updating owner");
		test.log(LogStatus.INFO, "add updated details");
	response = request.when().get("http://10.0.10.10:9966/petclinic/api/owners/1");
		
		request.header("Content-Type","application/json");
		JSONObject h2 = new JSONObject();
		h2.put("firstName", "Edna");
		h2.put("lastName", "Mode");
		h2.put("address", "1 anchor");
		h2.put("city", "Manny");
		h2.put("telephone", "12345678901");
		h2.put("pets", "[]");
		
		
		request.body(h2);
		
	}

	@When("^the parametes for the Owner are updated$")
	public void the_parametes_for_the_Owner_are_updated() {
		response = request.put("http://10.0.10.10:9966/petclinic/api/owners/1");
	//	response.then().statusCode(204);
	}
	@Then("^check put function $")
	public void check_put_function() {
		response.then().statusCode(204);
		if (response.statusCode() == 204) {
			test.log(LogStatus.PASS, "owner updated");
				}
		else {
			test.log(LogStatus.FAIL, "owner not updated");
		}
		
		report.endTest(test);
	}
	
	@After
	public static void end() {
		report.flush();
	
	}
}
