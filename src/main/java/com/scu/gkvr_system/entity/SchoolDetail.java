package com.scu.gkvr_system.entity;

import java.util.List;

public class SchoolDetail {
    private SchoolInfo schoolInfo;
    private List<MajorScore> majorScoreList;

    public SchoolDetail(SchoolInfo schoolInfo, List<MajorScore> majorScore) {
        this.schoolInfo = schoolInfo;
        this.majorScoreList = majorScore;
    }

    public SchoolInfo getSchoolInfo() {
        return schoolInfo;
    }

    public void setSchoolInfo(SchoolInfo schoolInfo) {
        this.schoolInfo = schoolInfo;
    }

    public List<MajorScore> getMajorScore() {
        return majorScoreList;
    }

    public void setMajorScore(List<MajorScore> majorScore) {
        this.majorScoreList = majorScore;
    }

    @Override
    public String toString() {
        return "SchoolDetail{" +
                "schoolInfo=" + schoolInfo +
                ", majorScoreList=" + majorScoreList +
                '}';
    }
}
