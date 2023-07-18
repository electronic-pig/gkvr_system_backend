package com.scu.gkvr_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.scu.gkvr_system.entity.RecoInfo;
import com.scu.gkvr_system.entity.SchoolInfo;
import com.scu.gkvr_system.mapper.RecoInfoMapper;
import com.scu.gkvr_system.mapper.SchoolInfoMapper;
import com.scu.gkvr_system.service.IRecoInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wj
 * @since 2023-07-18
 */
@Service
public class RecoInfoServiceImpl extends ServiceImpl<RecoInfoMapper, RecoInfo> implements IRecoInfoService {
    @Resource
    SchoolInfoMapper schoolInfoMapper;

    @Override
    public List<RecoInfo> completionRecoInfo(List<RecoInfo> list) {
        for (int i = 0;i<list.size();i++){
            RecoInfo recoInfo = list.get(i);

            LambdaQueryWrapper<SchoolInfo> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(SchoolInfo::getSchoolId,recoInfo.getSchoolId());
            SchoolInfo schoolInfo = schoolInfoMapper.selectOne(queryWrapper);

            recoInfo.setSchoolName(schoolInfo.getSchoolName());
            recoInfo.setProvinceName(schoolInfo.getProvinceName());
            recoInfo.setIs985(schoolInfo.getIs985());
            recoInfo.setIs211(schoolInfo.getIs211());
            recoInfo.setIsDoublehigh(schoolInfo.getDoublehigh());

            list.set(i,recoInfo);
        }
        return list;
    }
}
