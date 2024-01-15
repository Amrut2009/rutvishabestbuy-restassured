package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest {
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

    //    1. Extract the limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    //2. Extract the total
    @Test
    public void test002() {
        int total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of total is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    //3. Extract the name of 5th store
    @Test
    public void test003() {
        String name = response.extract().path("data[4].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store name  is : " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    //4. Extract the names of all the store
    @Test
    public void test004() {
        List<Integer> listOfNames = response.extract().path("data.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the products are : " + listOfNames);
        System.out.println("------------------End of Test---------------------------");
    }

    //5. Extract the storeId of all the store
    @Test
    public void test005() {
        List<Integer> listOfIds = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Ids are : " + listOfIds);
        System.out.println("------------------End of Test---------------------------");

    }

    //6. Print the size of the data list
    @Test
    public void test006() {
        List<Integer> sizeoflist = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the data is : " + sizeoflist);
        System.out.println("------------------End of Test---------------------------");
    }

    //7. Get all the value of the store where store name = St Cloud
    @Test
    public void test007() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'St Cloud'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The values for store name 'St Cloud)' are: " + values);
        System.out.println("------------------End of Test---------------------------");
    }

    //8. Get the address of the store where store name = Rochester
    @Test
    public void test08() {

        List<HashMap<String, ?>> address = response.extract().path("data.findAll{it.name == 'Rochester'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The address of the store name is: " + address);
        System.out.println("------------------End of Test---------------------------");
    }

    //9. Get all the services of 8th store
    @Test
    public void test09() {

        List<String> services = response.extract().path(("data[7].services"));

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The services of the store name is: " + services);
        System.out.println("------------------End of Test---------------------------");
    }


    //10. Get storeservices of the store where service name = Windows Store
    @Test
    public void test010() {


        List<String> storeServices = response.extract().path(("data.find { store -> store.services.find { service -> service.serviceName == 'Windows Store' } != null }.services*.serviceName"));

        System.out.println("------------------Starting Test---------------------------");
        System.out.println("Store services for the store with service name 'Windows Store': " + storeServices);
        System.out.println("------------------End of Test---------------------------");
    }

    //11. Get all the storeId of all the store
    @Test
    public void test0011() {
        List<Integer> listOfId = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the storeId are : " + listOfId);
        System.out.println("------------------End of Test---------------------------");
    }

    //12. Get id of all the store
    @Test
    public void test0012() {
        List<Integer> listOfId = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the storeId are : " + listOfId);
        System.out.println("------------------End of Test---------------------------");
    }

    //13. Find the store names Where state = ND
    @Test
    public void test0013() {
        String name = response.extract().path("data[7].state");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The state name  is : " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    //14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void test0014() {
        int totalServices = response.extract().path(("data.find { it.name == 'Rochester' }.services.size()"));

        System.out.println("------------------Starting Test---------------------------");
        System.out.println("Total services for the store 'Rochester': " + totalServices);
        System.out.println("------------------End of Test---------------------------");
    }
    //15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void test0015() {
        List<String> createdAtList = response.extract().path(("data.findAll { it.name == 'Windows Store' }.createdAt"));

        System.out.println("------------------Starting Test---------------------------");
        System.out.println("createdAt for services with name 'Windows Store' are: " + createdAtList);
        System.out.println("------------------End of Test---------------------------");
    }

    //   16. Find the name of all services Where store name = “Fargo”
    @Test
    public void test0016() {
        List<String> services = response.extract().path("data.findAll { it.name == 'Fargo' }.services.flatten()");

        System.out.println("------------------Starting Test---------------------------");
        System.out.println("Services for the store 'Fargo' are: " + services);
        System.out.println("------------------End of Test---------------------------");
    }
//     17. Find the zip of all the store
@Test
public void test0017() {
    List<String> zipCodes = response.extract().path("data.zip");

    System.out.println("------------------Starting Test---------------------------");
    System.out.println("Zip codes of all stores: " + zipCodes);
    System.out.println("------------------End of Test---------------------------");
}
//18. Find the zip of store name = Roseville
@Test
public void test0018() {
    String zipCode = response.extract().path("data.find { it.name == 'Roseville' }.zip");

    System.out.println("------------------Starting Test---------------------------");
    System.out.println("Zip code for the store 'Roseville': " + zipCode);
    System.out.println("------------------End of Test---------------------------");
}
//19. Find the storeservices details of the service name = Magnolia Home Theater
@Test
public void test0019() {
    List<String> serviceDetails = response.extract().path("data.findAll { store -> store.services.find { service -> service.serviceName == 'Magnolia Home Theater' } != null }.services.find { it.serviceName == 'Magnolia Home Theater' }.details");

    System.out.println("------------------Starting Test---------------------------");
    System.out.println("Service details for 'Magnolia Home Theater': " + serviceDetails);
    System.out.println("------------------End of Test---------------------------");
}
//20. Find the lat of all the stores
@Test
public void test0020() {
    List<String> lat = response.extract().path("data.lat");

    System.out.println("------------------Starting Test---------------------------");
    System.out.println("lat codes of all stores: " + lat);
    System.out.println("------------------End of Test---------------------------");

}
    }
