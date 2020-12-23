package com.devin.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GenderEnum implements IEnum<Integer> {
    MAN(1, "男"),
    GIRL(0, "女");

    private final Integer code;

    @JsonValue
    private final String message;

    @Override
    public Integer getValue() {
        return this.code;
    }
}
