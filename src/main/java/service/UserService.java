package service;

import entity.User;

public interface UserService {
    boolean registUser(User user);

    User login(String email,String password);

    boolean checkUser(String uname);

}
