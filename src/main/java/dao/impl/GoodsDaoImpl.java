package dao.impl;

import dao.GoodsDao;
import entity.goods;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    //查找商品总数
    public int findCount(int gid) {
        String sql="select count(*) from tab_goods where gid=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,gid);
    }
//查询出某页要显示的商品页面
    @Override
    public List<goods> findByPage(int gid, int start, int pageSize) {
        String sql="select * from tab_goods where gid=? limit ?,?";
      List<goods> list=  jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(goods.class),gid,start,pageSize);
        return list;
    }
//根据商品id查询所有信息
    @Override
    public goods findById(int gid) {
        String sql = "select * from tab_goods where gid = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(goods.class), gid);
    }
}
