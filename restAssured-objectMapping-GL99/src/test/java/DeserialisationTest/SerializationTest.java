package DeserialisationTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;

public class SerializationTest {

    @Test
    public void SuccessCall() {
        //        Implement SUCCESSFUL scenario with the following parameters
        Implementation impSuccess = new Implementation();
        RestAssured.baseURI = "https://reqres.in/api/register";

        Response response = given().contentType("application/json").body(impSuccess.
                        RegisterUserWith2Keys("email", "eve.holt@reqres.in", "password", "pistol"))
                .post().then().extract().response();

        System.out.println(response.getStatusCode() + " " + response.getBody().jsonPath().get("id") +
                " " + response.getBody().jsonPath().get("token"));
        if (response.statusCode() == 200) {
            SuccessCase sCase = response.getBody().as(SuccessCase.class);
            System.out.println(sCase.toString());
        }
    }


    @Test
    public void UnsuccessfulCall() {
        Implementation impFailure = new Implementation();
        RestAssured.baseURI = "https://reqres.in/api/register";

        Response response = given().contentType("application/json").body(impFailure.
                        RegisterUserWith1Keys("email", "sydney@fife"))
                .post().then().extract().response();
        System.out.println(response.getStatusCode() + " " + response.getBody().jsonPath().get("error"));

        if (response.statusCode() == 400) {

            UnsuccessfulCase fCase = response.getBody().as(UnsuccessfulCase.class);
            System.out.println(fCase.toString());


        }

    }
    @Test(priority = 1)
    public void LastCall() {
        Implementation impLast = new Implementation();
        RestAssured.baseURI = "https://reqres.in/api/users";
        Response response = given().contentType("application/json")
                .body(impLast.RegisterUserWith2Keys("name","morpheus","job","leader"))
                .post().then().extract().response();

        if (response.getStatusCode() ==201){
            LastCase lCase = response.getBody().as(LastCase.class);
            System.out.println(lCase.toString());
            System.out.println(lCase.getCreatedAt().toLocalDateTime().atZone(ZoneId.systemDefault())
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }

    }


}
