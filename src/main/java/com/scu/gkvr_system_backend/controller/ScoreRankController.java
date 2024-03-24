package com.scu.gkvr_system_backend.controller;

import com.scu.gkvr_system_backend.service.ScoreRankService;
import com.scu.gkvr_system_backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/scoreRank")
@CrossOrigin
public class ScoreRankController {

    @Autowired
    private ScoreRankService scoreRankService;

    @GetMapping("/getReco")
    public Result<Map<String, Object>> getReco(int page, String provinceName, String is985, String is211, String isDoublehigh,
                                               String isRisk, String isStable, String isEasy, String score) {

        Map<String, Object> data = scoreRankService.getReco(page, provinceName, is985, is211, isDoublehigh,
                isRisk, isStable, isEasy, score);
        if (data != null) {
            return Result.success("获取成功", data);
        }
        return Result.fail(20001, "添加失败");
    }
}
