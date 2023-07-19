package com.scu.gkvr_system.entity;

public class UserVoluntaryNew {
    private String userId;

    private String schoolId;

    private String majorIdA;

    private String majorIdB;

    private String majorIdC;

    private String majorIdD;

    private String majorIdE;

    private String majorIdF;

    private int count;
    private String schoolName;

    public UserVoluntaryNew() {
    }

    public UserVoluntaryNew(String userId, String schoolId, String majorIdA, int count) {
        this.userId = userId;
        this.schoolId = schoolId;
        this.majorIdA = majorIdA;
        this.count = count;
    }

    public UserVoluntaryNew(String userId, String schoolId) {
        this.userId = userId;
        this.schoolId = schoolId;
    }

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
    public String getMajorIdA() {
        return majorIdA;
    }

    public void setMajorIdA(String majorIdA) {
        this.majorIdA = majorIdA;
    }
    public String getMajorIdB() {
        return majorIdB;
    }

    public void setMajorIdB(String majorIdB) {
        this.majorIdB = majorIdB;
    }
    public String getMajorIdC() {
        return majorIdC;
    }

    public void setMajorIdC(String majorIdC) {
        this.majorIdC = majorIdC;
    }
    public String getMajorIdD() {
        return majorIdD;
    }

    public void setMajorIdD(String majorIdD) {
        this.majorIdD = majorIdD;
    }
    public String getMajorIdE() {
        return majorIdE;
    }

    public void setMajorIdE(String majorIdE) {
        this.majorIdE = majorIdE;
    }
    public String getMajorIdF() {
        return majorIdF;
    }

    public void setMajorIdF(String majorIdF) {
        this.majorIdF = majorIdF;
    }

    public int getCount() {
        return count;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public void clone(UserVoluntary userVoluntary){
        this.setUserId(userVoluntary.getUserId());
        this.setSchoolId(userVoluntary.getSchoolId());
        this.setMajorIdA(userVoluntary.getMajorIdA());
        this.setMajorIdB(userVoluntary.getMajorIdB());
        this.setMajorIdC(userVoluntary.getMajorIdC());
        this.setMajorIdD(userVoluntary.getMajorIdD());
        this.setMajorIdE(userVoluntary.getMajorIdE());
        this.setMajorIdF(userVoluntary.getMajorIdF());
        this.setCount(userVoluntary.getCount());

    }

    @Override
    public String toString() {
        return "UserVoluntaryNew{" +
                "userId='" + userId + '\'' +
                ", schoolId='" + schoolId + '\'' +
                ", majorIdA='" + majorIdA + '\'' +
                ", majorIdB='" + majorIdB + '\'' +
                ", majorIdC='" + majorIdC + '\'' +
                ", majorIdD='" + majorIdD + '\'' +
                ", majorIdE='" + majorIdE + '\'' +
                ", majorIdF='" + majorIdF + '\'' +
                ", count=" + count +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}
