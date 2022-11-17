package ru.levelp.at.homework6;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

public class PostsAPITests {

    @BeforeEach
    void getToken(){
        RestAssured.baseURI = "https://gorest.co.in/public-api";
        RestAssured
            .given()
            .auth().oauth2("7e0bc0838979483dad3d8aeeee898070e60824998367b509f36451d9cea03941");
    }

    @Test
    void getPosts() {
        RestAssured.given()
                   .log().all()
                   .auth().oauth2("7e0bc0838979483dad3d8aeeee898070e60824998367b509f36451d9cea03941")
                   .when()
                   .get("https://gorest.co.in/public-api/posts")
                   .then()
                   .log().all()
                   .statusCode(200)
                   .body("data.id", Matchers.hasItems(1283,1281,1280,1273,1272,1271,1270,1269,1268,1267))
                   .body("data.user_id", Matchers.hasItems(2536,2534,2534,2526,2525,2523,2521,2520,2519,2516 ))
                   .body("data.title", Matchers.hasItems("Eum adulescens est adultus stultus quas.", "Creator aut thesis conqueror ultio crebro adipiscor aperiam temeritas basium tibi crinis stips quibusdam.", "Tripudio vaco vociferor commodi ascisco clam viduo colo modi laborum alii eum ipsa cupiditate et depromo volaticus alienus.", "Viriliter adhaero spiritus est decens capto denuncio veritas delego cito reprehenderit error summa ago.", "Bos auris turpe celer villa clamo sperno volubilis certus traho aeneus nihil delectus culpo.", "Vesica vere autus voluptas deserunt sperno apto color unde curatio saepe utroque vaco anser trans omnis.", "Amo supra ad adduco placeat denego vester aut.", "Verecundia velociter colo cupressus ademptio cursus absum celo triginta tantum debeo.", "Adficio attero cohaero deorsum omnis et.", "Paens bos vulticulus currus tendo crustulum carcer comptus turbo velut abscido cresco tredecim suadeo."))
                   .body("data.body", Matchers.hasItems("Ultio explicabo timor. Sui succedo adicio. Autem volutabrum cohibeo. Dedecor possimus apud. Adversus traho delectatio. Succurro vinculum qui. Sustineo decerno tabernus. Tametsi decimus crepusculum. Usus complectus error. Id compono adstringo. Amita ipsa theologus. Dolor maxime defaeco. Vae concedo sumo. Benevolentia uter adulescens. Tamisium carmen vel. Qui deporto sum. Adopto tonsor valetudo.", "Dolores et depopulo. Nobis decens vestigium. Quibusdam chirographum delectatio. Calcar delicate absum. Thymbra derideo cetera. Tero cerno advenio. Villa succurro deserunt. Careo quia eos. Cognatus coruscus depopulo. Verecundia quis peior. Confido acies basium. Vulgo sonitus vae. Illum thesaurus omnis. Quis defessus verecundia. Contra damno corroboro.", "Eos theatrum admitto. Cunabula damno tamisium. Sufficio despirmatio demulceo. Theca xiphias delibero. Commodi acerbitas auctus. Enim calco virga. Aetas degero vester. Demum nostrum rerum. Aut convoco nobis. A cumque comis. Fugit temporibus adflicto. Trado convoco socius. Subnecto dedecor delectatio. Unus minus quia. Vulgivagus umerus una. Vicinus aliquid creptio. Atqui adfero creo. Aetas strues solium. Repudiandae patrocinor sit. Vociferor clarus verto. Conicio aut bis. Maiores at taedium.", "Unde correptius cicuta. Fuga currus adsum. Tempore debilito subito. Ad deputo nobis. Curvo minus aut. Somniculosus voluntarius exercitationem. Adopto cinis vehemens. Deorsum fugit tempus. Ut earum ater. Comes adsidue thermae. Ulciscor eveniet unde. Saepe basium defleo. Comes venio quis. Cogito conforto coerceo. Sursum degusto ad. Attonbitus viduo cito. Conculco aestas vulnero. Vivo ubi supellex. Illo decipio vetus. Vir consequatur usitas. Laudantium in repellat. Ante adflicto valens.", "Paulatim odio vulgus. Adimpleo ara eaque. Turbo suscipio tenetur. Demens adhaero curatio. Conservo bestia color. Corrupti ager ipsa. Umerus usque claustrum. Valeo viscus confero. Studio cimentarius defluo. Alii error charisma. Uterque exercitationem arx. Tres bellum et. Caput vehemens velut. Aestus careo testimonium. Certe comparo casso. Vivo sonitus vel.", "Sollicito volva pauci. Auris acquiro deficio. Et non minima. Adamo astrum sto. Derelinquo comes claudeo. Conturbo sortitus argentum. Conqueror dedico trucido. Et pectus valeo. Consuasor atque amaritudo. Alias abduco urbs. Eligendi et amiculum. Alienus dolorem apto. Cohaero cervus suggero. Aliquam aiunt coadunatio. Veritatis aut crustulum. Qui succedo tamquam. Ulterius solutio super. Cura templum anser. Caste tempus venia.", "Cogito pecus aut. Carmen cupiditate vulgaris. Patria quas cura. Patruus labore vester. Absens rerum dolore. Defungo spiritus sollers. Adinventitias deprecator canonicus. Dens acquiro adsuesco. Vespillo solitudo vorax. Dolor ea celo. Textus voluptas caries. Crustulum terebro aranea. Vado sequi textus. Cattus calco verbera. Pecco tristis conqueror. Ubi thema vallum. Saepe quo qui. Crinis pax asperiores. Damnatio degenero molestias. Enim cattus cupiditas. Comedo asperiores desino.", "Conor crux tergo. Autus suggero tui. Adfero consequatur cogo. Tabernus quisquam contra. Compello sint culpa. Quae eum varietas. Spiritus facere ulterius. Arbustum substantia dens. Accusator tactus cavus. Aegre testimonium et. Cerno minus caelestis. Depraedor complectus inventore. Demens suggero modi. Adsidue decerno valetudo. Amor theca vacuus. Antea quo voluptatem. Audio tumultus vilitas. Cena delectus vulticulus. Voco quia eveniet.", "Ut consequatur verto. Sordeo autem alioqui. Titulus repellendus benigne. Acies undique acerbitas. Molestiae deleniti tametsi. Aequitas aestivus stella. Sortitus bestia bene. Admitto sunt conitor. Toties saepe triumphus. Considero abstergo spiritus. Calculus venio adsuesco. Animus terreo ut. Aer volutabrum trepide. Avoco quisquam custodia. Aro cribro adficio. Tot explicabo candidus. Quo repellat carpo. Itaque thymum arca.", "Vulgivagus pel asporto. Decimus virtus tricesimus. Caveo quod decor. Stipes capio cognatus. Nobis decretum cauda. Quidem acsi a. Abduco cupio adsum. Tempora tres virga. Velit vilicus laudantium. Iure callide calcar. Ea conservo consequatur. Ventosus suscipio textus. Super contego velit. Speciosus victus benevolentia. Attero adeptio avoco. Placeat trepide possimus. Creber supplanto decor. Auxilium maxime arbor. Bellum cultura supra. Desolo thorax utrum."));
    }

    @Test
    void postPosts() {
        RestAssured.baseURI = "https://gorest.co.in/public-api";

        RestAssured.given()
                   .auth().oauth2("7e0bc0838979483dad3d8aeeee898070e60824998367b509f36451d9cea03941")
                   .param("user_id","1111")
                   .param("title","TestTestTest")
                   .param("body","TestTestTest")
                   .param("message","trollolo")
                   .log().all()
                   .when()
                   .post("/posts")
                   .then()
                   .log().all()
                   .statusCode(200)
                   .body("code",Matchers.equalTo(201))
                   .body("data.user_id",Matchers.equalTo(1111))
                   .body("data.title", Matchers.equalTo("TestTestTest"))
                   .body("data.body", Matchers.equalTo("TestTestTest"));
    }

    @Test
    void getPostsPostId() {
        RestAssured
            .given()
            .log().all()
            .auth().oauth2("7e0bc0838979483dad3d8aeeee898070e60824998367b509f36451d9cea03941")
            .when()
                   .get("https://gorest.co.in/public-api/posts/1318")
                   .then()
                   .log().all()
                   .statusCode(200)
                   .body("data.id", Matchers.equalTo(1318))
                   .body("data.user_id", Matchers.equalTo(2793))
                   .body("data.title", Matchers.equalTo("Absconditus adsidue angulus tui vigilo versus usus."))
                   .body("data.body", Matchers.equalTo("Sit sit voluptate. Deputo terreo clamo. Iure tamquam voluptas. Victus spiculum surculus. Acies coaegresco architecto. Voluptatem eum synagoga. Corroboro textor desparatus. Varietas conitor non. Benevolentia aut calculus. Derelinquo aetas corrigo. Voluptatem voluptates arguo. Ademptio volaticus basium. Sulum cotidie aranea. Tergo suscipit denuncio. Demens texo speculum. Debitis arca accipio. Veritas defigo porro."));
    }

    @Test
    void putPostsPostId() {
        RestAssured.given()
                   .log().all()
                   .auth().oauth2("7e0bc0838979483dad3d8aeeee898070e60824998367b509f36451d9cea03941")
                   .param("user_id", "1111")
                   .param("title", "TestTestTest")
                   .param("body", "TestTestTestTestTestTestTestTestTest")
                   .when()
                   .put("https://gorest.co.in/public-api/posts/1319")
                   .then()
                   .statusCode(200)
                   .body("data.body", Matchers.equalTo("TestTestTestTestTestTestTestTestTest"))
                   .body("data.title", Matchers.equalTo("TestTestTest"))
                   .body("data.user_id", Matchers.equalTo(1111));
    }

    @Test
    void patchPostsPostId() {
        RestAssured.given()
                   .log().all()
                   .auth().oauth2("7e0bc0838979483dad3d8aeeee898070e60824998367b509f36451d9cea03941")
                   .param("user_id", "2222")
                   .param("title", "dsfkjkk")
                   .param("body", "ghjgjgdsfksjfdkhskh jdshfdskfjhkj")
                   .when()
                   .patch("https://gorest.co.in/public-api/posts/1320")
                   .then()
                   .statusCode(200)
                   .body("data.body", Matchers.equalTo("ghjgjgdsfksjfdkhskh jdshfdskfjhkj"))
                   .body("data.title", Matchers.equalTo("dsfkjkk"))
                   .body("data.user_id", Matchers.equalTo(2222));
    }

    @Test
    void deletePostsPostId() {
        RestAssured.given()
                   .log().all()
                   .auth().oauth2("7e0bc0838979483dad3d8aeeee898070e60824998367b509f36451d9cea03941")
                   .when()
                   .delete("https://gorest.co.in/public-api/posts/1323")
                   .then()
                   .log().all()
                   .statusCode(200)
                   .body("code", Matchers.equalTo(204))
                   .body("data", Matchers.equalTo(null))
                   .body("meta", Matchers.equalTo(null));
    }

}


