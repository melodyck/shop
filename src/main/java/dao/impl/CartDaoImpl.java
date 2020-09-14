package dao.impl;

import dao.CartDao;
import entity.Cart;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class CartDaoImpl implements CartDao {
    private static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Cart findByUidAndGid(int uid, int gid) {
        String sql = "select * from `tab_cart` where uid = ? and gid = ?";
        List<Cart> carts = template.query(sql, new BeanPropertyRowMapper<>(Cart.class), uid, gid);
        if (carts == null || carts.size() == 0){
            return null;
        }
        return carts.get(0);
    }

    @Override
    public List<Cart> findByUid(int uid) {
        String sql = "select * from `tab_cart` where uid = ?;";
        List<Cart> cartList = template.query(sql, new BeanPropertyRowMapper<>(Cart.class), uid);
        if (cartList == null || cartList.size() == 0){
            return null;
        }
        return cartList;
    }

    @Override
    public void deleteCartByUid(int uid) {
        String sql = "delete from `tab_cart` where uid = ?;";
        template.update(sql, uid);
    }

    @Override
    public void addNum(Cart cart) {
        String sql = "update `tab_cart` set `number` = ? where uid = ? and gid = ?;";
        template.update(sql, cart.getNumber() + 1, cart.getUid(), cart.getGid());
    }

    @Override
    public void reduceNum(Cart cart) {
        String sql = "update `tab_cart` set `number` = ? where uid = ? and gid = ?;";
        template.update(sql, cart.getNumber() - 1, cart.getUid(), cart.getGid());
    }

    @Override
    public void insertCart(Cart cart) {
        String sql = "insert into `tab_cart` values(?, ?, ?);";
        template.update(sql, cart.getUid(), cart.getGid(), cart.getNumber());
    }

    @Override
    public void deleteCart(Cart cart) {
        String sql = "delete from `tab_cart` where uid = ? and gid = ?;";
        template.update(sql, cart.getUid(), cart.getGid());
    }
}
