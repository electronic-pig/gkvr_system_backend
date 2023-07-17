package com.scu.gkvr_system.controller;

import com.scu.common.vo.Result;
import com.scu.gkvr_system.service.IScLiScoreNewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzc
 * @since 2023-07-17
 */
@RestController
@RequestMapping("/scLiScore")
public class ScLiScoreNewController {
    @Resource
    private IScLiScoreNewService scLiScoreNewService;

    @GetMapping("/school")
    public Result<Map<String, Object>> scoreSearchByName(@RequestParam String schoolName) {
        Map<String, Object> data = scLiScoreNewService.scoreSearchByName(schoolName);
        if (data != null) {
            return Result.success("查询成功", data);
        }
        return Result.fail(20001, "查询失败");
    }
}
