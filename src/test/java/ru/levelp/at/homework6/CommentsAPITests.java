package ru.levelp.at.homework6;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

public class CommentsAPITests {

    @BeforeEach
    void getToken(){
        RestAssured.baseURI = "https://gorest.co.in/public-api";
        RestAssured
            .given()
            .auth().oauth2("7e0bc0838979483dad3d8aeeee898070e60824998367b509f36451d9cea03941");
    }

    @Test
    void getComments() {
        RestAssured.given()
                   .log().all()
                   .auth().oauth2("7e0bc0838979483dad3d8aeeee898070e60824998367b509f36451d9cea03941")
                   .when()
                   .get("https://gorest.co.in/public-api/comments")
                   .then()
                   .log().all()
                   .statusCode(200)
                   .body("data.id", Matchers.hasItems(1340,1339,1338,1337,1336,1335,1334,1333,1332,1331))
                   .body("data.post_id", Matchers.hasItems(1318,1318,1317,1317,1315,1312,1312,1311,1311,1309 ))
                   .body("data.email", Matchers.hasItems("mangalya_gandhi@bahringer-will.name","md_lakshminath_panicker@trantow.io","jagdish_kaniyar@hackett.com","nayar_chandrabhan@botsford-hagenes.info","chitrali_vm_mehrotra@glover.name","bhupati_amb_chaturvedi@schumm-abbott.io","vedanshi_asan@rutherford-stehr.org","gowda_i_girik@streich.net","shukla_bankim@johnson.net","keerti_trivedi@kilback.io" ))
                   .body("data.name", Matchers.hasItems("Mangalya Gandhi", "Lakshminath Panicker MD", "Jagdish Kaniyar", "Chandrabhan Nayar", "Chitrali Mehrotra VM", "Amb. Bhupati Chaturvedi", "Vedanshi Asan", "Girik Gowda I", "Bankim Shukla", "Keerti Trivedi"))
                   .body("data.body", Matchers.hasItems("Qui aliquam repellendus.", "Debitis labore dolor. Dolores et velit. Quo vitae reiciendis. Esse id sed.", "Id vero sit. Qui cupiditate cumque. Non fugiat dicta. Quidem quas nesciunt.", "Assumenda accusamus est. Neque et iste.", "Aut mollitia corporis. Qui quae et.", "Molestias et a.", "Repudiandae vel vel.", "Tempora est est.", "Sit fuga eum. Itaque hic quos.", "Dolores consequuntur minima. Dolorem error cumque."));
    }

    @Test
    void postComments() {

        RestAssured.given()
                   .auth().oauth2("7e0bc0838979483dad3d8aeeee898070e60824998367b509f36451d9cea03941")
                   .param("post_id",1318)
                   .param("name","Magnolia Milosskaya")
                   .param("email","mangalya_gandhi@bahringer-will.name")
                   .param("body","Ecce gratum et optatum la reducit gaudia")
                   .log().all()
                   .when()
                   .post("https://gorest.co.in/public-api/comments")
                   .then()
                   .log().all()
                   .statusCode(200)
                   .body("code",Matchers.equalTo(201))
                   .body("data.post_id",Matchers.equalTo(1318))
                   .body("data.name", Matchers.equalTo("Magnolia Milosskaya"))
                   .body("data.body", Matchers.equalTo("Ecce gratum et optatum la reducit gaudia"))
                   .body("data.email", Matchers.equalTo("mangalya_gandhi@bahringer-will.name"));
    }

    @Test
    void getCommentsCommentId() {
        RestAssured
            .given()
            .auth().oauth2("7e0bc0838979483dad3d8aeeee898070e60824998367b509f36451d9cea03941")
            .when()
                   .get("https://gorest.co.in/public-api/comments/1318")
                   .then()
                   .log().all()
                   .statusCode(200)
                   .body("data.id", Matchers.equalTo(1318))
                   .body("data.post_id", Matchers.equalTo(1294))
                   .body("data.name", Matchers.equalTo("Govinda Guneta"))
                   .body("data.email", Matchers.equalTo("govinda_guneta@erdman-auer.org"))
                   .body("data.body", Matchers.equalTo("Unde libero iure."));
    }
    @Test
    void putCommentsCommentId() {
        RestAssured.given()
                   .log().all()
                   .auth().oauth2("7e0bc0838979483dad3d8aeeee898070e60824998367b509f36451d9cea03941")
                   .param("post_id", "1318")
                   .param("name", "Ralke Toppinen")
                   .param("email", "mangalya_gandhi@bahringer-will.name")
                   .param("body", "Qui aliquam repellendus. Esse Gratum")
                   .when()
                   .put("https://gorest.co.in/public-api/comments/1329")
                   .then()
                   .statusCode(200)
                   .body("data.post_id", Matchers.equalTo(1318))
                   .body("data.name", Matchers.equalTo("Ralke Toppinen"))
                   .body("data.email", Matchers.equalTo("mangalya_gandhi@bahringer-will.name"))
                   .body("data.body", Matchers.equalTo("Qui aliquam repellendus. Esse Gratum"));
    }

    @Test
    void patchCommentsCommentId() {
        RestAssured.given()
                   .log().all()
                   .auth().oauth2("7e0bc0838979483dad3d8aeeee898070e60824998367b509f36451d9cea03941")
                   .param("name", "Santa Lucia")
                   .param("email", "mangalya_gandhi@bahringer-will.name")
                   .param("body", "Люблю грозу в начале мая")
                   .when()
                   .patch("https://gorest.co.in/public-api/comments/1330")
                   .then()
                   .statusCode(200)
                   .body("data.name", Matchers.equalTo("Santa Lucia"))
                   .body("data.email", Matchers.equalTo("mangalya_gandhi@bahringer-will.name"))
                   .body("data.body", Matchers.equalTo("Люблю грозу в начале мая"));
    }

    @Test
    void deleteCommentsCommentId() {
        RestAssured.given()
                   .log().all()
                   .auth().oauth2("7e0bc0838979483dad3d8aeeee898070e60824998367b509f36451d9cea03941")
                   .when()
                   .delete("https://gorest.co.in/public-api/comments/1332")
                   .then()
                   .log().all()
                   .statusCode(200)
                   .body("code", Matchers.equalTo(204))
                   .body("data", Matchers.equalTo(null))
                   .body("meta", Matchers.equalTo(null));
    }
}


