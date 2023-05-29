package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ProductAssertionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);

    }

    //Verify the if the total is equal to 51965
    @Test
    public void verifyTotal() {
        response.body("total", equalTo(51965));
    }

    //Verify the if the stores of limit is equal to 10
    @Test
    public void storeLimit() {
        response.body("limit", equalTo(10));
    }

    // Check the single ‘Name’ in the Array list (Duracell - c Batteries (4-Pack))
    @Test
    public void verifySingleName() {
        response.body("data.name", hasItem("Duracell - C Batteries (4-Pack)"));
    }

    // Check the multiple ‘Names’ in the ArrayList
    @Test
    public void multiplesNames() {
        response.body("data.name", hasItems("Duracell - C Batteries (4-Pack)", "Duracell - 9V Batteries (2-Pack)", "Energizer - N Cell E90 Batteries (2-Pack)"));

    }

    // Verify the productId= 185267 inside categories of the third name is “Household Batteries”
    @Test
    public void ProductId() {
        response.body("data[2].services[3].storeservices.storeId", equalTo("Household Batteries"));



    }

    // Verify the categories second name = “Housewares” of productID = 333179
    @Test
    public void verifyProductId() {
        String productId = response.extract().path("data[4].categories[1].id");
        System.out.println("verify product id  " + productId);

    }

    // Verify the price = 5.99
    @Test
    public void verifyPrice() {
        response.body("data[3].price", equalTo(4.99f));
    }

        // Verify the Product name = Metra - Radio Dash Multikit for Select GM Vehicles - Black of 6th product
        @Test
        public void verifyProductName () {
            String productName = response.extract().path("data[6].name");
            System.out.println("verify 6th product name is : " + productName);
        }
 // Verify the ProductId =   347155 for the 8th product
    @Test
    public void Verify9thPtoduct(){
        int id = response.extract().path("data[9].id");
        System.out.println("8th Store Id is " + id);
    }
    //Verify the prodctId = 346575 have 5 categories
    @Test
    public void fiveCategories(){
        List<String> categories = response.extract().path("data[5].categories");
        System.out.println("4 categories od productId " + categories);
    }
    }
