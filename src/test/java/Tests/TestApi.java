package Tests;

import Helpers.PropertiesReader;
import Models.UserModel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static Steps.Steps.getAllUsers;
import static Steps.Steps.getUserByName;


public class TestApi {

    @Test
    public void ApiTest() {
        List<UserModel> users = getAllUsers();
        Assert.assertEquals(getUserByName(users, PropertiesReader.getProperty("firstUser")).getEmail(), PropertiesReader.getProperty("firstUserEmail"));
        Assert.assertEquals(getUserByName(users, PropertiesReader.getProperty("secondUser")).getEmail(), PropertiesReader.getProperty("secondUserEmail"));
    }
}
