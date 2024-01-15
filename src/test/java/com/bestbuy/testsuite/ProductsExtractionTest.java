package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductsExtractionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI="http://localhost";
        RestAssured.port=3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);

    }
//    21. Extract the limit
@Test
public void test021() {
    int limit = response.extract().path("limit");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value of limit is : "+limit);
    System.out.println("------------------End of Test---------------------------");

}
//22. Extract the total
@Test
public void test022() {
    int total = response.extract().path("total");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value of total is : " + total);
    System.out.println("------------------End of Test---------------------------");
}
//23. Extract the name of 5th product
@Test
public void test023() {
    String name = response.extract().path("data[4].name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The product name  is : " + name);
    System.out.println("------------------End of Test---------------------------");
}

//24. Extract the names of all the products
@Test
public void test024() {
    List<Integer> listOfNames = response.extract().path("data.name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The names of the products are : " + listOfNames);
    System.out.println("------------------End of Test---------------------------");
}
//25. Extract the productId of all the products
@Test
public void test025() {
    List<Integer> listOfProductId = response.extract().path("data.id");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The names of the productsId are : " + listOfProductId);
    System.out.println("------------------End of Test---------------------------");
}
//26. Print the size of the data list
@Test
public void test026() {
    List<Integer> sizeoflist = response.extract().path("data.id");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The size of the data is : " + sizeoflist);
    System.out.println("------------------End of Test---------------------------");
}

//27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-pack)
@Test
public void test027() {
    List<Object> productValues = response.extract().path("data.find { it.productName == 'Energizer - MAX Batteries AA (4-pack)' }");

    System.out.println("------------------Starting Test---------------------------");
    System.out.println("All values for the product 'Energizer - MAX Batteries AA (4-pack)': " + productValues);
    System.out.println("------------------End of Test---------------------------");
}

//28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-pack)
@Test
public void test028() {
    String model = response.extract().path("data[7].model");

    System.out.println("------------------Starting Test---------------------------");
    System.out.println("Model for the product 'Energizer - N Cell E90 Batteries': " + model);
    System.out.println("------------------End of Test---------------------------");
}
//29. Get all the categories of 8th products
@Test
public void test029() {
    List<Integer> categories = response.extract().path("data[8].categories");

    System.out.println("------------------Starting Test---------------------------");
    System.out.println("categories for the product : " + categories);
    System.out.println("------------------End of Test---------------------------");
}
//30.Get categories of the store where product id = 150115
@Test
public void test030() {
    List<String> categories = response.extract().path("data[3].categories");

    System.out.println("------------------Starting Test---------------------------");
    System.out.println("Categories for the product with productId 150115: " + categories);
    System.out.println("------------------End of Test---------------------------");
}
//31. Get all the descriptions of all the products
@Test
public void test031() {
List<String> descriptions = response.extract().path("data.description");

    System.out.println("------------------Starting Test---------------------------");
    System.out.println("Descriptions of all products: " + descriptions);
    System.out.println("------------------End of Test---------------------------");
}
//32. Get id of all the all categories of all the products
@Test
public void test032() {
    List<String> categories = response.extract().path("data.categories.id");

    System.out.println("------------------Starting Test---------------------------");
    System.out.println("categories of all products: " + categories);
    System.out.println("------------------End of Test---------------------------");
}
//33. Find the product names Where type = HardGood
@Test
public void test033() {
    String name = response.extract().path("data[0].type");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The product name  is : " + name);
    System.out.println("------------------End of Test---------------------------");
}
//34. Find the Total number of categories for the product where product name = Duracell - AA
//1.5V CopperTop Batteries (4-Pack)
@Test
public void test034() {
    String name = response.extract().path("data[1].name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The product name  is Duracell - AA 1.5V CopperTop Batteries (4-Pack): " + name);
    System.out.println("------------------End of Test---------------------------");
}
//35. Find the createdAt for all products whose price < 5.49
@Test
public void test0035() {
    List<String>productsPrice= response.extract().path("data.findAll{it.price < 5.49}.price");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The names of products that price is less than 5.49 are: "+ productsPrice);
    System.out.println("------------------End of Test---------------------------");
}

// 36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-pack)"
@Test
public void test036() {
    List<String> categories = response.extract().path("data[3].categories");

    System.out.println("------------------Starting Test---------------------------");
    System.out.println("Categories for the product 'Energizer - MAX Batteries AA (4-pack)': " + categories);
    System.out.println("------------------End of Test---------------------------");
}
//37. Find the manufacturer of all the products
@Test
public void test037() {
    List<String>manufacturer = response.extract().path("data.manufacturer");

    System.out.println("------------------Starting Test---------------------------");
    System.out.println("manufacturer of the  product : " + manufacturer);
    System.out.println("------------------End of Test---------------------------");
}
//38. Find the imge of products whose manufacturer is = Energizer
@Test
public void test038() {
    List<String>manufacturer = response.extract().path("data[3,8].manufacturer");

    System.out.println("------------------Starting Test---------------------------");
    System.out.println("manufacturer of the  product : " + manufacturer);
    System.out.println("------------------End of Test---------------------------");
}

//39. Find the createdAt for all categories products whose price > 5.99
@Test
public void test0039() {
    List<String>productsPrice= response.extract().path("data.findAll{it.price > 5.99}.price");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The names of products that price is greater than 5.99 are: "+ productsPrice);
    System.out.println("------------------End of Test---------------------------");
}
//  40. Find the uri of all the products
@Test
public void test040() {
    List<String>product = response.extract().path("data.url");

    System.out.println("------------------Starting Test---------------------------");
    System.out.println("url of the  product : " + product);
    System.out.println("------------------End of Test---------------------------");
}
}
