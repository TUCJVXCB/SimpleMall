package com.tanyu.simplemall.service;

import com.tanyu.simplemall.DAO.UserDAO;
import com.tanyu.simplemall.VO.LoginVO;
import com.tanyu.simplemall.entity.User;
import com.tanyu.simplemall.exception.GlobalException;
import com.tanyu.simplemall.redis.RedisService;
import com.tanyu.simplemall.redis.key.UserKey;
import com.tanyu.simplemall.result.CodeMsg;
import com.tanyu.simplemall.utils.MDUtils;
import com.tanyu.simplemall.utils.Object2String;
import com.tanyu.simplemall.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

@Service
public class UserService {

    public static final String TOKEN = "token";

    @Autowired
    private RedisService redisService;

    @Autowired
    private UserDAO userDao;

    public User getByToken(HttpServletResponse response, String token) {
        User user = redisService.get(UserKey.token, token, User.class);
        return user;
    }

    public User getById(long id) {
        User user = redisService.get(UserKey.getById, "" + id, User.class);
        if (user != null) {
            return user;
        }
        user = userDao.getUserById(id);
        if (user != null) {
            redisService.set(UserKey.getById, "" + id, user);
        }
        return user;
    }

    public String login(HttpServletResponse response, LoginVO loginVO) {
        if (loginVO == null) {
            return null;
        }
        String mobile = loginVO.getMobile();
        String formPass = loginVO.getPassword();

        User user = getById(Long.parseLong(mobile));
        if (user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        String DBPass = user.getPassword();
        String DBSalt = user.getSalt();

        if (!DBPass.equals(MDUtils.formPass2DBPass(formPass, DBSalt))) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }

        String token = UUIDUtils.uuid();
        addCookie(response, token, user);
        return token;
    }

    public void addCookie(HttpServletResponse response, String token, User user) {
        redisService.set(UserKey.token, token, user);
        Cookie cookie = new Cookie(TOKEN, token);
        cookie.setPath("/");
        cookie.setMaxAge(UserKey.token.expireSeconds());
        response.addCookie(cookie);
    }

}
