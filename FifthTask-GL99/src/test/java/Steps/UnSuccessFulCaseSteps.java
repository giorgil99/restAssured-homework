package Steps;

import Models.JsonMapper;
import Models.UnsuccessfulCase;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class UnSuccessFulCaseSteps {

    public static Response response;

// making unsuccessful call

    @Step("Make unsuccessful Call ")
    public UnSuccessFulCaseSteps unsuccessfulCall() {
        RestAssured.baseURI = "https://reqres.in/api/register";
        JsonMapper impFailure = new JsonMapper();

       this.response = given().contentType("application/json").body(impFailure.
                        registerUserWith1Key("email", "sydney@fife"))
                .post().then().extract().response();

        return  this;
        }


        @Step("Assert unsuccessful call  error message ")
    public  UnSuccessFulCaseSteps assertErrorMessage(String error){
        if (response.statusCode() == 400) {
            Models.UnsuccessfulCase fCase = response.getBody().as(UnsuccessfulCase.class);
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(fCase.getError(), error);
            softAssert.assertAll();
        }
            return this;
        }
}
