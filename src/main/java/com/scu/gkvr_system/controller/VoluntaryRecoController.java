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

    @PostMapping("/getReco")
    public Result<Map<String,Object>> getReco(@RequestBody(required = false)  VoluntaryReco voluntaryReco){
        if (voluntaryReco == null) {
            // 处理空参数的情况，例如返回默认值或执行其他逻辑
            return Result.fail(20001, "参数为空");
        }

        Map<String, Object> data = userVoluntaryService.getReco(voluntaryReco);
        if (data!= null) {
            return Result.success("获取成功",data);
        }
        return Result.fail(20001, "添加失败");
    }

}
