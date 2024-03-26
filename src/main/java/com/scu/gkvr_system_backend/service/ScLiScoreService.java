package com.scu.gkvr_system_backend.service;

import com.scu.gkvr_system_backend.pojo.ScLiScore;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author Liyang
* @description 针对表【sc_li_score】的数据库操作Service
* @createDate 2024-03-23 16:46:11
*/
public interface ScLiScoreService extends IService<ScLiScore> {

    Map<String, Object> searchByName(String schoolName);
}
