package com.czd.util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
@ApiModel(value = "全局统一返回结果")
public class Result {

    @ApiModelProperty(value = "是否成功")
    private boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    private Map<String,Object>data = new ConcurrentHashMap<>();

    private Result(){}

    public static Result ok(){
        Result r = new Result();
        r.setSuccess(true);
        r.setCode(ResultCode.OK);
        r.setMessage("成功");
        return r;
    }

    public static Result error(){
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        return r;
    }

    public Result message(String message){
        this.setMessage(message);
        return this;
    }


    public Result code(Integer code){
        this.setCode(code);
        return this;
    }

    public Result data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public Result data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

}
