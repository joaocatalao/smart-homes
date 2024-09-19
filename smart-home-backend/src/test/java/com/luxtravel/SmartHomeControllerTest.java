package com.luxtravel;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class SmartHomeControllerTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/api")
          .then()
             .statusCode(200)
             .body(is("Smart Home Backend is Running!"));
    }

}