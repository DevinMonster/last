package com.devin.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ApiModel(value="Product请求对象", description="")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductPicRequest {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "商品图片路径")
    @NotNull
    @NotBlank
    private String url;

    @ApiModelProperty(value = "所属商品的ID")
    @NotNull
    private Integer productId;
}
