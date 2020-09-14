package service.impl;

import dao.UserDao;

import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;
import util.MailUtils;
import util.UuidUtil;

public class UserServiceImpl implements UserService {
    UserDao ud =new UserDaoImpl();
    public boolean registUser(User user){
        try{
            user.setStatus("N");
            user.setCode(UuidUtil.getUuid());
//            String text = "<a href='http://localhost:80/travel/active?code="+user.getCode()+"'>账号激活</a>";
//            MailUtils.sendMail(user.getEmail(),text,"账号激活邮件");
        ud.registUser(user);
        return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public User login(String email,String password) {
        User resultUser = ud.findUserByEmailAndPassword(email, password);
        if (resultUser == null) {
            //用户不存在
            return null;
        } else if (resultUser.getStatus().equals("N")) {
            //未激活
            return null;
        } else {
           return resultUser;
        }

    }
}
