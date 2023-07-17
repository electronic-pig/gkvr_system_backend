package com.scu.gkvr_system.controller;

import com.scu.common.vo.Result;
import com.scu.gkvr_system.service.IUserVoluntaryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/userVoluntary")
@CrossOrigin
public class UserVoluntaryController {

    @Resource
    private IUserVoluntaryService userVoluntaryService;

//    @PostMapping("/addVoluntary")
//    public Result<Map<String,Object>> addVoluntary(@R){
//        Map<String, Object> data = userVoluntaryService.addVoluntary();
//        if (data != null) {
//            return Result.success("查询成功", data);
//        }
//        return Result.fail(20001, "查询失败");
//    }


}
