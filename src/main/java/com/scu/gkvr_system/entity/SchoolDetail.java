package com.scu.gkvr_system.entity;

import java.util.List;

public class SchoolDetail {
    private SchoolInfo schoolInfo;
    private List<MajorScore> majorScoreList;
    private ScLiScoreNew scLiScoreNew;

    public SchoolDetail(SchoolInfo schoolInfo, List<MajorScore> majorScore) {
        this.schoolInfo = schoolInfo;
        this.majorScoreList = majorScore;
    }

    public SchoolDetail(SchoolInfo schoolInfo, List<MajorScore> majorScoreList, ScLiScoreNew scLiScoreNew) {
        this.schoolInfo = schoolInfo;
        this.majorScoreList = majorScoreList;
        this.scLiScoreNew = scLiScoreNew;
    }

    public SchoolInfo getSchoolInfo() {
        return schoolInfo;
    }

    public void setSchoolInfo(SchoolInfo schoolInfo) {
        this.schoolInfo = schoolInfo;
    }

    public List<MajorScore> getMajorScoreList() {
        return majorScoreList;
    }

    public void setMajorScoreList(List<MajorScore> majorScoreList) {
        this.majorScoreList = majorScoreList;
    }

    public ScLiScoreNew getScLiScoreNew() {
        return scLiScoreNew;
    }

    public void setScLiScore(ScLiScoreNew scLiScoreNew) {
        this.scLiScoreNew = scLiScoreNew;
    }

    @Override
    public String toString() {
        return "SchoolDetail{" +
                "schoolInfo=" + schoolInfo +
                ", majorScoreList=" + majorScoreList +
                ", scLiScoreNew=" + scLiScoreNew +
                '}';
    }
}
