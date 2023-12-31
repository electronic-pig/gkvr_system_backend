package com.scu.gkvr_system.controller;

import com.scu.common.vo.Result;
import com.scu.gkvr_system.service.ISchoolInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author weijia
 * @since 2023-07-15
 */
@RestController
@RequestMapping("/schoolInfo")
@CrossOrigin
public class SchoolInfoController {
    @Resource
    private ISchoolInfoService schoolInfoService;

    @GetMapping
    public Result<Map<String, Object>> getSchoolsByPage(@RequestParam("page") int page) {
        schoolInfoService.getAllSchool();//获取全部学校信息
        Map<String, Object> data = schoolInfoService.getSchoolsByPage(page);
        if (data != null) {
            return Result.success("学校信息查询成功", data);
        }
        return Result.fail(20001, "数据为空");
    }
    @GetMapping("/search")//样例：http://localhost:9999/schoolInfo/search?page=1&province_id=51&school_type_mark=&owner_mark=&is985=&is211=&doublehigh_mark=
    public Result<Map<String, Object>> searchSchools(@RequestParam("page") int page,
                                                  @RequestParam("province_name") String province,
                                                  @RequestParam("school_type_mark") String schoolTypeMark,
                                                  @RequestParam("owner_mark") String ownerMark,
                                                  @RequestParam("is985") String is985,
                                                  @RequestParam("is211") String is211,
                                                  @RequestParam("doublehigh_mark") String doublehighMark) {
        Map<String, Object> data = schoolInfoService.searchSchools(page,province,schoolTypeMark,ownerMark,is985,is211,doublehighMark);
        if (data != null) {
            return Result.success("学校信息查询成功", data);
        }
        return Result.fail(20001, "数据为空");
    }
    @GetMapping("/searchAndScore")//样例：http://localhost:9999/schoolInfo/search?page=1&province_id=51&school_type_mark=&owner_mark=&is985=&is211=&doublehigh_mark=
    public Result<Map<String, Object>> searchSchoolsAndScore(@RequestParam("page") int page,
                                                     @RequestParam("province_name") String province,
                                                     @RequestParam("school_type_mark") String schoolTypeMark,
                                                     @RequestParam("owner_mark") String ownerMark,
                                                     @RequestParam("is985") String is985,
                                                     @RequestParam("is211") String is211,
                                                     @RequestParam("doublehigh_mark") String doublehighMark) {
        Map<String, Object> data = schoolInfoService.searchSchoolsAndScore(page,province,schoolTypeMark,ownerMark,is985,is211,doublehighMark);
        if (data != null) {
            return Result.success("学校信息查询成功", data);
        }
        return Result.fail(20001, "数据为空");
    }

    @GetMapping("/searchByName")//样例：http://localhost:9999/schoolInfo/searchByName?schoolName=交通大学
    public Result<Map<String, Object>> scoreSearchByName(@RequestParam String schoolName) {
//        scLiScoreService.getAllScLiScore();
        Map<String, Object> data = schoolInfoService.SearchByName(schoolName);
        if (data != null) {
            return Result.success("查询成功", data);
        }
        return Result.fail(20001, "查询失败");
    }

    @GetMapping("/985")
    public Result<Map<String, Object>> get985Schools() {
        Map<String, Object> data = schoolInfoService.get985Schools();
        if (data != null) {
            return Result.success("985类学校信息查询成功", data);
        }
        return Result.fail(20001, "数据为空");
    }

    @GetMapping("/211")
    public Result<Map<String, Object>> get211Schools() {
        Map<String, Object> data = schoolInfoService.get211Schools();
        if (data != null) {
            return Result.success("211类学校信息查询成功", data);
        }
        return Result.fail(20001, "数据为空");
    }

    @GetMapping("/doubleHigh")
    public Result<Map<String, Object>> getDoubleHighSchools() {
        Map<String, Object> data = schoolInfoService.get211Schools();
        if (data != null) {
            return Result.success("双一流类学校信息查询成功", data);
        }
        return Result.fail(20001, "数据为空");
    }
}
