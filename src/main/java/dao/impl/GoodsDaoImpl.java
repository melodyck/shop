package dao.impl;

import dao.GoodsDao;
import entity.Goods;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    //查找商品总数
    public int findCount(int gid) {
        String sql="select count(*) from tab_Goods where gid=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,gid);
    }
    //查询出某页要显示的商品页面
    @Override
    public List<Goods> findByPage(int gid, int start, int pageSize) {
        String sql="select * from tab_Goods where gid=? limit ?,?";
        List<Goods> list=  jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Goods.class),gid,start,pageSize);
        return list;
    }
    //根据商品id查询所有信息
    @Override
    public Goods findById(int gid) {
        String sql = "select * from tab_Goods where gid = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Goods.class), gid);
    }
}
