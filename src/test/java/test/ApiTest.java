package test;


import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import request.ApiRequest;

public class ApiTest {

    private static final String BASE_URL = "https://gorest.co.in/public/v2";
    private static final String BEARER_TOKEN = "b3fe00faffe8a167f40c2e589b909ac94889ffefaa58fbe9025f7dc67032f070";

    @Test
    public void testGetUser(){
        String endpoint = BASE_URL + "/users";
        String token = BEARER_TOKEN;
        Response response = ApiRequest.getEndpoint(endpoint,token);
        ApiRequest.printResponse(response);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    // POSITIVE CASE CREATE
    @Test
    public void testPostUser(){
        //getendpoint
        String endpoint = BASE_URL + "/users";
        String token = BEARER_TOKEN;
        String name = "Arun Dubashi";
        String email = "dinymic@mail.com";
        String gender =  "male";
        String status =  "active";

        //setJSON
        JSONObject body = new JSONObject();
        body.put("name",name);
        body.put("email", email);
        body.put("gender", gender);
        body.put("status", status);

        //
        String requestBody = body.toString();

        Response response = ApiRequest.postEndpoint(endpoint,requestBody,token);
        //
        ApiRequest.printResponse(response);
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    //MAXIMUM VALUE,"Value of STATUS must inactive or Active"
    @Test
    public void testNegativePost(){
        String bearerToken = BEARER_TOKEN;
        String endpoint = BASE_URL + "/users";
        //
        String name = "Arun Dubashi";
        String email = "arun@mail.com";
        String gender =  "male";
        String status =  "123";
        //
        JSONObject body = new JSONObject();
        body.put("name", name);
        body.put("email", email);
        body.put("gender", gender);
        body.put("status", status);
        //
        String requestBody = body.toString();
        Response response = ApiRequest.postEndpoint(endpoint,requestBody,bearerToken);
        ApiRequest.printResponse(response);
        Assert.assertEquals(response.getStatusCode(), 422);

    }
    @Test
    //MINIMUM STRING GENDER must MALE/FEMALE
    public void testMinimum(){
        String bearerToken = BEARER_TOKEN;
        String endpoint = BASE_URL + "/users";
        //
        String name = "amer";
        String email = "amer@mail.com";
        String gender =  "wanita";
        String status =  "active";
        //
        JSONObject body = new JSONObject();
        body.put("name", name);
        body.put("email", email);
        body.put("gender", gender);
        body.put("status", status);
        //
        String requestBody = body.toString();
        Response response = ApiRequest.postEndpoint(endpoint,requestBody,bearerToken);
        ApiRequest.printResponse(response);
        Assert.assertEquals(response.getStatusCode(), 422);

    }

}
