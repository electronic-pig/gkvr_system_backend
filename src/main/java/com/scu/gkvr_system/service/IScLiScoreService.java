package com.scu.gkvr_system.service;

import com.scu.gkvr_system.entity.ScLiScore;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scu.gkvr_system.entity.SchoolInfo;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzc
 * @since 2023-07-15
 */
public interface IScLiScoreService extends IService<ScLiScore> {
    Map<String, Object> scoreSearchByName(String schoolName);

}
