package com.scu.gkvr_system.controller;

import com.scu.common.vo.Result;
import com.scu.gkvr_system.entity.ScLiScore;
import com.scu.gkvr_system.entity.SchoolInfo;
import com.scu.gkvr_system.entity.User;
import com.scu.gkvr_system.service.IScLiScoreService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzc
 * @since 2023-07-15
 */
@RestController
@RequestMapping("/scLiScore")
@CrossOrigin
public class ScLiScoreController {

    @Resource
    private IScLiScoreService scLiScoreService;

    @GetMapping("/school")
    public Result<Map<String, Object>> scoreSearchByName(@RequestParam String schoolName) {
//        scLiScoreService.getAllScLiScore();
        Map<String, Object> data = scLiScoreService.scoreSearchByName(schoolName);
        if (data != null) {
            return Result.success("查询成功", data);
        }
        return Result.fail(20001, "查询失败");
    }


}
