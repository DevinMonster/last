package com.devin.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.devin.entity.request.ProductPicRequest;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@ApiModel(value="ProductPic对象", description="")
public class ProductPic implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    // 雪花算法，保证id唯一
    @TableId(type = IdType.ASSIGN_ID)
    // 字符串序列化
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "商品图片路径")
    private String url;

    @ApiModelProperty(value = "所属商品的ID")
    private Integer productId;

    private Integer isDeleted;

    private Date createTime;

    private Date updateTime;

    public ProductPic(ProductPicRequest picRequest) {
        BeanUtils.copyProperties(picRequest, this);
        Date date = new Date();
        this.createTime = this.updateTime = date;
    }
}
