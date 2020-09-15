package dao.impl;

import dao.GoodsDao;
import entity.Goods;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

public class GoodsDaoImpl implements GoodsDao {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Goods SearchGoods(String str) {
        String sql="select * from tab_goods where str like '%?%' ";
        Goods goods = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Goods.class), str);
        return goods;
    }

    @Override
    public Goods findAllGoods() {
        String sql="select * from tab_goods";
        Goods goods = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Goods.class));
        return goods;
    }


}
