package com.nuaa.demo.vo;

import com.nuaa.demo.constant.ResponseStatus;

import java.io.Serializable;

public class ResponseResult implements Serializable{
    private Integer code;
    private String msg;
    private Object data;

    public static ResponseResult success(){
        ResponseResult result = new ResponseResult();
        result.setCode(ResponseStatus.SUCCESS);
        result.setMsg("success");
        return result;
    }
    public static ResponseResult success(Object data){
        ResponseResult result = new ResponseResult();
        result.setCode(ResponseStatus.SUCCESS);
        result.setMsg("success");
        result.setData(data);
        return result;
    }
    public static ResponseResult fail(String message) {
        ResponseResult result = new ResponseResult();
        result.setCode(ResponseStatus.FAIL);
        result.setMsg(message);
        return result;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
