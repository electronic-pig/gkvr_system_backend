package com.scu.gkvr_system_backend.service;

import com.scu.gkvr_system_backend.pojo.SchoolInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author Liyang
* @description 针对表【school_info】的数据库操作Service
* @createDate 2024-03-23 16:46:11
*/
public interface SchoolInfoService extends IService<SchoolInfo> {

    Map<String, Object> getAllSchools(int page);
    Map<String, Object> get985Schools(int page);

    Map<String, Object> get211Schools(int page);

    Map<String, Object> getDoublehighSchools(int page);

    Map<String, Object> searchSchools(int page, String province_name, String is985, String is211, String doublehigh);

    Map<String, Object> SearchByName(String schoolName, int page);


}
