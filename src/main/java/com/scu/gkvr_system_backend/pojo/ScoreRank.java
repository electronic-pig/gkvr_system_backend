package com.scu.gkvr_system_backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName score_rank
 */
@TableName(value ="score_rank")
@Data
public class ScoreRank implements Serializable {
    @TableId
    private Integer id;

    private String score;

    private Integer num;

    private Integer rank;

    private String rankRange;

    private String batchName;

    private Integer controlScore;

    @Serial
    private static final long serialVersionUID = 1L;
}
