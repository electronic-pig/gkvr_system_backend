package com.scu.gkvr_system_backend.controller;

import com.scu.gkvr_system_backend.pojo.User;
import com.scu.gkvr_system_backend.service.UserService;
import com.scu.gkvr_system_backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author liyang
 * @since 2023-07-14
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result<Map<String, Object>> login(@RequestBody User user) {
        Map<String, Object> data = userService.login(user);
        if (data != null) {
            return Result.success(data);
        }
        return Result.fail("用户名或密码错误");
    }

    @PostMapping("/register")
    public Result<Map<String, Object>> register(@RequestBody User user) {
        Boolean result = userService.register(user);
        if (result) {
            return Result.success("注册成功！");
        }
        return Result.fail("用户已存在");
    }
}
