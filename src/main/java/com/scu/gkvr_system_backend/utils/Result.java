package com.scu.gkvr_system_backend.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 全局统一返回结果类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<>(200, "success", data);
    }


    public static <T> Result<T> success(String message) {
        return new Result<>(200, message, null);
    }


    public static <T> Result<T> fail(String message) {
        return new Result<>(201, message, null);
    }

}
