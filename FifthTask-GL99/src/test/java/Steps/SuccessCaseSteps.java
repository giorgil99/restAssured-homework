package Steps;

import Models.JsonMapper;
import Models.SuccessCase;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class SuccessCaseSteps {
    public static Response response;


    @Step("Make successful call ")
    public SuccessCaseSteps successCall() {
        //        Implement SUCCESSFUL scenario with the following parameters
        JsonMapper impSuccess = new JsonMapper();
        RestAssured.baseURI = "https://reqres.in/api/register";

        this.response = given().contentType("application/json").body(impSuccess.
                        registerUserWith2Keys("email", "eve.holt@reqres.in", "password", "pistol"))
                .post().then().extract().response();
        return this;
    }


    @Step("Assert successful id response ")
    public SuccessCaseSteps successAssertId(String id) {
        successCall();
        if (response.statusCode() == 200) {
            Models.SuccessCase sCase = response.getBody().as(SuccessCase.class);
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(sCase.getId(), id);
            softAssert.assertAll();
        }
        return this;
    }

    @Step("Assert successful token response ")
    public SuccessCaseSteps successAssertToken(String token) {
        if (response.statusCode() == 200) {
            Models.SuccessCase sCase = response.getBody().as(SuccessCase.class);
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(sCase.getToken(), token);
            softAssert.assertAll();
        }
        return this;
    }


}
