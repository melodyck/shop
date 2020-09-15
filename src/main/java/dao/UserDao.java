package dao;

import entity.User;

public interface UserDao {
    int registUser(User user);

    User findUserByEmailAndPassword(String email,String password);

    User checkUser(String uname);
}
