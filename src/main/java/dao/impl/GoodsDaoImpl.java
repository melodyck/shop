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
    public int findCount(int lid) {
        String sql="select count(*) from tab_goods where lid=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,lid);
    }
    //查询出某页要显示的商品页面
    @Override
    public List<Goods> findByPage(int lid, int start, int pageSize) {
        String sql="select * from tab_goods where lid=? limit ?,?";
        List<Goods> list=  jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Goods.class),lid,start,pageSize);
        for (Goods good:list
             ) {
            System.out.println(good);
        }
        return list;
    }
    //根据商品id查询所有信息
    @Override
    public Goods findById(int gid) {
        String sql = "select * from tab_goods where gid = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Goods.class), gid);
    }
}
