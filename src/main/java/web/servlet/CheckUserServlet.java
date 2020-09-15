package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.ResultInfo;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkUser")
public class CheckUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        UserService us=new UserServiceImpl();
        boolean flag = us.checkUser(uname);
        ResultInfo info =new ResultInfo();
        info.setFlag(flag);
        ObjectMapper mapper=new ObjectMapper();
        response.setCharacterEncoding("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
