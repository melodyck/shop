package dao.impl;

import dao.MailDao;
import entity.Goods;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.Date;

public class MailDaoImpl implements MailDao {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public void sendMail(String ename, String email, String suject, String message) {
        String sql="insert into tab_feedback values(null,?,?,?,?,?)";
        jdbcTemplate.update(sql,new Date(),ename,email,suject,message);
    }

    @Override
    public void searchGoods(String str) {
        String sql="select * from tab_goods where str like '%?%' ";
        jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Goods.class),str);
    }
}