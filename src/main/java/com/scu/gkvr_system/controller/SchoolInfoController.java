package com.scu.gkvr_system.controller;

import com.scu.common.vo.Result;
import com.scu.gkvr_system.entity.SchoolInfo;
import com.scu.gkvr_system.entity.User;
import com.scu.gkvr_system.mapper.SchoolInfoMapper;
import com.scu.gkvr_system.service.ISchoolInfoService;
import com.scu.gkvr_system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author weijia
 * @since 2023-07-15
 */
@RestController
@RequestMapping("/schoolInfo")
@CrossOrigin
public class SchoolInfoController {
    @Resource
    private ISchoolInfoService schoolInfoService;

    @Autowired
    private SchoolInfoMapper schoolInfoMapper;

    @GetMapping
    public Result<Map<String, Object>> getSchoolsByPage(@RequestParam("page") int page) {
        schoolInfoService.getAllSchool();//获取全部学校信息
        Map<String, Object> data = schoolInfoService.getSchoolsByPage(page);
        if (data != null) {
            return Result.success("学校信息查询成功", data);
        }
        return Result.fail(20001, "数据为空");
    }

//    @GetMapping("/985")
//    public Result<Map<String, Object>> get985Schools() {
//        schoolInfoService.getAllSchool();//获取全部学校信息
//        Map<String, Object> data = schoolInfoService.get985Schools();
//        if (data != null) {
//            return Result.success("985类学校信息查询成功", data);
//        }
//        return Result.fail(20001, "数据为空");
//    }

    @GetMapping("/985")
    public Result<Map<String, Object>> get985Schools() {
//        schoolInfoService.getAllSchool();//获取全部学校信息
        Map<String, Object> data = schoolInfoService.get985Schools();
        if (data != null) {
            return Result.success("985类学校信息查询成功", data);
        }
        return Result.fail(20001, "数据为空");
    }

    @GetMapping("/211")
    public Result<Map<String, Object>> get211Schools() {
        schoolInfoService.getAllSchool();//获取全部学校信息
        Map<String, Object> data = schoolInfoService.get211Schools();
        if (data != null) {
            return Result.success("211类学校信息查询成功", data);
        }
        return Result.fail(20001, "数据为空");
    }
}
