package com.devin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.devin.dto.APIResult;
import com.devin.dto.ResultGenerator;
import com.devin.entity.Product;
import com.devin.entity.ProductPic;
import com.devin.entity.request.ProductPicRequest;
import com.devin.service.IProductPicService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author devin
 * @since 2020-12-23
 */
@RestController
@RequestMapping("/product_pic")
public class ProductPicController {

    @Resource
    private IProductPicService picService;

    /**
     * 添加一张图片对象
     * @param picRequest 图片对象的请求对象
     * @return 存储结果，如果是合法则返回图片对象
     */
    @PostMapping("/add_pic")
    @CrossOrigin
    public APIResult addPic(@RequestBody @Validated ProductPicRequest picRequest) {
        return ResultGenerator.genSuccess(picService.insertOnePic(picRequest));
    }

    /**
     * 根据类型id查询商品图片
     * @param productId 类型的id
     * @return 构造的返回对象
     */
    @GetMapping("/list")
    @CrossOrigin
    public APIResult<Product> list(@NotNull Integer productId) {
        QueryWrapper<ProductPic> queryWrapper = new QueryWrapper<>();
        // 查找商品类别为category_id的所有商品
        queryWrapper.eq("product_id", productId);
        List<ProductPic> list = picService.list(queryWrapper);
        return ResultGenerator.genSuccess(list);
    }

}
