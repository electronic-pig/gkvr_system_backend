package com.scu.gkvr_system.controller;

import com.scu.common.vo.Result;
import com.scu.gkvr_system.service.IScLiScoreService;
import com.scu.gkvr_system.service.ISchoolDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/schoolDetail")
@CrossOrigin
public class SchoolDetailController {
    @Resource
    private ISchoolDetailService schoolDetailService;

    @GetMapping
    public Result<Map<String, Object>> getSchoolDetail(@RequestParam String schoolId) {
        Map<String, Object> data = schoolDetailService.getSchoolDetail(schoolId);
        if (data != null) {
            return Result.success("查询成功", data);
        }
        return Result.fail(20001, "数据为空");
    }
}
