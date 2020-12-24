package com.devin.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.devin.entity.request.ProductRequest;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.beans.BeanUtils;

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
@ApiModel(value="Product对象", description="")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    // 雪花算法，保证id唯一
    @TableId(type = IdType.ASSIGN_ID)
    // 字符串序列化
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "商品价格")
    private BigDecimal price;

    @ApiModelProperty(value = "商品库存数量")
    private Long count;

    @ApiModelProperty(value = "商品描述")
    private String productDescribe;

    @ApiModelProperty(value = "所属类别的ID")
    private Long categoryId;

    private Integer isDeleted;

    private Date createTime;

    private Date updateTime;


    public Product(ProductRequest request) {
        BeanUtils.copyProperties(request, this);
        Date date = new Date();
        this.createTime = this.updateTime = date;
    }
}
