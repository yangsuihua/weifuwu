package com.atguigu.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "全局统一返回结果")
public class Result<T> {
    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private T data;

    public Result(){};

    public static<T> Result<T> build(T data,Integer code,String message){
        Result<T> result = new Result<T>();
        result.setCode(code);
        if(data!=null){
        result.setData(data);}
        result.setMessage(message);
        return result;
    }
    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        if (data != null) {
         result.setData(data);
        }
        result.setCode(20000);
        result.setMessage("成功");
        return result;
    }
    public static<T> Result<T> fail(T data) {
        Result<T> result = new Result<>();
        if(data != null) {
            result.setData(data);
        }
        result.setCode(20001);
        result.setMessage("失败");
        return result;
    }
    public Result<T> message(String msg){
        this.setMessage(msg);
        return this;
    }
    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }


}
