package com.ty.april.common.tool.exception;


import com.ty.april.common.tool.api.ResultEnum;

/**
 * @author: wenqing
 * @date: 2019/4/4 6:34 PM
 * @description: 服务层异常
 */
public class ServiceException extends RuntimeException {
    // 异常码
    private Integer code;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public ServiceException(String msg, Integer code) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
