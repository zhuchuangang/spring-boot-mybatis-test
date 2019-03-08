package com.szss.spring.boot.test.handler;

/**
 * @author 鼠冷风
 * @date 2018/7/26
 */
public enum InvoiceCodeEnum implements ICodeEnum {
    /**
     * 操作成功
     */
    INVOICE_SUCCESS(true, "1", "操作成功"),
    /**
     * 操作成功
     */
    INVOICE_ERROR(false, "2", "操作失败"),
    /**
     * 数据更新失败
     */
    INVOICE_RUSH_RED_FAILED(false, "3", "发票冲红失败"),
    /**
     * 发票补开次数过多
     */
    INVOICE_COUNT_OVERTOP(false, "4", "发票补开次数过多，无法再次补开"),
    /**
     * 发票信息有误
     */
    INVOICE_INFO_ERROR(false, "5", "发票信息有误，请检查"),
    /**
     * 发票开具中，无法重开
     */
    INVOICE_PROCESS(false, "6", "发票开具中，无法重开"),
    /**
     * 发票已开具，是否重开
     */
    INVOICE_DOWNLOAD_SUCCESS(false, "7", "发票已开具，是否重开"),
    /**
     * 未查到可冲红发票
     */
    INVOICE_BLUE_NOT_EXIST(false, "8", "未查到可冲红发票");

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
    InvoiceCodeEnum(Boolean success, String code, String desc) {
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
