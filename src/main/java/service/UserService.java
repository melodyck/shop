package service;

import entity.User;

public interface UserService {
    public boolean registUser(User user);

    User login(String email,String password);
}
