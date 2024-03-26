package com.scu.gkvr_system_backend.controller;

import com.scu.gkvr_system_backend.service.ScLiScoreService;
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
@RequestMapping("/scLiScore")
@CrossOrigin
public class ScLiScoreController {

    @Autowired
    private ScLiScoreService scLiScoreService;

    @GetMapping("/school")
    public Result<Map<String, Object>> searchByName(@RequestParam String schoolName) {
        Map<String, Object> data = scLiScoreService.searchByName(schoolName);
        if (data != null) {
            return Result.success("查询成功", data);
        }
        return Result.fail(201, "查询失败");
    }
}
