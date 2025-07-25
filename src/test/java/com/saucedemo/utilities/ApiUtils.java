package com.saucedemo.utilities;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.*;

public class ApiUtils {

    static String finalToken = "";

    public static Object generateToken(String partner) {
        RestAssured.useRelaxedHTTPSValidation();
        Map<String, Object> postBody = new HashMap<>();
        postBody.put("username", "test");
        postBody.put("password", "abc123");
//        System.out.println("postBody generatetoken = " + postBody);

        Response response = RestAssured.given()
                .header("User-Agent", "test")
                .contentType("application/json")
                .body(postBody)
                .when().post("https://petstore.swagger.io/oauth/authorize");

//       response.prettyPrint();
//       System.out.println("response.statusCode() = " + response.statusCode());
        Map<String, Object> jsonDataMap = response.body().as(Map.class);
//       System.out.println("jsonDataMap = " + jsonDataMap);

        finalToken = "Bearer " + jsonDataMap.get("token");
        System.out.println("finalToken = " + finalToken);
        return finalToken;
    }


    public static JsonPath postPetWithPetid(int petId) {
        RestAssured.baseURI = "https://petstore.swagger.io";

        Map<String, Object> payload = new HashMap<>();
        payload.put("id", petId);
        payload.put("name", "CuteFluffy");
        payload.put("status", "available");

        System.out.println("payload = " + payload);

        Response response = RestAssured.given()
                .relaxedHTTPSValidation()
//                .header("Authorization",token)
                .header("User-Agent", "test")
                .contentType("application/json")
                .body(payload)
                .when().post("/v2/pet/")
                .then()
                .assertThat().statusCode(200)
                .extract().response();

        JsonPath jsonPath = response.jsonPath();
        response.prettyPrint();

        return jsonPath;
    }


    public static JsonPath getPetWithPetid(int petId) {
        RestAssured.baseURI = "https://petstore.swagger.io";

        Response response = RestAssured.given()
                .relaxedHTTPSValidation()
                .header("User-Agent", "test")
                .accept("application/json")
                .when()
                .get("/v2/pet/" + petId);

        System.out.println("Status code: " + response.getStatusCode());
        response.prettyPrint();

        if (response.getStatusCode() != 200) {
            throw new RuntimeException("GET request failed for pet ID: " + petId);
        }

        return response.jsonPath();

    }


    public static JsonPath putPetWithPetid(int petId) {
        RestAssured.baseURI = "https://petstore.swagger.io";

        Map<String, Object> payload = new HashMap<>();
        payload.put("id", petId);
        payload.put("name", "FluffyCute");
        payload.put("status", "sold");

        System.out.println("Payload (PUT) = " + payload);

        Response response = RestAssured.given()
                .relaxedHTTPSValidation()
                .header("User-Agent", "test")
                .contentType("application/json")
                .body(payload)
                .when()
                .put("/v2/pet");

        System.out.println("Status code: " + response.getStatusCode());
        response.prettyPrint();

        if (response.getStatusCode() != 200) {
            throw new RuntimeException("PUT request failed!");
        }

        return response.jsonPath();

    }


    public static JsonPath delPetWithPetid(int petId) {
        RestAssured.baseURI = "https://petstore.swagger.io";

        Response response = RestAssured.given()
                .relaxedHTTPSValidation()
                .when()
                .delete("/v2/pet/" + petId);

        response.prettyPrint();

        if (response.getStatusCode() != 200) {
            throw new RuntimeException("DELETE request failed!");
        }

        return response.jsonPath();
    }


    public static JsonPath verifyDeletedDataWithPetid(int petId) {
        RestAssured.baseURI = "https://petstore.swagger.io";

        Response response = RestAssured.given()
                .relaxedHTTPSValidation()
                .accept("application/json")
                .when()
                .get("/v2/pet/" + petId);

        System.out.println("GET deleted pet status: " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 404);

        return response.jsonPath();

    }



}
