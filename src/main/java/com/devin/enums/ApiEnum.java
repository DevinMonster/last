package com.devin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiEnum {
    SUCCESS(200, "成功"),
    FAILED(500, "失败"),
    HELLO_WORLD(1000, "hello_world"),
    DIVIDE_BY_ZERO(10001, "除数不能为0"),
    FILE_SIZE_EXCEEDED(666, "文件大小请勿超过10MB"),
    PASSWORD_NOT_MATCH(10002, "密码不匹配"),
    USERNAME_REGISTED(10003, "用户名已经存在"),
    VERIFYCODE_ERROR(10004, "验证码错误"),
    USERNAME_PASSWORD_ERROR(10005, "用户名或密码错误"),
    TOKEN_NOT_MATCH(600, "非法的TOKEN"),
    PRODUCT_ALREADY_EXIST(10006, "商品已经存在请勿重复添加！"),
    PRODUCT_NOT_EXIST(10007, "商品不存在"),
    USER_NOT_LEAGLE(10008, "用户信息不合法！"),
    BALANCE_COUNT_ERROR(20000,"库存不足！")
    ;

    private final Integer code;
    private final String message;

    public static ApiEnum loadIntegerEnum(Integer code) {
        if (code == null) return null;
        for (ApiEnum curEnum : ApiEnum.values()) {
            if (curEnum.code.equals(code)) return curEnum;
        }
        return null;
    }
}
