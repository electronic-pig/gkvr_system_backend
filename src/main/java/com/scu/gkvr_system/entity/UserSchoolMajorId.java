package com.scu.gkvr_system.entity;

public class UserSchoolMajorId {
    String userId;
    String schoolId;
    String majorId;

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

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    @Override
    public String toString() {
        return "UserSchoolMajorId{" +
                "userId='" + userId + '\'' +
                ", schoolId='" + schoolId + '\'' +
                ", majorId='" + majorId + '\'' +
                '}';
    }
}
