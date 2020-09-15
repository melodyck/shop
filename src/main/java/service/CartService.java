package service;

import entity.Cart;

import java.util.List;

public interface CartService {
    List<Cart> findByUid(int uid);
    void deleteCartByUid(int uid);
    void addNum(Cart cart);
    void reduceNum(Cart cart);
    void insertCart(Cart cart);
    void deleteCart(Cart cart);
}
