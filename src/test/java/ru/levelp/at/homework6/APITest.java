package ru.levelp.at.homework6;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class APITest {

    @Test
    void getUsers() {
        RestAssured.when()
            .get("https://gorest.co.in/public-api/users")
            .then()
            .statusCode(200)
            //.body("data.id", Matchers.hasItems(2462, 2458, 2454, 2453, 2452, 2451, 2449, 2447, 2446, 2445))
            .body("data.name", Matchers.arrayContainingInAnyOrder("Dwaipayana Banerjee",
                "Devdan Kaul",
                "Adityanandan Shukla",
                "Ganaka Mukhopadhyay",
                "Deeptimoyee Mishra JD",
                "Deevakar Varman",
                "Dhara Desai DVM",
                "Msgr. Brahmaanand Saini",
                "Acaryatanaya Agarwal",
                "Rep. Anjali Pilla"));
    }

    @Test
    void postUsers() {
        RestAssured.when()
                   .post("https://gorest.co.in/public-api/users")
                   .then()
                   .statusCode(200);
    }

    @Test
    void getUsersUserId() {
        RestAssured.when()
                   .get("https://gorest.co.in/public-api/users/2462")
                   .then()
                   .statusCode(200);
    }

    @Test
    void putUsersUserId() {
        RestAssured.when()
                   .put("https://gorest.co.in/public-api/users/2458")
                   .then()
                   .statusCode(200);
    }

    @Test
    void patchUsersUserId() {
        RestAssured.when()
                   .patch("https://gorest.co.in/public-api/users/2454")
                   .then()
                   .statusCode(200);
    }

    @Test
    void deleteUsersUserId() {
        RestAssured.when()
                   .delete("https://gorest.co.in/public-api/users/2458")
                   .then()
                   .statusCode(200);
    }

}


