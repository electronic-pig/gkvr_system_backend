package com.scu.gkvr_system.service;

import com.scu.gkvr_system.entity.SchoolInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scu.gkvr_system.entity.User;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author weijia
 * @since 2023-07-15
 */
public interface ISchoolInfoService extends IService<SchoolInfo> {
    Map<String, Object> getAllSchool();

    Map<String, Object> getSchoolsByPage(int page);

    Map<String, Object> searchSchools(int page, String province, String schoolTypeMark, String ownerMark,
                                      String is985, String is211, String doublehighMark);
    Map<String, Object> searchSchoolsAndScore(int page, String province, String schoolTypeMark, String ownerMark,
                                      String is985, String is211, String doublehighMark);

    Map<String, Object> SearchByName(String schoolName);
    Map<String, Object> get985Schools();

    Map<String, Object> get211Schools();

    Map<String, Object> getDoubleHighSchools();



}
