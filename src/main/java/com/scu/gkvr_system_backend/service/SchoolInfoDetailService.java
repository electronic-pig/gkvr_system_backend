package com.scu.gkvr_system_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scu.gkvr_system_backend.pojo.SchoolInfoDetail;

import java.util.Map;

/**
 * @author Liyang
 * @description 针对表【school_info_detail】的数据库操作Service
 * @createDate 2024-03-23 16:46:11
 */
public interface SchoolInfoDetailService extends IService<SchoolInfoDetail> {
    Map<String, Object> getSchoolDetail(int schoolId);
}
