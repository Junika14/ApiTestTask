package request;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class ApiRequest {

    //GET DATA
    public static Response getEndpoint(String endpoint, String bearerToken){
        return RestAssured.given()
                .header("Authorization", "Bearer " + bearerToken)
                .when()
                .get(endpoint);
    }
    //CREATE DATA
    public static Response postEndpoint(String endpoint, String requestBody, String bearerToken){
        return RestAssured.given()
                .header("Authorization", "Bearer " + bearerToken)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(endpoint);
    }

    public static void printResponse(Response response) {
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
        // System.out.println("Response Headers: " + response.getHeaders());
    }
}
