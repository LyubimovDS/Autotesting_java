package Testing;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Auto_Test {

    private final int petID = 123456;
    private final String baseUri = "https://petstore.swagger.io/v2";

    public void addPet(String petName) {
                given()
                .baseUri(baseUri)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": " + petID + ",\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\":" + petName + ",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 1,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .post("/pet")
                .then()
                .statusCode(200);
    }


    public void checkPet(String petName){
        Response resCheckPet =
                given()
                .baseUri(baseUri)
                .when()
                .get("/pet/"+petID)
                .then()
                .statusCode(200)
                .extract().response();

        assertEquals(petName, resCheckPet.jsonPath().getString("name"));
        System.out.println(resCheckPet.jsonPath().getString("name"));
        }
}