package service.impl;

import dao.CartDao;
import dao.impl.CartDaoImpl;
import entity.Cart;
import service.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {
    private CartDao cd = new CartDaoImpl();

    @Override
    public List<Cart> findByUid(int uid) {
        List<Cart> cartList = cd.findByUid(uid);
        return cartList;
    }

    @Override
    public void deleteCartByUid(int uid) {
        cd.deleteCartByUid(uid);
    }

    @Override
    public void addNum(Cart cart) {
        cd.addNum(cart);
    }

    @Override
    public void reduceNum(Cart cart) {
        cd.reduceNum(cart);
    }

    @Override
    public void insertCart(Cart cart) {
        cd.insertCart(cart);
    }

    @Override
    public void deleteCart(Cart cart) {
        cd.deleteCart(cart);
    }
}
