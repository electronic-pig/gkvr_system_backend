package com.scu.gkvr_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scu.gkvr_system.entity.SchoolDetail;

import java.util.Map;

public interface ISchoolDetailService extends IService<SchoolDetail> {
    Map<String, Object> getSchoolDetail(String schoolId);
}
