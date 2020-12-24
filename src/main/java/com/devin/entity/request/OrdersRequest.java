package com.devin.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Chika
 * @since 2020/12/24
 */

@Data
@ApiModel(value="Orders对象", description="")
@ToString
public class OrdersRequest {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "user_id")
    private Long user_id;

    @ApiModelProperty(value = "商品")
    @NotNull(message = "商品信息不能为空")
    @NotBlank(message = "商品信息不能为空")
    private String products;

    @ApiModelProperty(value = "价格")
    @NotNull(message = "价格不能为空")
    private double total_bill;

    private int is_deleted;

    private Date create_time;

    private Date update_time;

}
