package com.scu.gkvr_system_backend.controller;

import com.scu.gkvr_system_backend.pojo.UserVoluntary;
import com.scu.gkvr_system_backend.service.UserVoluntaryService;
import com.scu.gkvr_system_backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zzc
 * @since 2023-07-17
 */
@RestController
@RequestMapping("/userVoluntary")
@CrossOrigin
public class UserVoluntaryController {

    @Autowired
    private UserVoluntaryService userVoluntaryService;

    @GetMapping("/getVoluntary")
    public Result<Map<String, Object>> getVoluntary(@RequestParam String user_name) {
        Map<String, Object> data = userVoluntaryService.getVoluntary(user_name);
        if (data != null) {
            return Result.success("获取成功", data);
        }
        return Result.fail(201, "获取失败");
    }

    @PostMapping("/addVoluntary")
    public Result<Map<String, Object>> addVoluntary(@RequestBody UserVoluntary userVoluntary) {
        Boolean result = userVoluntaryService.addVoluntary(userVoluntary);
        if (result) {
            return Result.success("添加成功");
        }
        return Result.fail(201, "添加失败");
    }

    @PostMapping("/deleteVoluntary")
    public Result<Map<String, Object>> deleteVoluntary(@RequestBody UserVoluntary userVoluntary) {
        Boolean result = userVoluntaryService.deleteVoluntary(userVoluntary);
        if (result) {
            return Result.success("删除成功");
        }
        return Result.fail(201, "删除失败");
    }

}
