package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Goods;
import service.GoodsService;
import service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GoodsSearchServlet")
public class GoodsSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("str");
        GoodsService goodsService = new GoodsServiceImpl();
        Goods goods = goodsService.SearchGoods(str);
        ObjectMapper map = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        map.writeValue(response.getOutputStream(), goods);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
