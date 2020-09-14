package web.servlet;

import entity.Cart;
import service.CartService;
import service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart/*")
public class CartServlet extends BaseServlet {
    //查找购物车中的所有商品
    public void findAll(HttpServletRequest request, HttpServletResponse response){
        //创建cart对象集合
        List<Cart> cartList = new ArrayList<>();
        //1.判断其是否登录
        Object _uid = request.getSession().getAttribute("uid");
        if (_uid == null){
            //1.1未登录的情况就从cookie中获取购物车中的商品信息
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie: cookies){
                Cart cart = new Cart();
                if (cookie.getName().equals("gid")){
                    cart.setGid(Integer.parseInt(cookie.getValue()));
                }
                if (cookie.getName().equals("number")){
                    cart.setNumber(Integer.parseInt(cookie.getValue()));
                }
                cartList.add(cart);
            }
        }else {
            //1.2登录状态下从数据库中查询购物车中的商品信息
            int uid = Integer.parseInt((String) _uid);
            CartService cs = new CartServiceImpl();
            cartList = cs.findByUid(uid);
        }
        System.out.println(cartList);
        outputJson(request, response, cartList);
    }
}
