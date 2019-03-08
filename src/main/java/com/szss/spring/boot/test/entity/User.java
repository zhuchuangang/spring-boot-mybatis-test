package com.szss.spring.boot.test.entity;

import com.szss.spring.boot.test.handler.GenderCodeEnum;
import com.szss.spring.boot.test.handler.InvoiceCodeEnum;
import lombok.Data;

/**
 * Created by zcg on 15/12/25.
 */
@Data
public class User {
    private Long id;
    private String username;
    private InvoiceCodeEnum code;
    private GenderCodeEnum gender;
}