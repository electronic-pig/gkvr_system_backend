package com.scu.gkvr_system_backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @TableName user_voluntary
 */
@TableName(value = "user_voluntary")
@Data
public class UserVoluntary implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String userName;

    private String schoolName;

    private String majorA;

    private String majorB;

    private String majorC;

    private String majorD;

    private String majorE;

    private String majorF;

    @Serial
    private static final long serialVersionUID = 1L;
}
