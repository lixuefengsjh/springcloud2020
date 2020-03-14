package com.atguigu.springcloud.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 12034
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult <T>{
    private Integer code;
    private String message;
    private T      data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
