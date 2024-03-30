package com.scu.gkvr_system_backend.controller;

import com.scu.gkvr_system_backend.service.ScoreRankService;
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
@RequestMapping("/scoreRank")
@CrossOrigin
public class ScoreRankController {

    @Autowired
    private ScoreRankService scoreRankService;

    @GetMapping("/getRank")
    public Result<Map<String, Object>> getRank(@RequestParam int score) {
        Map<String, Object> data = scoreRankService.getRank(score);
        if (data != null) {
            return Result.success(data);
        }
        return Result.fail("查询失败");
    }

    @GetMapping("/getReco")
    public Result<Map<String, Object>> getReco(@RequestParam int page,
                                               @RequestParam int score,
                                               @RequestParam String risk) {
        Map<String, Object> data = scoreRankService.getReco(page, score, risk);
        if (data != null) {
            return Result.success(data);
        }
        return Result.fail("获取失败");
    }
}
