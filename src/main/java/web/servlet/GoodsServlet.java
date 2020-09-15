package web.servlet;

import entity.PageBean;
import entity.goods;
import service.GoodsService;
import service.impl.GoodsServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoodsServlet extends BaseServlet {
    @WebServlet("/goods/*")
    public class RouteServlet extends BaseServlet {
        private GoodsService goodsService = new GoodsServiceImpl();

        public void queryPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
            // 1.接收参数
            String _gid = request.getParameter("gid");
            int cid = Integer.parseInt(_gid);
            String _currentPage = request.getParameter("currentPage");
            // 处理_currentPage
            int currentPage = 1;
            if (_currentPage != null && _currentPage.length() > 0) {
                currentPage = Integer.parseInt(_currentPage);
            }
            String _pageSize = request.getParameter("pageSize");
            // 处理_pageSize
            int pageSize = 8;
            if (_pageSize != null && _pageSize.length() > 0) {
                pageSize = Integer.parseInt(_pageSize);
            }
            // 2.调用service获得pageBean对象
            PageBean<goods> page = goodsService.findByPage(cid, currentPage, pageSize);
            // 3.将结果序列化为json返回
            writeValue(response, page);
        }
    }
}
