package com.scu.gkvr_system.service;

import com.scu.gkvr_system.entity.ScLiScoreNew;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzc
 * @since 2023-07-17
 */
public interface IScLiScoreNewService extends IService<ScLiScoreNew> {
    Map<String, Object> scoreSearchByName(String schoolName);
}
