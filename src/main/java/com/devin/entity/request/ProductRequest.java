package com.devin.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@ApiModel(value="Product对象", description="")
@ToString
public class ProductRequest {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "商品名称")
    @NotNull(message = "商品名不能为空")
    @NotBlank(message = "商品名不能为空")
    private String name;

    @ApiModelProperty(value = "商品价格")
    @NotNull(message = "价格不能为空")
    private BigDecimal price;

    @ApiModelProperty(value = "商品库存数量")
    private Long count;

    @ApiModelProperty(value = "商品描述")
    private String productDescribe;

    @ApiModelProperty(value = "所属类别的ID")
    private Long categoryId;

    private Integer isDeleted;
}
