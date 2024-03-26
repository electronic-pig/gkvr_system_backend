package com.scu.gkvr_system_backend.controller;

import com.scu.gkvr_system_backend.service.MajorInfoService;
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
@RequestMapping("/majorInfo")
@CrossOrigin
public class MajorInfoController {

    @Autowired
    private MajorInfoService majorInfoService;

    @GetMapping("/getSortedMajors")
    public Result<Map<String, Object>> getSortedMajors(@RequestParam int page, @RequestParam String type) {
        Map<String, Object> data = majorInfoService.getSortedMajors(page, type);
        if (data != null) {
            return Result.success("专业信息查询成功", data);
        }
        return Result.fail(201, "数据为空");
    }

    @GetMapping("/searchByName")
    //样例：http://localhost:8080/majorInfo/searchByName?majorName=医
    public Result<Map<String, Object>> majorSearchByName(@RequestParam int page, @RequestParam String majorName) {
        Map<String, Object> data = majorInfoService.SearchByName(page, majorName);
        if (data != null) {
            return Result.success("查询成功", data);
        }
        return Result.fail(201, "查询失败");
    }
}
