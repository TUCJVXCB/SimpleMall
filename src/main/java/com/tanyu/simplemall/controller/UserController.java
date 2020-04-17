package com.tanyu.simplemall.controller;

import com.tanyu.simplemall.VO.LoginVO;
import com.tanyu.simplemall.result.CodeMsg;
import com.tanyu.simplemall.result.Result;
import com.tanyu.simplemall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/to_login")
    public String login() {
        return "login";
    }

    @PostMapping("/do_login")
    @ResponseBody
    public Result<String> dologin(HttpServletResponse response, @Valid LoginVO loginVO) {
        logger.info(loginVO.toString());

        String token = userService.login(response, loginVO);
        return Result.success(token);
    }
}
