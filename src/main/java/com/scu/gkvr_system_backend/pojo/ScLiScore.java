package com.scu.gkvr_system_backend.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName sc_li_score
 */
@TableName(value ="sc_li_score")
@Data
public class ScLiScore implements Serializable {
    @TableId
    private Integer id;

    private String schoolId;

    private String schoolName;

    private String score2022;

    private String rank2022;

    private String score2021;

    private String rank2021;

    private String score2020;

    private String rank2020;

    @Serial
    private static final long serialVersionUID = 1L;
}
