package service.impl;

import dao.CartDao;
import dao.impl.CartDaoImpl;
import entity.Cart;
import entity.PageBean;
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
    public Cart findCart(Cart cart) {
        return cd.findCart(cart);
    }

    @Override
    public void insertCart(Cart cart) {
        cd.insertCart(cart);
    }

    @Override
    public void deleteCart(Cart cart) {
        cd.deleteCart(cart);
    }

    @Override
    public PageBean<Cart> findByPage(int uid, int currentPage, int pageSize) {
        //1.计算开始条数
        int start = (currentPage - 1) * pageSize;
        //1.1获取cart列表
        List<Cart> cartList = cd.findByPage(uid, start, pageSize);
        //2.获取总记录条数
        int totalCount = cd.findCount(uid);
        //3.计算总页数
        int totalPage = (totalCount + (pageSize - 1)) / pageSize;

        //封装PageBean
        PageBean<Cart> pageBean = new PageBean<>();
        pageBean.setList(cartList);
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }
}
