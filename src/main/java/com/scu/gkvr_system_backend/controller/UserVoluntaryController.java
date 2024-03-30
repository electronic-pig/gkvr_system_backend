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
    public Result<Map<String, Object>> getVoluntary(@RequestParam String username) {
        Map<String, Object> data = userVoluntaryService.getVoluntary(username);
        if (data != null) {
            return Result.success(data);
        }
        return Result.fail("查询失败");
    }

    @PostMapping("/addVoluntary")
    public Result<Map<String, Object>> addVoluntary(@RequestBody UserVoluntary userVoluntary) {
        Boolean result = userVoluntaryService.addVoluntary(userVoluntary);
        if (result) {
            return Result.success("添加成功");
        }
        return Result.fail("添加失败");
    }

    @PostMapping("/deleteVoluntary")
    public Result<Map<String, Object>> deleteVoluntary(@RequestBody UserVoluntary userVoluntary) {
        Boolean result = userVoluntaryService.deleteVoluntary(userVoluntary);
        if (result) {
            return Result.success("删除成功");
        }
        return Result.fail("删除失败");
    }

}
