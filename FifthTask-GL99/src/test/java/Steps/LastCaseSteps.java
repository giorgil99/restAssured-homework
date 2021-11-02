package Steps;

import Models.JsonMapper;
import Models.LastCase;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

import static io.restassured.RestAssured.given;

public class LastCaseSteps {

    public static Response response;

    @Step("Make last call ")
    public LastCaseSteps lastCall() {
        JsonMapper impLast = new JsonMapper();
        RestAssured.baseURI = "https://reqres.in/api/users";
        this.response = given().contentType("application/json")
                .body(impLast.registerUserWith2Keys("name", "morpheus", "job", "leader"))
                .post().then().extract().response();
        return this;
    }

    @Step("Assert last call response name ")
    public LastCaseSteps assertName(String name) {
        if (response.getStatusCode() == 201) {
            LastCase lCase = response.getBody().as(LastCase.class);
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(lCase.getName(), name);
            softAssert.assertAll();
        }
        return this;
    }

    @Step("Assert last call response job ")
    public LastCaseSteps assertJob(String job) {
        if (response.getStatusCode() == 201) {
            LastCase lCase = response.getBody().as(LastCase.class);
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(lCase.getJob(), job);
            softAssert.assertAll();
        }
        return this;
    }

    @Step("Assert last call response id ")
    public LastCaseSteps assertId() {
        if (response.getStatusCode() == 201) {
            LastCase lCase = response.getBody().as(LastCase.class);
            SoftAssert softAssert = new SoftAssert();
//            softAssert.assertEquals(lCase.getId(), "448");
            System.out.println("user id now is: " + lCase.getId());
            softAssert.assertAll();
        }
        return this;
    }

    @Step("Assert last call response createdAt ")
    public LastCaseSteps assertDate(ZonedDateTime date) {
        if (response.getStatusCode() == 201) {
            LastCase lCase = response.getBody().as(LastCase.class);
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(lCase.getCreatedAt().toLocalDateTime()
                    .atZone(ZoneId.systemDefault()).truncatedTo(ChronoUnit.MINUTES), date);
            softAssert.assertAll();
        }
        return this;
    }


}
