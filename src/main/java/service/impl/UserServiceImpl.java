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

            user.setStatus("N");
            user.setCode(UuidUtil.getUuid());
//            String text = "<a href='http://localhost:80/travel/active?code="+user.getCode()+"'>账号激活</a>";
//            MailUtils.sendMail(user.getEmail(),text,"账号激活邮件");
        int i = ud.registUser(user);
if(i==0){ System.out.println("插入失败");
    return false;
}else{
    System.out.println("插入成功");
    return true;
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

    @Override
    public boolean checkUser(String uname) {
try{
         ud.checkUser(uname);
return false;
}
        catch(Exception e){
    return  true;
        }

    }
}
