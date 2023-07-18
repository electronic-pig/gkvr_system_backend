package com.scu.gkvr_system.service;

import com.scu.gkvr_system.entity.MajorInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liyang
 * @since 2023-07-14
 */
public interface IMajorInfoService extends IService<MajorInfo> {
    Map<String, Object> getAllMajor();

    Map<String, Object> getMajorsByPage(int page);

    Map<String, Object> SearchByName(String majorName);
}
