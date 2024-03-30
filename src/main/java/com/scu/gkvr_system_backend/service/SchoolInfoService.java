package com.scu.gkvr_system_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scu.gkvr_system_backend.pojo.SchoolInfo;

import java.util.Map;

/**
 * @author Liyang
 * @description 针对表【school_info】的数据库操作Service
 * @createDate 2024-03-30 10:58:49
 */
public interface SchoolInfoService extends IService<SchoolInfo> {

    Map<String, Object> getAllSchools(int page);

    Map<String, Object> get985Schools(int page);

    Map<String, Object> get211Schools(int page);

    Map<String, Object> getDoublehighSchools(int page);

    Map<String, Object> getByProvince(int page, String provinceName);

    Map<String, Object> SearchByName(int page, String schoolName);
}
