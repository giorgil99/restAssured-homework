import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class RestAssuredBasicsSecond {


    @Test
    public void Call1() {

//Validate last record's name value
        SoftAssert softAssert = new SoftAssert();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh-mm-ss");

        Response response = given().when().get("https://chercher.tech/sample/api/product/read")
                .then().contentType(ContentType.JSON)
                .assertThat().body("records[-1].name", equalTo("CreateRecord")) //asserting last obj
                .and().extract().response();                                              // extracting response
        System.out.println(response.getBody().jsonPath().get("records[-1].name").toString());

        // Validate that all records 'created' time is less than current time
        List<String> list = response.jsonPath().getList("records.created");
        for (String string : list) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dateTime = LocalDateTime.parse(string, formatter);
            LocalDateTime currentTime = LocalDateTime.now();

            softAssert.assertTrue(dateTime.isBefore(currentTime));
        }
        softAssert.assertAll();
    }

    @Test
    public void Call2() {
// Post new user with any 2 parameters

        String requestBody = "{\r\n" +
                " \"id\":\"8\",\r\n" +
                " \"first_name\":\"Newname\",\r\n" +
                " \"last_name\":\"Newlastname\"\r\n" +
                "}";

        RestAssured.baseURI = "https://reqres.in/api/users";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody).post("/update/data").then().statusCode(201).log().body();
    }
}



