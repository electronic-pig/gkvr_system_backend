package com.scu.gkvr_system_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scu.gkvr_system_backend.pojo.MajorInfo;

import java.util.Map;

/**
 * @author Liyang
 * @description 针对表【major_info】的数据库操作Service
 * @createDate 2024-03-23 16:46:11
 */
public interface MajorInfoService extends IService<MajorInfo> {

    Map<String, Object> getSortedMajors(int page, String type);

    Map<String, Object> SearchByName(int page, String majorName);
}
