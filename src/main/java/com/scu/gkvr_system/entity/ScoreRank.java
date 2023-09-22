package com.scu.gkvr_system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wj
 * @since 2023-07-19
 */
@TableName("score_rank")
public class ScoreRank implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId
    private String keyIndex;

    private String score;

    private String num;

    private String total;

    private String rankRange;

    private String batchName;

    private String controlscore;

    private String rank;

    public String getKeyIndex() {
        return keyIndex;
    }

    public void setKeyIndex(String keyIndex) {
        this.keyIndex = keyIndex;
    }
    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    public String getRankRange() {
        return rankRange;
    }

    public void setRankRange(String rankRange) {
        this.rankRange = rankRange;
    }
    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }
    public String getControlscore() {
        return controlscore;
    }

    public void setControlscore(String controlscore) {
        this.controlscore = controlscore;
    }
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "ScoreRank{" +
            "keyIndex=" + keyIndex +
            ", score=" + score +
            ", num=" + num +
            ", total=" + total +
            ", rankRange=" + rankRange +
            ", batchName=" + batchName +
            ", controlscore=" + controlscore +
            ", rank=" + rank +
        "}";
    }
}
