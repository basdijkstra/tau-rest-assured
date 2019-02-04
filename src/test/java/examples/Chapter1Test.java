package examples;

import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Chapter1Test {

    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills() {

        given().
        when().
            get("http://zippopotam.us/us/90210").
        then().
            assertThat().
            body("places[0].'place name'", equalTo("Beverly Hills"));
    }
}
