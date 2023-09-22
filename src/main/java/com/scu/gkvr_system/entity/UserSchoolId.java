package com.scu.gkvr_system.entity;

import com.baomidou.mybatisplus.annotation.TableId;

public class UserSchoolId {
    @TableId
    String userId;
    String schoolId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public String toString() {
        return "UserSchoolId{" +
                "userId='" + userId + '\'' +
                ", schoolId='" + schoolId + '\'' +
                '}';
    }
}
