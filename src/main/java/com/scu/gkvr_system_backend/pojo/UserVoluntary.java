package com.scu.gkvr_system_backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName user_voluntary
 */
@TableName(value ="user_voluntary")
@Data
public class UserVoluntary implements Serializable {
    @TableId
    private Integer userId;
    private String schoolId;

    private String majorIdA;

    private String majorIdB;

    private String majorIdC;

    private String majorIdD;

    private String majorIdE;

    private String majorIdF;

    private Integer count;

    private static final long serialVersionUID = 1L;
}
