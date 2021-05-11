package API;

import Helpers.PropertiesReader;
import Models.UsersResponseModel;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;


public class Requests {

    private final static String ENDPOINT = "users/";

    private static RequestSpecification baseRequest() {
        RestAssured.baseURI = PropertiesReader.getProperty("baseURL");
        return RestAssured.given();
    }

    public static UsersResponseModel getUsers() {
        String response = baseRequest()
                .get(ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .extract()
                .body()
                .asString();

        return new Gson().fromJson(response, UsersResponseModel.class);
    }

    public static UsersResponseModel getUsers(Integer page) {
        String response = baseRequest()
                .queryParam("page", page)
                .get(ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .extract()
                .body()
                .asString();

        return new Gson().fromJson(response, UsersResponseModel.class);
    }
}
