package com.devin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.devin.dto.APIResult;
import com.devin.dto.ResultGenerator;
import com.devin.entity.Product;
import com.devin.entity.request.ProductRequest;
import com.devin.service.IProductService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Devin
 */
@RestController
@RequestMapping("/product")
@SuppressWarnings("all")
public class ProductController {

    @Resource
    private IProductService productService;

    /**
     * 根据类型id查询商品列表
     * @param categoryId 类型的id
     * @return 构造的返回对象
     */
    @GetMapping("/list")
    public APIResult<Product> list(@NotNull Integer categoryId) {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        // 查找商品类别为category_id的所有商品
        queryWrapper.eq("category_id", categoryId);
        List<Product> list = productService.list(queryWrapper);
        return ResultGenerator.genSuccess(list);
    }

    /**
     * @return 查询所有的商品列表
     */
    @GetMapping("/listAll")
    public APIResult<Product> listAll() {
        return ResultGenerator.genSuccess(productService.list());
    }

    /**
     * 为指定类别增加一条商品信息
     * @param request 请求对象
     * @return ret
     *
     */
    @PostMapping("/add")
    public APIResult addProduct(@RequestBody @Validated ProductRequest request) {
        Product product = productService.addOneProduct(request);
        return ResultGenerator.genSuccess(product);
    }

    /**
     * 更新一条商品记录
     * @param request 商品对象
     * @return 结果
     */
    @PostMapping("/update")
    public APIResult updateProduct(@RequestBody @Validated ProductRequest request) {
        Product product = new Product(request);
        productService.updateById(product);
        return ResultGenerator.genSuccess(product);
    }
}
