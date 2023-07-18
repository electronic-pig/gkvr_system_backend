package com.scu.gkvr_system.controller;

import com.scu.common.vo.Result;
import com.scu.gkvr_system.service.IMajorInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liyang
 * @since 2023-07-14
 */
@RestController
@RequestMapping("/majorInfo")
@CrossOrigin
public class MajorInfoController {
    @Resource
    private IMajorInfoService majorInfoService;
    @GetMapping
    public Result<Map<String, Object>> getMajorsByPage(@RequestParam("page") int page,@RequestParam String typeId) {
        majorInfoService.getAllMajor();//获取全部学校信息
        Map<String, Object> data = majorInfoService.getMajorsByPage(page,typeId);
        if (data != null) {
            return Result.success("专业信息查询成功", data);
        }
        return Result.fail(20001, "数据为空");
    }

    @GetMapping("/searchByName")//样例：http://localhost:9999/majorInfo/searchByName?majorName=医
    public Result<Map<String, Object>> majorSearchByName(@RequestParam String majorName) {
        Map<String, Object> data = majorInfoService.SearchByName(majorName);
        if (data != null) {
            return Result.success("查询成功", data);
        }
        return Result.fail(20001, "查询失败");
    }

}
