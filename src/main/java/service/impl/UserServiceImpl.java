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
        try {
            // 设置账号未激活N - 激活Y
            user.setStatus("N");
            // 设置唯一的code
            user.setCode(UuidUtil.getUuid());
            // 保存这个账号信息
            ud.registUser(user);
            // 发送激活邮件
            String text = "<a href='http://localhost:80/shop/user/active?code=" + user.getCode() + "'>账号激活</a>";
            MailUtils.sendMail(user.getEmail(), text, "指针旅游网账号激活");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
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
        try {
            ud.checkUser(uname);
            return true;
        } catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean checkEmail(String email) {
        try {
            ud.checkEmail(email);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean active(String code) {
        int count = ud.updateUserStatus(code);
        return count!=0;
    }


}
