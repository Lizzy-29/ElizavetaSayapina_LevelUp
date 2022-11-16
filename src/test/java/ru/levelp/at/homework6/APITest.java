package ru.levelp.at.homework6;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

public class APITest {

    @BeforeEach
    void getToken(){
        RestAssured.baseURI = "https://gorest.co.in/public-api";
        RestAssured
            .given()
            .auth().oauth2("7e0bc0838979483dad3d8aeeee898070e60824998367b509f36451d9cea03941");
    }

    @Test
    void getUsers() {
        RestAssured.when()
            .get("/users")
            .then()
            .log().all()
            .statusCode(200)
            .body("data.id", Matchers.hasItems(2562, 2557, 2556, 2555, 2554, 2553, 2552, 2551, 2550, 2549))
            .body("data.name", Matchers.hasItems("Achintya Tagore", "Draupadi Patil", "Chandrakala Prajapat", "Aishani Ahuja CPA", "Bhilangana Varman", "Govinda Kapoor", "Lai Trivedi LLD", "Triloki Devar", "Vedang Mukhopadhyay Esq.", "Rohana Tandon" ))
            .body("data.email", Matchers.hasItems("tagore_achintya@hamill.name", "patil_draupadi@schinner-heaney.name", "chandrakala_prajapat@bradtke.biz", "aishani_cpa_ahuja@batz-ferry.biz", "bhilangana_varman@beer-heidenreich.com", "kapoor_govinda@kshlerin.co", "trivedi_lai_lld@kuphal-bartell.name", "triloki_devar@cole.name", "vedang_esq_mukhopadhyay@von.io", "tandon_rohana@simonis-powlowski.org"))
            .body("data.gender",Matchers.hasItems("female", "male"))
            .body("data.status", Matchers.hasItems("inactive", "active"));
    }

    @Test
    void postUsers() {
        RestAssured.baseURI = "https://gorest.co.in/public-api";

        RestAssured.given()
            .auth().oauth2("7e0bc0838979483dad3d8aeeee898070e60824998367b509f36451d9cea03941")
            .param("name","Klara Tsetkin")
            .param("email","lol3@mail.ru")
            .param("gender","female")
            .param("status","active")
                   .log().all()
            .when()
                   .post("/users")
                   .then()
                   .log().all()
                   .statusCode(200)
            .body("data.name",Matchers.equalTo("Klara Tsetkin"))
            .body("data.email",Matchers.equalTo("lol3@mail.ru"))
            .body("data.gender", Matchers.equalTo("female"))
            .body("data.status", Matchers.equalTo("active"));
    }


    @Test
    void getUsersUserId() {
        RestAssured.when()
                   .get("https://gorest.co.in/public-api/users/2462")
                   .then()
            .log().all()
                   .statusCode(200)
                   .body("data.id", Matchers.equalTo(2462))
                   .body("data.name", Matchers.equalTo("Ojaswini Khanna Jr."))
                   .body("data.email", Matchers.equalTo("jr_ojaswini_khanna@gusikowski.org"))
                   .body("data.gender", Matchers.equalTo("male"))
                   .body("data.status", Matchers.equalTo("active"));
    }

    @Test
    void putUsersUserId() {
        RestAssured.given()
            .param("email","loilsfsfddsff@mail.ru")
            .param("name","Testing Test")
            .param("gender","male")
            .param("status","active")
            .when()
                   .put("https://gorest.co.in/public-api/users/2458")
                   .then()
                   .statusCode(200);
    }

    @Test
    void patchUsersUserId() {
        RestAssured.when()
                   .patch("/users/2454")
                   .then()
                   .statusCode(200);
    }

    @Test
    void deleteUsersUserId() {
        RestAssured.when()
                   .delete("/users/2458")
                   .then()
                   .statusCode(200);
    }

}


