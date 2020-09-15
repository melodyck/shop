package dao.impl;

import dao.UserDao;
import entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class UserDaoImpl implements UserDao {
    JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    public int registUser(User user){
        String sql="insert into tab_user values(null,?,?,?,?,?,?,?,?)";
        System.out.println(user.getUname()+user.getPassword()+","+user.getSex()+","+user.getEmail()+","+user.getPhone()+","+user.getAddress()+","+user.getStatus()+","+user.getCode());
        final int update = template.update(sql, user.getUname(), user.getPassword(), user.getSex(), user.getEmail(), user.getPhone(), user.getAddress(), user.getStatus(), user.getCode());
         return update;
    }

    @Override
    public User findUserByEmailAndPassword(String email,String password) {
        String sql="select * from tab_user where email=? and password=?";
        User user1=template.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),email,password);
        return user1;
    }

    @Override
    public User checkUser(String uname) {
        String sql="select * from tab_user where uname=?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), uname);
        System.out.println(user.getUname()+user.getEmail());
        return user;
    }
}
