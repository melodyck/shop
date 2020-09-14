package dao;

import entity.Cart;

import java.util.List;

public interface CartDao {
    Cart findByUidAndGid(int uid, int gid);
    List<Cart> findByUid(int uid);
    void deleteCartByUid(int uid);
    void addNum(Cart cart);
    void reduceNum(Cart cart);
    void insertCart(Cart cart);
    void deleteCart(Cart cart);
}
