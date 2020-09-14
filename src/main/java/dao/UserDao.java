package dao;

import entity.User;

public interface UserDao {
    public void registUser(User user);

    User findUserByEmailAndPassword(String email,String password);
}
