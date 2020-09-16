package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.ResultInfo;
import entity.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
//        Set<Map.Entry<String, String[]>> entries = map.entrySet();
//        entries.stream().forEach(entry -> {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        });
        User user = new User();
        UserService us = new UserServiceImpl();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user.getEmail() + user.getPassword() + user.getUname() + user.getSex());
        boolean flag = us.registUser(user);
        System.out.println(flag);
//        if(flag){
//           request.getRequestDispatcher(request.getContextPath()+"/login.html").forward(request,response);
//        }
        ResultInfo info = new ResultInfo();
        info.setFlag(flag);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), info);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
