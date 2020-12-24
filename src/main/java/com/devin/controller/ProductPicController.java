package com.devin.controller;


import com.devin.dto.APIResult;
import com.devin.dto.ResultGenerator;
import com.devin.entity.request.ProductPicRequest;
import com.devin.service.IProductPicService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    public APIResult addPic(@RequestBody @Validated ProductPicRequest picRequest) {
        return ResultGenerator.genSuccess(picService.insertOnePic(picRequest));
    }

}
