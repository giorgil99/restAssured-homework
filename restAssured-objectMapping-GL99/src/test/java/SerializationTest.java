import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.basic;
import static io.restassured.RestAssured.given;

public class SerializationTest {



@Test
    public void SuccessCall() {
    Implementation impSuccess = new Implementation();
//    RestAssured.authentication = basic("eve.holt@reqres.in", "pistol");
    RestAssured.baseURI = "https://reqres.in/api/register";

//    String id = given().contentType("application/json").body(impSuccess.RegisterUser("10","James"))
//            .put("/update/data").then().statusCode(200).log().body()
//            .and().extract().response().getBody().jsonPath().get("token");
//        System.out.println(id);

    int id = given().contentType("application/json").body(impSuccess.RegisterUser("eve.holt@reqres.in","pistol"))
            .post("/api/register").then().extract().response().getStatusCode();
    System.out.println(id);

    }


}
