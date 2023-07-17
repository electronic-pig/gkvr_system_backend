package com.scu.gkvr_system.entity;

import java.util.List;

public class SchoolDetail {
    private SchoolInfo schoolInfo;
    private List<MajorScore> majorScoreList;
    private ScLiScoreNew scLiScoreNew;
    private SchoolInfoDetail schoolInfoDetail;

    public SchoolDetail(SchoolInfo schoolInfo, List<MajorScore> majorScoreList, ScLiScoreNew scLiScoreNew, SchoolInfoDetail schoolInfoDetail) {
        this.schoolInfo = schoolInfo;
        this.majorScoreList = majorScoreList;
        this.scLiScoreNew = scLiScoreNew;
        this.schoolInfoDetail = schoolInfoDetail;
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

    public void setScLiScoreNew(ScLiScoreNew scLiScoreNew) {
        this.scLiScoreNew = scLiScoreNew;
    }

    public SchoolInfoDetail getSchoolInfoDetail() {
        return schoolInfoDetail;
    }

    public void setSchoolInfoDetail(SchoolInfoDetail schoolInfoDetail) {
        this.schoolInfoDetail = schoolInfoDetail;
    }

    @Override
    public String toString() {
        return "SchoolDetail{" +
                "schoolInfo=" + schoolInfo +
                ", majorScoreList=" + majorScoreList +
                ", scLiScoreNew=" + scLiScoreNew +
                ", schoolInfoDetail=" + schoolInfoDetail +
                '}';
    }
}
