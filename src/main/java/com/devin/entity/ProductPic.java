package com.devin.entity;

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
 * @since 2020-12-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ProductPic对象", description="")
public class ProductPic implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品图片路径")
    private String url;

    @ApiModelProperty(value = "所属商品的ID")
    private Integer productId;

    private Integer isDeleted;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
