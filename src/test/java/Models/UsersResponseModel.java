package Models;

import lombok.Data;

import java.util.List;

@Data
public class UsersResponseModel {
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public List<UserModel> data;
    public Support support;
}

@Data
class Support{
    public String url;
    public String text;
}