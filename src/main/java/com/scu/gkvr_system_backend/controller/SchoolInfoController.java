package com.scu.gkvr_system_backend.controller;

import com.scu.gkvr_system_backend.service.SchoolInfoService;
import com.scu.gkvr_system_backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
public class SchoolInfoController {

    @Autowired
    private SchoolInfoService schoolInfoService;

    @GetMapping
    public Result<Map<String, Object>> getSchoolsByPage(@RequestParam("page") int page) {
        schoolInfoService.getAllSchool();//获取全部学校信息
        Map<String, Object> data = schoolInfoService.getSchoolsByPage(page);
        if (data != null) {
            return Result.success("学校信息查询成功", data);
        }
        return Result.fail(201, "数据为空");
    }

    @GetMapping("/search")
    //样例：http://localhost:8080/schoolInfo/search?page=1&province_name=四川&is985=&is211=&doublehigh=
    public Result<Map<String, Object>> searchSchools(@RequestParam("page") int page,
                                                     @RequestParam("province_name") String province_name,
                                                     @RequestParam("is985") String is985,
                                                     @RequestParam("is211") String is211,
                                                     @RequestParam("doublehigh") String doublehigh) {
        Map<String, Object> data = schoolInfoService.searchSchools(page, province_name, is985, is211, doublehigh);
        if (data != null) {
            return Result.success("学校信息查询成功", data);
        }
        return Result.fail(201, "数据为空");
    }

    @GetMapping("/searchByName")
    //样例：http://localhost:8080/schoolInfo/searchByName?schoolName=交通大学
    public Result<Map<String, Object>> scoreSearchByName(@RequestParam String schoolName) {
        Map<String, Object> data = schoolInfoService.SearchByName(schoolName);
        if (data != null) {
            return Result.success("查询成功", data);
        }
        return Result.fail(201, "查询失败");
    }

    @GetMapping("/985")
    public Result<Map<String, Object>> get985Schools() {
        Map<String, Object> data = schoolInfoService.get985Schools();
        if (data != null) {
            return Result.success("985类学校信息查询成功", data);
        }
        return Result.fail(201, "数据为空");
    }

    @GetMapping("/211")
    public Result<Map<String, Object>> get211Schools() {
        Map<String, Object> data = schoolInfoService.get211Schools();
        if (data != null) {
            return Result.success("211类学校信息查询成功", data);
        }
        return Result.fail(201, "数据为空");
    }

    @GetMapping("/doubleHigh")
    public Result<Map<String, Object>> getDoubleHighSchools() {
        Map<String, Object> data = schoolInfoService.getDoubleHighSchools();
        if (data != null) {
            return Result.success("双一流类学校信息查询成功", data);
        }
        return Result.fail(201, "数据为空");
    }

    @GetMapping("/schoolDetail")
    public Result<Map<String, Object>> getSchoolDetail(@RequestParam int schoolId) {
        Map<String, Object> data = schoolInfoService.getSchoolDetail(schoolId);
        if (data != null) {
            return Result.success("查询成功", data);
        }
        return Result.fail(201, "数据为空");
    }
}
