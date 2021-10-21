import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class RestAssuredBasic {

    @DataProvider(name = "filler")
    public Object[][] getDataFromDataprovider() {
        return new Object[][]
                {
                        {1,"USA"},
                        {5,"Hungary"},
                };
    }

    @Test(dataProvider = "filler")
    public void FirstExtraction(int index , String countryExpected) {
        SoftAssert softAssert = new SoftAssert();
        RestAssured.baseURI = "http://ergast.com/api/f1/2017/circuits.json";


        Response response = given().
                when().get().
                then().extract().response();


        String id = response.getBody().jsonPath().get("MRData.CircuitTable.Circuits[" + index + "]" + ".circuitId");
        System.out.println(id);
        softAssert.assertNotNull(id);

        Response secondResponse = given().
                when().get("http://ergast.com/api/f1/circuits/" + id + ".json").
                then().extract().response();

        String countryGiven = secondResponse.getBody().jsonPath().get("MRData.CircuitTable.Circuits[0].Location.country");
        System.out.println(countryGiven);


        softAssert.assertNotNull(countryGiven);
        softAssert.assertEquals(countryGiven,countryExpected);
        softAssert.assertAll();
        System.out.println(">>>");
    }
}
