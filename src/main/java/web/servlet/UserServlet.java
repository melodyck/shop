package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.ResultInfo;
import entity.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    UserService us = new UserServiceImpl();

    public void checkUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uname = request.getParameter("uname");
        UserService us = new UserServiceImpl();
        boolean flag = us.checkUser(uname);
        ResultInfo info = new ResultInfo();
        info.setFlag(!flag);
        writeVaule(response, info);
    }

    public void checkEmail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        UserService us = new UserServiceImpl();
        boolean flag = us.checkEmail(email);
        ResultInfo info = new ResultInfo();
        info.setFlag(!flag);
        writeVaule(response, info);
    }


    public void register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        boolean flag = us.registUser(user);
        ResultInfo info = new ResultInfo();
        info.setFlag(flag);
        if (!flag) {
            info.setErrorMsg("注册失败");
        } else {
            response.sendRedirect("/shop/ok.html");
        }
        writeVaule(response, info);
    }

    public void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserService us = new UserServiceImpl();
        ResultInfo info = new ResultInfo();
        try {
            User user = us.login(email, password);
            request.getSession().setAttribute("loginUser", user);
            info.setFlag(true);
        } catch (Exception e) {
            info.setFlag(false);
        }
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), info);
    }


    public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        UserService us = new UserServiceImpl();
        boolean flag = us.active(code);
        response.setContentType("text/html;charset=utf-8");
        if (flag) {
            try {
                response.sendRedirect(request.getContextPath() + "/login.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.getWriter().write("激活失败");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void exit(HttpServletRequest request, HttpServletResponse response){
        request.getSession().removeAttribute("loginUser");
        try {
            response.sendRedirect(request.getContextPath()+"/login.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findOne(HttpServletRequest request, HttpServletResponse response){
        User user=(User)request.getSession().getAttribute("loginUser");
        writeVaule(response,user);
    }
}
