package com.scu.gkvr_system_backend.controller;

import com.scu.gkvr_system_backend.service.SchoolInfoService;
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
@RequestMapping("/schoolInfo")
@CrossOrigin
public class SchoolInfoController {

    @Autowired
    private SchoolInfoService schoolInfoService;

    @GetMapping("/all")
    public Result<Map<String, Object>> getAllSchools(@RequestParam int page) {
        Map<String, Object> data = schoolInfoService.getAllSchools(page);
        if (data != null) {
            return Result.success("查询成功", data);
        }
        return Result.fail(201, "查询失败");
    }

    @GetMapping("/985")
    public Result<Map<String, Object>> get985Schools(@RequestParam int page) {
        Map<String, Object> data = schoolInfoService.get985Schools(page);
        if (data != null) {
            return Result.success("985类学校信息查询成功", data);
        }
        return Result.fail(201, "查询失败");
    }

    @GetMapping("/211")
    public Result<Map<String, Object>> get211Schools(@RequestParam int page) {
        Map<String, Object> data = schoolInfoService.get211Schools(page);
        if (data != null) {
            return Result.success("211类学校信息查询成功", data);
        }
        return Result.fail(201, "查询失败");
    }

    @GetMapping("/doublehigh")
    public Result<Map<String, Object>> getDoublehighSchools(@RequestParam int page) {
        Map<String, Object> data = schoolInfoService.getDoublehighSchools(page);
        if (data != null) {
            return Result.success("双一流类学校信息查询成功", data);
        }
        return Result.fail(201, "查询失败");
    }

    @GetMapping("/province")
    //样例：http://localhost:8080/schoolInfo/search?page=1&province_name=四川
    public Result<Map<String, Object>> searchSchools(@RequestParam int page,
                                                     @RequestParam String province_name) {
        Map<String, Object> data = schoolInfoService.getByProvince(page, province_name);
        if (data != null) {
            return Result.success("查询成功", data);
        }
        return Result.fail(201, "查询失败");
    }

    @GetMapping("/searchByName")
    //样例：http://localhost:8080/schoolInfo/searchByName?schoolName=交通大学
    public Result<Map<String, Object>> searchByName(@RequestParam int page, @RequestParam String schoolName) {
        Map<String, Object> data = schoolInfoService.SearchByName(page, schoolName);
        if (data != null) {
            return Result.success("查询成功", data);
        }
        return Result.fail(201, "查询失败");
    }


}
