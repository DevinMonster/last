package com.devin.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("分类请求类")
public class CategoryRequest {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty(value = "商品分类的名称")
    private String name;
}
