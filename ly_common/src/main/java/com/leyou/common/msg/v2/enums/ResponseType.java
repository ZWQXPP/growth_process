package com.leyou.common.msg.v2.enums;

public enum ResponseType {

    OK(0, "成功"),

    // 1XXXX 信息提示
    PARAM_ERROR(10000, "参数错误"),

    USER_HAVE_BLACKENED(10002, "该用户已被拉黑,无法执行此操作"),

    PAYMENT_PENDING(201, "参数错误"),

    // 4XXXX 客户端
    EX_USER_PASS_INVALID_CODE(40001, "用户名或密码错误！"),

    EX_USER_INVALID_CODE(40101, "用户token错误！"),

    EX_CLIENT_INVALID_CODE(40301, "客户端token错误！"),

    EX_CLIENT_FORBIDDEN_CODE(40331, "用户名或密码错误！"),

    EX_MOBILE_INVALID_CODE(40201, "手机端token错误！"),

    SYSTEM_ERROR(500, "系统错误！");

    private int code;

    private String description;

    ResponseType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ResponseType formCode(int code) {
        for (ResponseType type : ResponseType.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return null;
    }
}
