package com.scu.gkvr_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.scu.gkvr_system.entity.UserVoluntary;
import com.scu.gkvr_system.mapper.UserVoluntaryMapper;
import com.scu.gkvr_system.service.IUserVoluntaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzc
 * @since 2023-07-17
 */
@Service
public class UserVoluntaryServiceImpl extends ServiceImpl<UserVoluntaryMapper, UserVoluntary> implements IUserVoluntaryService {
    @Resource
    UserVoluntaryMapper userVoluntaryMapper;
    @Override
    public String addVoluntary(String userId, String schoolId, String majorId) {

        LambdaQueryWrapper<UserVoluntary> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserVoluntary::getUserId, userId);
        wrapper.eq(UserVoluntary::getSchoolId, schoolId);
        List<UserVoluntary> userVoluntaryList = this.baseMapper.selectList(wrapper);

        if (!(majorId.equals("")||majorId==null)) {
//      只查到一条数据
            if (userVoluntaryList.size() == 1) {
                UserVoluntary userVoluntary = userVoluntaryList.get(0);
                if (!(majorId.equals(userVoluntary.getMajorIdA()) ||
                        majorId.equals(userVoluntary.getMajorIdB()) ||
                        majorId.equals(userVoluntary.getMajorIdC()) ||
                        majorId.equals(userVoluntary.getMajorIdD()) ||
                        majorId.equals(userVoluntary.getMajorIdE()) ||
                        majorId.equals(userVoluntary.getMajorIdF()))) {
                    UserVoluntary newUserVoluntary = new UserVoluntary();
                    newUserVoluntary.setUserId(userId);
                    newUserVoluntary.setSchoolId(schoolId);
                    UpdateWrapper<UserVoluntary> updateWrapper = new UpdateWrapper<>();
                    updateWrapper.eq("user_id", userId);
                    updateWrapper.eq("school_id", schoolId);
                    if (userVoluntary.getCount() == 6) {
                        return "添加失败，该表格已满！";
                    }
                    if (userVoluntary.getMajorIdA() == null || userVoluntary.getMajorIdA().equals("")) {
                        newUserVoluntary.setMajorIdA(majorId);
                        newUserVoluntary.setCount(userVoluntary.getCount() + 1);
                        userVoluntaryMapper.update(newUserVoluntary, updateWrapper);
                        return "添加成功！";
                    }
                    if (userVoluntary.getMajorIdB() == null || userVoluntary.getMajorIdB().equals("")) {
                        newUserVoluntary.setMajorIdB(majorId);
                        newUserVoluntary.setCount(userVoluntary.getCount() + 1);
                        userVoluntaryMapper.update(newUserVoluntary, updateWrapper);
                        return "添加成功！";
                    }
                    if (userVoluntary.getMajorIdC() == null || userVoluntary.getMajorIdC().equals("")) {
                        newUserVoluntary.setMajorIdC(majorId);
                        newUserVoluntary.setCount(userVoluntary.getCount() + 1);
                        userVoluntaryMapper.update(newUserVoluntary, updateWrapper);
                        return "添加成功！";
                    }
                    if (userVoluntary.getMajorIdD() == null || userVoluntary.getMajorIdD().equals("")) {
                        newUserVoluntary.setMajorIdD(majorId);
                        newUserVoluntary.setCount(userVoluntary.getCount() + 1);
                        userVoluntaryMapper.update(newUserVoluntary, updateWrapper);
                        return "添加成功！";
                    }
                    if (userVoluntary.getMajorIdE() == null || userVoluntary.getMajorIdE().equals("")) {
                        newUserVoluntary.setMajorIdE(majorId);
                        newUserVoluntary.setCount(userVoluntary.getCount() + 1);
                        userVoluntaryMapper.update(newUserVoluntary, updateWrapper);
                        return "添加成功！";
                    }
                    if (userVoluntary.getMajorIdF() == null || userVoluntary.getMajorIdF().equals("")) {
                        newUserVoluntary.setMajorIdF(majorId);
                        newUserVoluntary.setCount(userVoluntary.getCount() + 1);
                        userVoluntaryMapper.update(newUserVoluntary, updateWrapper);
                        return "添加成功！";
                    }
                } else {
                    return "添加失败，已添加过！";
                }
            } else if (userVoluntaryList.size() == 0) {
                UserVoluntary userVoluntary = new UserVoluntary(userId, schoolId, majorId, 1);
                int rowsAffected = this.baseMapper.insert(userVoluntary);
//              插入成功
                if (rowsAffected > 0) {
                    return "添加成功！";
                }
//              插入失败
                else {
                    return "添加失败，未能正确插入数据！";
                }
            }
            return "添加失败，数据库中有多条数据！";
        }
        else {
            if (userVoluntaryList.size()==1){
                return "添加失败，请给出majorId！";
            }
            else if (userVoluntaryList.size()==0) {
                this.baseMapper.insert(new UserVoluntary(userId,schoolId));
                return "添加成功！";
            }
            else {
                return "添加失败，数据库中有多条数据！";
            }
        }
    }

    @Override
    public String deleteVoluntary(String userId, String schoolId, String majorId) {
        LambdaQueryWrapper<UserVoluntary> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserVoluntary::getUserId, userId);
        wrapper.eq(UserVoluntary::getSchoolId, schoolId);
        List<UserVoluntary> userVoluntaryList = this.baseMapper.selectList(wrapper);
        if (!(majorId==null||majorId.equals(""))) {
//      只查到一条数据
            if (userVoluntaryList.size() == 1) {
                UserVoluntary userVoluntary = userVoluntaryList.get(0);
                UserVoluntary newUserVoluntary = new UserVoluntary();
                UpdateWrapper<UserVoluntary> updateWrapper = new UpdateWrapper<>();
                updateWrapper.eq("user_id", userId);
                updateWrapper.eq("school_id", schoolId);
                if (userVoluntary.getMajorIdA().equals(majorId)) {
                    newUserVoluntary.setMajorIdA("");
                    newUserVoluntary.setCount(userVoluntary.getCount() - 1);
                    userVoluntaryMapper.update(newUserVoluntary, updateWrapper);
                    return "删除成功！";
                }
                if (userVoluntary.getMajorIdB().equals(majorId)) {
                    newUserVoluntary.setMajorIdB("");
                    newUserVoluntary.setCount(userVoluntary.getCount() - 1);
                    userVoluntaryMapper.update(newUserVoluntary, updateWrapper);
                    return "删除成功！";
                }
                if (userVoluntary.getMajorIdC().equals(majorId)) {
                    newUserVoluntary.setMajorIdC("");
                    newUserVoluntary.setCount(userVoluntary.getCount() - 1);
                    userVoluntaryMapper.update(newUserVoluntary, updateWrapper);
                    return "删除成功！";
                }
                if (userVoluntary.getMajorIdD().equals(majorId)) {
                    newUserVoluntary.setMajorIdD("");
                    newUserVoluntary.setCount(userVoluntary.getCount() - 1);
                    userVoluntaryMapper.update(newUserVoluntary, updateWrapper);
                    return "删除成功！";
                }
                if (userVoluntary.getMajorIdE().equals(majorId)) {
                    newUserVoluntary.setMajorIdE("");
                    newUserVoluntary.setCount(userVoluntary.getCount() - 1);
                    userVoluntaryMapper.update(newUserVoluntary, updateWrapper);
                    return "删除成功！";
                }
                if (userVoluntary.getMajorIdF().equals(majorId)) {
                    newUserVoluntary.setMajorIdF("");
                    newUserVoluntary.setCount(userVoluntary.getCount() - 1);
                    userVoluntaryMapper.update(newUserVoluntary, updateWrapper);
                    return "删除成功！";
                }
                return "删除失败，未找到对应记录！";
            } else if (userVoluntaryList.size() == 0) {
                return "删除失败，不存在该表单！";
            }
            return "删除失败，数据库中有多条数据！";
        }
        else {
            if (userVoluntaryList.size()==1){
                this.baseMapper.delete(wrapper);
                return "删除成功！";
            }
            else if (userVoluntaryList.size()==0) {
                return "删除失败，不存在该表单！";
            }
            else {
                return "删除失败，数据库中有多条数据！";
            }
        }
    }
}
