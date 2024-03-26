package com.scu.gkvr_system_backend.controller;

import com.scu.gkvr_system_backend.service.SchoolInfoDetailService;
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
@RequestMapping("/schoolInfoDetail")
@CrossOrigin
public class SchoolInfoDetailController {

    @Autowired
    SchoolInfoDetailService schoolInfoDetailService;

    @GetMapping
    public Result<Map<String, Object>> getSchoolDetail(@RequestParam int schoolId) {
        Map<String, Object> data = schoolInfoDetailService.getSchoolDetail(schoolId);
        if (data != null) {
            return Result.success("查询成功", data);
        }
        return Result.fail(201, "数据为空");
    }
}
