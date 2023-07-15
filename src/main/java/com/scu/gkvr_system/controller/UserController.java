package com.scu.gkvr_system.controller;

import com.scu.common.vo.Result;
import com.scu.gkvr_system.entity.User;
import com.scu.gkvr_system.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    @Resource
    private IUserService userService;

    @PostMapping("/login")
    public Result<Map<String, Object>> login(@RequestBody User user) {
        Map<String, Object> data = userService.login(user);
        if (data != null) {
            return Result.success("登录成功", data);
        }
        return Result.fail(20001, "用户名或密码错误");
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        Boolean result = userService.register(user);
        if (!result) {
            return Result.fail("用户已存在");
        }
        return Result.success("注册成功");
    }
}
