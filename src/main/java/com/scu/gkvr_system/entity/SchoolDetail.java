package com.scu.gkvr_system.entity;

public class SchoolDetail {
    private SchoolInfo schoolInfo;
    private MajorScore majorScore;

    public SchoolDetail(SchoolInfo schoolInfo, MajorScore majorScore) {
        this.schoolInfo = schoolInfo;
        this.majorScore = majorScore;
    }

    public SchoolInfo getSchoolInfo() {
        return schoolInfo;
    }

    public void setSchoolInfo(SchoolInfo schoolInfo) {
        this.schoolInfo = schoolInfo;
    }

    public MajorScore getMajorScore() {
        return majorScore;
    }

    public void setMajorScore(MajorScore majorScore) {
        this.majorScore = majorScore;
    }

    @Override
    public String toString() {
        return "SchoolDetail{" +
                "schoolInfo=" + schoolInfo +
                ", majorScore=" + majorScore +
                '}';
    }
}
