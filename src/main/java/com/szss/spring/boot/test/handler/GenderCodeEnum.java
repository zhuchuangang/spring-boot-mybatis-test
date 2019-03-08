package com.szss.spring.boot.test.handler;

/**
 * @author 鼠冷风
 * @date 2018/7/26
 */
public enum GenderCodeEnum implements ICodeEnum {
    /**
     * 操作成功
     */
    MALE(true, "1", "男"),

    FEMALE(true,"0","女");

    /**
     * 成功标示
     */
    private Boolean success;
    /**
     * 响应代码
     */
    private String code;
    /**
     * 响应代码说明
     */
    private String desc;

    /**
     * 构造方法
     */
    GenderCodeEnum(Boolean success, String code, String desc) {
        this.success = success;
        this.code = code;
        this.desc = desc;
    }


    public String getCode() {
        return code;
    }


    public Boolean getSuccess() {
        return success;
    }


    public String getDesc() {
        return desc;
    }
}
