package dao;

import entity.User;

public interface UserDao {
    public void registUser(User user);

    User findUserByEmailAndPassword(String email,String password);

    User checkUser(String uname);
    boolean checkEmail(String email);
    int updateUserStatus(String code);

}
