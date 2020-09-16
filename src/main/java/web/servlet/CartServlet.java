package web.servlet;

import entity.Cart;
import entity.PageBean;
import entity.User;
import org.apache.commons.beanutils.BeanUtils;
import service.CartService;
import service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/cart/*")
public class CartServlet extends BaseServlet {
    //查找购物车中的所有商品
    public void findAll(HttpServletRequest request, HttpServletResponse response){
        //创建cart对象集合
        List<Cart> cartList = new ArrayList<>();
        //1.判断其是否登录
        User user = (User) request.getSession().getAttribute("loginUser");
        System.out.println(user.getUid());
        if (user == null){

        }else {
            //1.2登录状态下从数据库中查询购物车中的商品信息
            int uid = user.getUid();
            CartService cs = new CartServiceImpl();
            cartList = cs.findByUid(uid);
            System.out.println(cartList);
            outputJson(request, response, cartList);
        }


    }
    //清空购物车
    public void clearCart(HttpServletRequest request, HttpServletResponse response){
        //判断其是否登录
        User user = (User) request.getSession().getAttribute("loginUser");
        if (user == null){

        }else {
            int uid = user.getUid();
            CartService cs = new CartServiceImpl();
            cs.deleteCartByUid(uid);
        }


    }
    //添加一种商品
    public void addOne(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        //判断其是否登录
        User user = (User) request.getSession().getAttribute("loginUser");
        if (user == null){

        }else {
            int uid = user.getUid();
            //封装cart对象
            Map<String, String[]> map = request.getParameterMap();
            Cart cart = new Cart();
            BeanUtils.populate(cart, map);
            cart.setUid(uid);
            cart.setUser(user);
            System.out.println(cart);
            CartService cs = new CartServiceImpl();
            //查询cart 如果cart已经存在则number加一 否则在cart表中新增一条记录
            Cart _cart = cs.findCart(cart);
            if (_cart == null){
                cart.setNumber(1);
                cs.insertCart(cart);
            }else {
                cs.addNum(_cart);
            }
        }




    }

    //移除一种商品
    public void removeOne(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        //判断其是否登录
        User user = (User) request.getSession().getAttribute("loginUser");
        if (user == null){

        }else {
            int uid = user.getUid();
            //封装cart对象
            Map<String, String[]> map = request.getParameterMap();
            Cart cart = new Cart();
            BeanUtils.populate(cart, map);
            cart.setUid(uid);
            cart.setUser(user);
            System.out.println(cart);

            //删除购物车记录
            CartService cs = new CartServiceImpl();
            cs.deleteCart(cart);
        }

    }
    //增加商品数量
    public void addNum(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        //判断其是否登录
        User user = (User) request.getSession().getAttribute("loginUser");
        if (user == null){

        }else {
            int uid = user.getUid();
            //封装cart对象
            Map<String, String[]> map = request.getParameterMap();
            Cart cart = new Cart();
            BeanUtils.populate(cart, map);
            cart.setUid(uid);
            cart.setUser(user);
            System.out.println(cart);

            //增加商品数量
            CartService cs = new CartServiceImpl();
            cs.addNum(cart);
        }
    }
    //减少商品数量
    public void reduceNum(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        //判断其是否登录
        User user = (User) request.getSession().getAttribute("loginUser");
        if (user == null){

        }else {
            int uid = user.getUid();
            //封装cart对象
            Map<String, String[]> map = request.getParameterMap();
            Cart cart = new Cart();
            BeanUtils.populate(cart, map);
            cart.setUid(uid);
            cart.setUser(user);
            System.out.println(cart);

            //减少商品数量
            CartService cs = new CartServiceImpl();
            cs.reduceNum(cart);
        }
    }
    //分页
    public void findByPage(HttpServletRequest request, HttpServletResponse response){
        //获取参数
        User user = (User) request.getSession().getAttribute("loginUser");
        if (user == null){
        }else {
            int uid = user.getUid();
            String currentPage = request.getParameter("currentPage");
            String pageSize = request.getParameter("pageSize");

            if (currentPage == null || "".equals(currentPage)){
                currentPage = "1";
            }
            if (pageSize == null || "".equals(pageSize)){
                pageSize = "3";
            }

            //查询当前页相应商品列表
            CartService cs = new CartServiceImpl();
            PageBean<Cart> pageBean = cs.findByPage(uid, Integer.parseInt(currentPage), Integer.parseInt(pageSize));
            System.out.println(pageBean.getList());

            //返回json对象
            outputJson(request,response,pageBean);
        }
    }
}
