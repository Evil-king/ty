
package com.ty.april.common.tool.api;

/**
 * @author wenqing
 * @version 1.0
 * @Description Controller层返回的统一结果对象信息码
 * @date 2015年8月31日 下午11:58:29
 */
public enum ResultEnum {
    SUCCESS(200, "成功"),// 成功
    ERROR(-999, "系统错误"),// 系统错误
    BAD_PARAM(-998, "参数错误"),// 参数错误
    NOT_FOUND(-997, "接口不存在"),// 接口不存在
    SERVIE_FAIL(-996, "服务调用失败"),// 服务调用失败
    BUSINESS_ERROE(-995, "业务异常"), // 默认服务层抛出异常的状态码,可细分下发具体服务的异常码
    ACCESS_TOKEN_ERROE(-994, "访问令牌错误或过期"),
    REPEAT_SUBMIT(-993, "请勿重复提交"), // 请勿重复提交
    BUSINESS_VALIDATE_FAIL(-992, "业务校验失败");

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据状态码获取到对应的提示信息
     *
     * @param code
     * @return
     */
    public static String getMsg(int code) {
        for (ResultEnum resultCodeMsg : values()) {
            if (resultCodeMsg.getCode() == code) {
                return resultCodeMsg.getMsg();
            }
        }
        return null;
    }
}
