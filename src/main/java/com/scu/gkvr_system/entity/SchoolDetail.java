package com.scu.gkvr_system.entity;

import java.util.List;

public class SchoolDetail {
    private SchoolInfo schoolInfo;
    private List<MajorScore> majorScoreList;
    private ScLiScore scLiScore;

    public SchoolDetail(SchoolInfo schoolInfo, List<MajorScore> majorScore) {
        this.schoolInfo = schoolInfo;
        this.majorScoreList = majorScore;
    }

    public SchoolDetail(SchoolInfo schoolInfo, List<MajorScore> majorScoreList, ScLiScore scLiScore) {
        this.schoolInfo = schoolInfo;
        this.majorScoreList = majorScoreList;
        this.scLiScore = scLiScore;
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

    public ScLiScore getScLiScore() {
        return scLiScore;
    }

    public void setScLiScore(ScLiScore scLiScore) {
        this.scLiScore = scLiScore;
    }

    @Override
    public String toString() {
        return "SchoolDetail{" +
                "schoolInfo=" + schoolInfo +
                ", majorScoreList=" + majorScoreList +
                ", scLiScore=" + scLiScore +
                '}';
    }
}
