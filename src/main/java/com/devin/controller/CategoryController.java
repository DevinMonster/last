package com.devin.controller;


import com.devin.dto.APIResult;
import com.devin.dto.ResultGenerator;
import com.devin.entity.Category;
import com.devin.entity.request.CategoryRequest;
import com.devin.enums.ApiEnum;
import com.devin.service.ICategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author devin
 * @since 2020-12-23
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private ICategoryService categoryService;

    @CrossOrigin
    @PostMapping(value = "add")
    @ResponseBody
    public APIResult addCategory(@RequestBody CategoryRequest category) {
        return ResultGenerator.genSuccess(categoryService.add(category));
    }

    //首页的需求：需要再弄一个端口，只需要data.data内的‘name'和'id’。

    @GetMapping(value = "/list")
    @CrossOrigin
    public APIResult list() {
        List<Category> list = categoryService.list();
        return ResultGenerator.genSuccess(list);
    }

    @CrossOrigin
    @PostMapping(value = "delete")
    public APIResult delete(@RequestBody Long categoryId) {
        categoryService.removeById(categoryId);
        return ResultGenerator.genSuccess(ApiEnum.SUCCESS);
    }

}

