package Testing;


import io.restassured.response.Response;

import java.util.List;

import static Testing.Specifications.requestSpec;
import static Testing.Specifications.responseSpec;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Auto_Test {
    private final String BASE_URL = "https://petstore.swagger.io/v2";


    public void addPet(String petName, int petId) {
        DataPet.Tag tag = DataPet.Tag.builder()
                .id(1)
                .name("Some tag")
                .build();
        DataPet newPetRequest = DataPet.builder()
                .id(petId)
                .category(DataPet.Category.builder()
                        .id(1)
                        .name("Some category")
                        .build())
                .name(petName)
                .photoUrls(List.of("Some URL"))
                .tags(List.of(tag))
                .status("available")
                .build();
        Specifications.installSpecification(requestSpec(BASE_URL),responseSpec(200));
                given()
                .body(newPetRequest)
                        /*"{\n" +
                        "  \"id\": " + petId + ",\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\":\"" + petName + "\",\n" +
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
                        "}"*/
                .when()
                .post("/pet")
                .then()
                .assertThat().body(matchesJsonSchemaInClasspath("schema/get_post_request_pet_store.json"));

    }


    public void getPet(String petName, int petId){
        Specifications.installSpecification(requestSpec(BASE_URL),responseSpec(200));
        Response resCheckPet =
                given()
                .when()
                .get("/pet/"+petId)
                .then()
                .assertThat().body(matchesJsonSchemaInClasspath("schema/get_post_request_pet_store.json"))
                .statusCode(200)
                .extract().response();

        assertEquals(petName, resCheckPet.jsonPath().getString("name"));
        assertEquals(petId, resCheckPet.jsonPath().getInt("id"));
        }

    public void createUsers(String userName1, String userName2){

        DataUser user1 = DataUser.builder()
                .id(1)
                .username(userName1)
                .firstName("Some Name1")
                .lastName("lastName")
                .email("Example@mail.com")
                .password("1234ABC")
                .phone("123456789")
                .userStatus(1)
                .build();
        DataUser user2 = DataUser.builder()
                .id(2)
                .username(userName2)
                .firstName("Some Name2")
                .lastName("lastName2")
                .email("2Example@mail.com")
                .password("ABC1234")
                .phone("987654321")
                .userStatus(1)
                .build();

        Specifications.installSpecification(requestSpec(BASE_URL),responseSpec(200));
                 given()
                .body(List.of(user1,user2))
                .when()
                .post("/user/createWithList")
                .then();




        }
    public void checkUser(String user){
        Specifications.installSpecification(requestSpec(BASE_URL),responseSpec(200));
        DataUser users =
                given()
                        .when()
                        .get("/user/" + user)
                        .then()
                        .assertThat().body(matchesJsonSchemaInClasspath("schema/get_request_user.json"))
                        .extract().response().as(DataUser.class);

        assertEquals(user, users.getUsername());
        }
}