package com.scu.gkvr_system.controller;

import com.scu.common.vo.Result;
import com.scu.gkvr_system.entity.UserSchoolMajorId;
import com.scu.gkvr_system.entity.VoluntaryReco;
import com.scu.gkvr_system.service.IVoluntaryRecoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wj
 * @since 2023-07-17
 */
@RestController
@RequestMapping("/voluntaryReco")
@CrossOrigin
public class VoluntaryRecoController {
    @Resource
    private IVoluntaryRecoService userVoluntaryService;

    @GetMapping("/getReco")
    public Result<Map<String,Object>> getReco(int page,String provinceName,String is985,String is211,String isDoublehigh,
                                              String isRisk,String isStable,String isEasy,String score){

        Map<String, Object> data = userVoluntaryService.getReco( page, provinceName, is985, is211, isDoublehigh,
                 isRisk, isStable, isEasy, score);
        if (data!= null) {
            return Result.success("获取成功",data);
        }
        return Result.fail(20001, "添加失败");
    }

}
