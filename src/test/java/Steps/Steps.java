package Steps;

import Models.UserModel;
import Models.UsersResponseModel;

import java.util.List;
import java.util.stream.Collectors;

import static API.Requests.getUsers;

public class Steps {

    public static List<UserModel> getAllUsers() {
        List<UserModel> users;
        UsersResponseModel resp = getUsers();
        int page = resp.page;
        int totalPages = resp.total_pages;
        users = resp.data;

        while (totalPages == page + 1) {
            users.addAll(getUsers(page + 1).data);
            page++;
        }

        return users;
    }

    public static UserModel getUserByName(List<UserModel> users, String name) {
        return users
                .stream()
                .filter(userModel -> userModel.getFullName().equals(name))
                .collect(Collectors.toList())
                .get(0);
    }
}
