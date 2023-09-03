package com.restassured;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class OMDB {
    
    @BeforeClass
    void setUp(){
        System.out.println("SetUp");
    }
    

    @Test
    void getOMDB(){
        
        RestAssured.baseURI= "http://www.omdbapi.com";

        Response response = given().queryParam("i", "tt3896198")
                .queryParam("apikey", "357d6210")
                .get();

        // Validating the response
        // int statusCode = response.getStatusCode();
        // System.out.println("Status code: " + statusCode);
       
        // String responseBody = response.getBody().asString();
        // System.out.println("Response body: " + responseBody);

        // Add more assertions or validations
        response.then()
                .assertThat()
                .statusCode(200)
                // .body("Title", "Guardians of the Galaxy Vol. 2");
                // .body("data", Matchers.notNullValue())
                // .body("data.size()", Matchers.greaterThan(0))
                .body("Title", Matchers.equalTo("Guardians of the Galaxy Vol. 2"))
                .body("Year", Matchers.equalToCompressingWhiteSpace("2017"));
    }


    @AfterClass
    void tearDown(){
        System.out.println("Tear Down");
    }
    
}
