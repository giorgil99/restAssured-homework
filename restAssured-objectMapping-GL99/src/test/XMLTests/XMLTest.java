package XMLTests;

import io.restassured.internal.path.xml.NodeChildrenImpl;
import org.testng.annotations.Test;

import java.sql.Array;
import java.util.List;

import static io.restassured.RestAssured.given;

public class XMLTest {

    @Test
    public void XMLTest1() {
//        Using XMLPath  validate count of all 'sName' node
        int k = given().when().get("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso/ListOfContinentsByName")
                .then().extract().path("ArrayOftContinent.tContinent.sName.size()");
        System.out.println(k);
//        Using XMLPath  validate list of all 'sName' node's value
        NodeChildrenImpl continents = given().when().get("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso/ListOfContinentsByName")
                .then().extract().path("ArrayOftContinent.tContinent.sName");
        System.out.println(continents.list());
//        Using XMLPath validate 'sName' node result with value of sCode equals to 'AN'
        String expectedContinentName = given().when().get("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso/ListOfContinentsByName")
                .then().extract().path("ArrayOftContinent.tContinent.findAll{it.sCode=='AN'}.sName");
        System.out.println(expectedContinentName);
//        Using XMLPath  validate the last tContinent node's sName value
        String lastContinentName = given().when().get("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso/ListOfContinentsByName")
                .then().extract().path("ArrayOftContinent.tContinent[-1].sName");
        System.out.println(lastContinentName);

    }


}
