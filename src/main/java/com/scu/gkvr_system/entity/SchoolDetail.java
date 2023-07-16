package com.scu.gkvr_system.entity;

public class SchoolDetail {
    private SchoolInfo schoolInfo;
    private ScLiScore scLiScore;

    public SchoolDetail(SchoolInfo schoolInfo, ScLiScore scLiScore) {
        this.schoolInfo = schoolInfo;
        this.scLiScore = scLiScore;
    }

    public SchoolInfo getSchoolInfo() {
        return schoolInfo;
    }

    public void setSchoolInfo(SchoolInfo schoolInfo) {
        this.schoolInfo = schoolInfo;
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
                ", scLiScore=" + scLiScore +
                '}';
    }
}
