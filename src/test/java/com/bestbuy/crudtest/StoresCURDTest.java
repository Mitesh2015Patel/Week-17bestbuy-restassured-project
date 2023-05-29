package com.bestbuy.crudtest;

import com.bestbuy.model.ServicesPojo;
import com.bestbuy.model.StorePojo;
import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.TestUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresCURDTest extends TestBase
{
    static String name = "Roseville" + TestUtils.getRandomValue();
    static  String type = "BigBox" + TestUtils.getRandomValue();
    static  String address ="1643 County Road B2" + TestUtils.getRandomValue();
    static String address2 = "";
    static Double lat = 120.23;
    static Double lng = 120.10;
    static String hours =  "Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8";
    static String city = "Roseville"+ TestUtils.getRandomValue();
    static String state = "MN"+ TestUtils.getRandomValue();
    static String zip = "55113" + TestUtils.getRandomValue();
    static String service = "{}";
    static int id;


@Before
public void setUp()
{
    RestAssured.basePath="/stores";
}


//Post Data
@Test
    public void test001()
    {
        StorePojo storePojo = new StorePojo();
        storePojo.setName(name);
        storePojo.setType(type);
        storePojo.setAddress(address);
        storePojo.setAddress2(address2);
        storePojo.setLat(lat);
        storePojo.setLng(lng);
        storePojo.setHours(hours);

        storePojo.setCity(city);
        storePojo.setState(state);
        storePojo.setZip(zip);
        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName("service1");
        storePojo.setServices(servicesPojo);


        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(storePojo)
                .post();
        response.then().log().all().statusCode(201);

    }


//Patch Data
    @Test
    public void test002()
    {
        StorePojo storePojo = new StorePojo();
        storePojo.setName(name);
        storePojo.setType(type);
        storePojo.setAddress(address);
        storePojo.setAddress2(address2);
        storePojo.setLat(lat);
        storePojo.setLng(lng);
        storePojo.setHours(hours);

        storePojo.setCity(city);
        storePojo.setState(state);
        storePojo.setZip(zip);
        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName("service1");
        storePojo.setServices(servicesPojo);
        // storePojo.setServices(serviceList);

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(storePojo)
                .patch();
        response.then().log().all().statusCode(200);

    }



//Get Data
    @Test
    public void test003() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get();
        response.prettyPrint();
        response.then().log().all().statusCode(200);
    }

//Delete Data
    @Test
    public void test004()
    {
        given()
                .pathParam("id", id)
                .when()
                .delete("/{id}")
                .then()
                .statusCode(404);
    }

}
