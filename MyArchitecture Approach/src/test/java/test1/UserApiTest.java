package test1;

import base.BaseTest;
import utils.LoggerUtil;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserApiTest extends BaseTest {
	   
    @Test
    public void getUsers() {
    	 LoggerUtil.info("Starting test: getUsers");
        given()
        .when()
            .get("/users")  
        .then()
            .statusCode(200) 
            .body("size()", greaterThan(0));
        LoggerUtil.info("Test completed: getUsersTest");
    }
    @Test
    public void getSingleUser() {
        given()
        .when()
            .get("/users/1")  
        .then()
            .statusCode(200)
            .body("size()", greaterThan(0));
    }
}