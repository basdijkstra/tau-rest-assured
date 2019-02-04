package examples;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Chapter2Test {

    @Test
    public void requestUsZipCode90210_checkStatusCode_expectHttp200() {

        given().
        when().
            get("http://zippopotam.us/us/90210").
        then().
            assertThat().
            statusCode(200);
    }

    @Test
    public void requestUsZipCode90210_checkContentType_expectApplicationJson() {

        given().
        when().
            get("http://zippopotam.us/us/90210").
        then().
            assertThat().
            contentType(ContentType.JSON);
    }

    @Test
    public void requestUsZipCode90210_logRequestAndResponseDetails() {

        given().
            log().all().
        when().
            get("http://zippopotam.us/us/90210").
        then().
            log().body();
    }

    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills() {

        given().
        when().
            get("http://zippopotam.us/us/90210").
        then().
            assertThat().
            body("places[0].'place name'", equalTo("Beverly Hills"));
    }

    @Test
    public void requestUsZipCode90210_checkStateNameInResponseBody_expectCalifornia() {

        given().
        when().
            get("http://zippopotam.us/us/90210").
        then().
            assertThat().
            body("places[0].state", equalTo("California"));
    }

    @Test
    public void requestUsZipCode90210_checkListOfPlaceNamesInResponseBody_expectContainsBeverlyHills() {

        given().
        when().
            get("http://zippopotam.us/us/90210").
        then().
            assertThat().
            body("places.'place name'", hasItem("Beverly Hills"));
    }

    @Test
    public void requestUsZipCode90210_checkNumberOfPlaceNamesInResponseBody_expectOne() {

        given().
        when().
            get("http://zippopotam.us/us/90210").
        then().
            assertThat().
            body("places.'place name'", hasSize(1));
    }
}
