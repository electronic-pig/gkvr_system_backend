package com.scu.gkvr_system.service;

import com.scu.gkvr_system.entity.RecoInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wj
 * @since 2023-07-18
 */
public interface IRecoInfoService extends IService<RecoInfo> {
    List<RecoInfo> completionRecoInfo(List<RecoInfo> list);
}
