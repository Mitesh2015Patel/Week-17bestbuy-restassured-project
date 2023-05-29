package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class StoreExtractionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);

    }

    //1. Extract the limit
    @Test
    public void extractLimit() {
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");

    }

    // extract the total
    @Test
    public void extractTotal() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of total is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    //Extract the name of 5th store
    @Test
    public void extractName5thstore() {
        String allStoreName = response.extract().path("data[3].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of allstorename is : " + allStoreName);
        System.out.println("------------------End of Test---------------------------");
    }

    //Extract the names of all the store
    @Test
    public void NameOfALlStore() {
        List<String> allStoreName = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of all store name are : " + allStoreName);
        System.out.println("------------------End of Test---------------------------");
        //data[*].name
    }

    //Extract the storeId of all the store
    @Test
    public void NameOfStoreId() {
        List<Integer> allStoreId = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of all store name are : " + allStoreId);
        System.out.println("------------------End of Test---------------------------");
        //data[*].id
    }

    @Test
    //Print the size of the data list
    public void sizeOfDataList() {
        List<Integer> dataList = response.extract().path("data.findAll{it}.list");
        System.out.println("Print the size of all data list =" + dataList.size());
    }

    @Test
    //Get all the value of the store where store name = St Cloud
    public void valueOfStoreCloud() {
        List<String> value = response.extract().path("data.findAll{it.name == 'stCloud'}");
        System.out.println("Get all the value of the store name = st cloud = " + value);
    }

    @Test
    //Get the address of the store where store name = Rochester
    public void addressOfStoreRochester() {
        List<String> address = response.extract().path("data.findAll{it.name == 'Rochester'}.address");
        System.out.println("Get the address of the store where store name Rochester =" + address);

    }

    @Test
    //Get all the services of 8th store
    public void allServicesOf8thStore() {
        List<String> services = response.extract().path("data[8].services");
        System.out.println("Get all the services of 8 store " + services);
    }

    @Test
    //Get storeservices of the store where service name = Windows Store
    public void storeServicesWindowsStore() {
        List<String> storeServices = response.extract().path("data.findAll{it.services.name =='Windows Store'}.services.name");
        System.out.println("Get storeservices of the store where service name = Windows Store " + storeServices);
    }

    @Test
    //Get all the storeId of all the store
    public void storeIdOfAllStore() {
        List<String> storesId = response.extract().path("data.id");
        System.out.println("Get all the storeId of all the store " + storesId);
    }

    @Test
    //Find the store names Where state = ND
    public void nameOfStateND() {
        List<String> stateName = response.extract().path("data.findAll{it.state== 'ND'}.name");
        System.out.println("Find the store names Where state = ND " + stateName);

    }

    @Test
    //Find the Total number of services for the store where store name = Rochester
    public void servicesStoreNameRochester() {
        List<Integer> servicesRochester = response.extract().path("data.find{it.name== 'Rochester'}.services");
        System.out.println("Find the Total number of services for the store where store name = Rochester " + servicesRochester.size());
    }

    @Test
    //Find the createdAt for all services whose name = “Windows Store”
    public void createdAtStoreWindowsStore() {
        List<Integer> createdAtWindowsStore = response.extract().path("data.findAll{it.services.name=='Windows Store'}.createdAt");
        System.out.println("Find the createdAt for all services whose name = Windows Store " + createdAtWindowsStore);

    }

    @Test
    //Find the name of all services Where store name = “Fargo”
    public void nameOfAllServiceFargo() {
        List<String> servicesFargo = response.extract().path("data.findAll{it.services.name=='Fargo'}.name");
        System.out.println("Find the name of all services Where store name = “Fargo” " + servicesFargo);
    }

    @Test
    //Find the zip of all the store
    public void zipOfStore() {
        List<Integer> zipStore = response.extract().path("data.zip");
        System.out.println("Find the zip of all the store " + zipStore);

    }

    @Test
    //Find the zip of store name = Roseville
    public void zipOfRoseville() {
        List<Integer> zipRoseville = response.extract().path("data.findAll{it.name== 'Roseville'}.zip");
        System.out.println("Find the zip of store name = Roseville " + zipRoseville);

    }

    @Test
    //Find the storeservices details of the service name = Magnolia Home Theater
    public void storeServicesOfMangoliaHomeTheater() {
        List<String> storeServicesMangolia = response.extract().path("data.findAll{it.services.name== 'Magnolia Home Theater'}.storeservices");
        System.out.println("Find the storeservices details of the service name = Magnolia Home Theater " + storeServicesMangolia);
    }

    @Test
    //Find the lat of all the stores
    public void latStore() {
        List<Integer> lat = response.extract().path("data.lat");
        System.out.println("Find the lat of all the stores " + lat);

    }
}


