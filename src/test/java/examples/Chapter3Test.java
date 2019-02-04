package examples;

import com.tngtech.java.junit.dataprovider.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@RunWith(DataProviderRunner.class)
public class Chapter3Test {

    @DataProvider
    public static Object[][] zipCodesAndPlaces() {
        return new Object[][] {
            { "us", "90210", "Beverly Hills" },
            { "us", "12345", "Schenectady" },
            { "ca", "B2R", "Waverley"}
        };
    }

    @Test
    @UseDataProvider("zipCodesAndPlaces")
    public void requestZipCodesFromCollection_checkPlaceNameInResponseBody_expectSpecifiedPlaceName(String countryCode, String zipCode, String expectedPlaceName) {

        given().
            pathParam("countryCode", countryCode).pathParam("zipCode", zipCode).
        when().
            get("http://zippopotam.us/{countryCode}/{zipCode}").
        then().
            assertThat().
            body("places[0].'place name'", equalTo(expectedPlaceName));
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
    public void requestUsZipCode12345_checkPlaceNameInResponseBody_expectSchenectady() {

        given().
        when().
            get("http://zippopotam.us/us/12345").
        then().
            assertThat().
            body("places[0].'place name'", equalTo("Schenectady"));
    }

    @Test
    public void requestCaZipCodeB2R_checkPlaceNameInResponseBody_expectWaverley() {

        given().
        when().
            get("http://zippopotam.us/ca/B2R").
        then().
            assertThat().
            body("places[0].'place name'", equalTo("Waverley"));
    }
}
