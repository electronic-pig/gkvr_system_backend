package com.scu.gkvr_system.controller;

import com.scu.common.vo.Result;
import com.scu.gkvr_system.entity.SchoolInfo;
import com.scu.gkvr_system.entity.User;
import com.scu.gkvr_system.service.ISchoolInfoService;
import com.scu.gkvr_system.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
public class SchoolInfoController {
    @Resource
    private ISchoolInfoService schoolInfoService;

    @GetMapping
    public Result<Map<String, Object>> getSchoolsByPage(@RequestParam("page") int page) {
        schoolInfoService.getAllSchool();//获取全部学校信息
        Map<String, Object> data = schoolInfoService.getSchoolsByPage(page);
        if (data != null) {
            return Result.success("学校信息查询成功", data);
        }
        return Result.fail(20001, "数据为空");
    }
}
