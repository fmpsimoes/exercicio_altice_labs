package org.acme;

import io.quarkus.test.junit.QuarkusTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {
    @Test
    void testLabseqValueNegativeEndpoint() {
        given()
          .when().get("/labseq/-1")
          .then()
             .statusCode(400)
             .body("value", is("0"))
             .body("message", is("invalid"));
    }
    @Test
    void testLabseqValueEndpoint() {
        given()
          .when().get("/labseq/11")
          .then()
             .statusCode(200)
             .body("value", is("4"))
             .body("message", is("valid"));
    }
   
    @Test
    void testLabseqValueHighEndpointPerformance() {
        long startTime = System.currentTimeMillis();

        given()
          .when().get("/labseq/10000")
          .then()
             .statusCode(200)
             .body("value", is("9062959782884117635"))
             .body("message", is("valid"));

        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;
        assertTrue(executionTime <= 10000, "Tempo de execução excedeu 10 segundos!");
    }

}