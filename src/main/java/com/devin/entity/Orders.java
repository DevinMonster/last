package com.devin.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author devin
 * @since 2020-12-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Orders对象", description="")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "所属用户的id")
    private Long userId;

    @ApiModelProperty(value = "产品的id和数量")
    private String products;

    @ApiModelProperty(value = "总价")
    private BigDecimal totalBill;

    private Integer isDeleted;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
