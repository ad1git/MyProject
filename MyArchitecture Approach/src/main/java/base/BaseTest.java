package base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    protected Properties prop;

    @BeforeClass
    public void setup() {
        
    	String path = System.getProperty("user.dir") + File.separator + "src" + File.separator +
                "test" + File.separator + "resources" + File.separator + "config.properties";

  
    	
        prop = new Properties();
        try (FileInputStream fis = new FileInputStream(path)) {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot load config.properties file");
        }

       
        String baseURI = prop.getProperty("baseURI");
        if (baseURI == null || baseURI.isEmpty()) {
            throw new RuntimeException("Base URI is not set in config.properties!");
        }

        
        RestAssured.baseURI = baseURI;
        RestAssured.port = prop.getProperty("port") != null ?
                Integer.parseInt(prop.getProperty("port")) : 443;
      
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.requestSpecification = RestAssured.given().contentType(ContentType.JSON);

        System.out.println("✅ RestAssured setup complete. Base URI: " + RestAssured.baseURI);
    }
}