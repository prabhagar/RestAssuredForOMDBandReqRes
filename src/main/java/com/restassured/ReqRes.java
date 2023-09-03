package com.restassured;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

public class ReqRes {

    @BeforeClass

    public void setUp() throws Exception {
        System.out.println("Setting up");
    }

    @Test
    public void getReqRes() {
        RestAssured.baseURI="https://reqres.in";

        Response response = given()
            .queryParam("page", 2)
            .get("/api/users");

        response.then()
        .statusCode(200)
        .assertThat()
        .body("total", Matchers.equalTo(12))
        .body("total_pages", Matchers.equalTo(2));
    }

    @Test
    public void postReqRes() {
        RestAssured.baseURI="https://reqres.in";

        String request = "{\"name\":\"<praba>\", \"email\":\"<job>\", \"Test Lead}";

        Response response = given()
           .body(request)
           .post("/api/users");

        response.then()
       .statusCode(201);
    }

    @Test
    public void patchReqRes() {
        RestAssured.baseURI="https://reqres.in";

        String request = "{\"name\":\"<prabhagar T>\", \"email\":\"<job>\", \"Test Manager}";

        Response response = given()
         .body(request)
         .patch("/api/users/114");

        response.then()
        .statusCode(200);
    }


    @Test
    public void putReqRes() {
        RestAssured.baseURI="https://reqres.in";

        String request = "{\"name\":\"<praba>\", \"email\":\"<job>\", \"Test Architect}";

        Response response = given()
          .body(request)
          .put("/api/users/114");

        response.then()
      .statusCode(200);
    }


    @AfterClass
    public void tearDown() throws Exception {
        System.out.println("Tearing down");
    }
    
}
