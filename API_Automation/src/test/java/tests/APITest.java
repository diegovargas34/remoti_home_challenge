package tests;

import io.restassured.response.Response;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


import java.io.File;

public class APITest {

    @Test
    public void testSuccessfulCreationOfPet() {

        File body = new File(System.getProperty("user.dir") + "/src/test/resources/add_pet.json");

        Response response = given().baseUri("https://petstore3.swagger.io/api/v3").header("Content-Type", "application/json").body(body)
                            .when().post("/pet")
                            .then().assertThat().statusCode(200).extract().response();

        response.andReturn();
    }

    @Test
    public void testUnsuccessfulCreationOfPet() {

        File body = new File(System.getProperty("user.dir") + "/src/test/resources/add_pet.json");

        Response response = given().baseUri("https://petstore3.swagger.io/api/v3").body(body)
                            .when().post("/pet")
                            .then().assertThat().statusCode(415).extract().response();

        response.andReturn();

    }

    @Test
    public void testSuccessfulGetPetByID() {

        Response response = given().baseUri("https://petstore3.swagger.io/api/v3").header("Content-Type", "application/json")
                            .when().get("/pet/2003")
                            .then().assertThat().statusCode(200).extract().response();

        response.andReturn();
    }

    @Test
    public void testUnsuccessfulGetPetByID() {

        Response response = given().baseUri("https://petstore3.swagger.io/api/v3").header("Content-Type", "application/json")
                            .when().get("/pet/4000")
                            .then().assertThat().statusCode(404).extract().response();

        response.andReturn();
    }

    @Test
    public void testSuccessfulDeletePetByID() {

        Response response = given().baseUri("https://petstore3.swagger.io/api/v3").header("Content-Type", "application/json")
                            .when().delete("/pet/2001")
                            .then().assertThat().statusCode(200).extract().response();

        response.andReturn();
    }

}