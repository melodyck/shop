package service.impl;

import dao.UserDao;

import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;
import util.MailUtils;
import util.UuidUtil;

public class UserServiceImpl implements UserService {
    UserDao ud = new UserDaoImpl();

    public boolean registUser(User user) {
        user.setStatus("N");
        user.setCode(UuidUtil.getUuid());
        String text = "<a href='http://localhost:80/shop/active?code=" + user.getCode() + "'>账号激活</a>";
        MailUtils.sendMail(user.getEmail(), text, "账号激活邮件");
        try {
            ud.registUser(user);
            return true;
        } catch (Exception e) {
            //System.out.println("插入出错了");
            return false;
        }

    }

    @Override
    public User login(String email, String password) throws Exception {
            User resultUser = ud.findUserByEmailAndPassword(email, password);

        if (resultUser == null) {
            //用户不存在
           throw new Exception("用户不存在");
        } else if (resultUser.getStatus().equals("N")) {
            //未激活
            throw new Exception("账户未激活");
        } else {
            return resultUser;
        }

    }

    @Override
    public boolean checkUser(String uname) {

        return  ud.checkUser(uname);

    }

    @Override
    public boolean checkEmail(String email) {

        return ud.checkEmail(email);

    }

    @Override
    public boolean active(String code) {
        int i = ud.updateUserStatus(code);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }


}
