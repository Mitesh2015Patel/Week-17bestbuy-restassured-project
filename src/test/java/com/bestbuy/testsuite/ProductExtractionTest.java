package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductExtractionTest {

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

    //Extract the limit
    @Test
    public void limit() {
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");

    }

    //Extract the total
    @Test
    public void total() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of total is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    //Extract the name of 5th product
    @Test
    public void nameOfTheProduct() {
        String nameOf5thProduct = response.extract().path("data[5].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of allstorename is : " + nameOf5thProduct);
        System.out.println("------------------End of Test---------------------------");
    }

    //Extract the names of all the products
    @Test
    public void nameAllProducts() {
        List<String> allProducts = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of all store name are : " + allProducts);
        System.out.println("------------------End of Test---------------------------");
    }

    //Extract the productId of all the products
    @Test
    public void productId() {
        List<Integer> allproductsId = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of all store name are : " + allproductsId);
        System.out.println("------------------End of Test---------------------------");
        //data[*].id
    }

    //Print the size of the data list
    @Test
    public void printSize() {
        List<Integer> dataList = response.extract().path("data.findAll{it}.list");
        System.out.println("Print the size of all data list =" + dataList.size());
    }

    //Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)
    @Test
    public void getValueOfProductName() {
        List<String> product = response.extract().path("data.findAll{it.name == 'Energizer - N Cell E90 Batteries (2-Pack)'}");
        System.out.println("Get all the value of the store name = st cloud = " + product);
    }

    //Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)
    @Test
    public void modelOfTheProduct() {
        List<String> model = response.extract().path("data.findAll{it.name == 'Energizer - N Cell E90 Batteries (2-Pack)'}");
        System.out.println("Get the model of the product =" + model);
    }

    //Get all the categories of 8th products
    @Test
    public void categories8thproducts() {
        List<String> categories = response.extract().path("data[8].categories");
        System.out.println("Get all the services of 8 store " + categories);
    }

    //Get categories of the store where product id =  309062
    @Test
    public void storeProductId() {
        List<String> productId = response.extract().path("data[8].categories");
        System.out.println("Get all the storeId of all the store " + productId);
    }

    //Get all the descriptions of all the products
    @Test
    public void productDescription() {
        List<String> description = response.extract().path("data.findAll{it.name == 'data[*].description'}");
        System.out.println("Get the all description of the product =" + description);

    }

    //Get id of all the all categories of all the products
    @Test
    public void idOfAllCategories() {
        List<String> productId = response.extract().path("data.id");
        System.out.println("Get all the productId of all the store " + productId);
    }

    //Find the product names Where type = HardGood
    @Test
    public void productType() {
        List<String> productNames = response.extract().path("data.name");
        System.out.println("Get all the product names : " + productNames);
    }

    //Find the Total number of categories for the product where product name = Energizer - N Cell E90 Batteries (2-Pack)
    @Test
    public void totalNumberOfCategories() {
        List<Integer> categories = response.extract().path("data[4].categories");
        System.out.println("Find the categoried for the productname Energizer - N Cell E90 Batteries (2-Pack) " + categories.size());
    }

    //Find the createdAt for all products whose price < 5.49
    @Test
    public void priceProduct() {
        List<Integer> createdAtProduct = response.extract().path("data.findAll{it.price > 5.49}.createdAt");
        System.out.println("Find the createdAt for all products " + createdAtProduct);
    }

    //Find the name of all categories Where product name = “"Energizer - N Cell E90 Batteries (2-Pack)”
    @Test
    public void allCategoriesProductName(){
        List<String> names = response.extract().path("data[4].categories");
        System.out.println("Get all the product names : " + names);
    }
    //Find the manufacturer of all the products
    @Test
    public void manuProducts(){
        List<String>manufacturer = response.extract().path("data.manufacturer");
        System.out.println("The manufacturer of all the products : " + manufacturer);
    }
    //38. Find the imge of products whose manufacturer is = Energizer
    @Test
    public void imgProducts(){
        String products = response.extract().path("data[4].image");
        System.out.println("Get all the product names : " + products);
    }
    //Find the createdAt for all categories products whose price > 5.99
    @Test
    public void CategoriesProductPrice(){
        List<Integer> createdAtProduct = response.extract().path("data.findAll{it.categories.'price > 5.99'}.createdAt");
        System.out.println("Find the createdAt for all products " + createdAtProduct);

    }
    //Find the uri of all the products
    @Test
    public void urlProducts(){
        List<Integer> url = response.extract().path("data.url");
        System.out.println("Find the url of all the products " + url);
    }
}