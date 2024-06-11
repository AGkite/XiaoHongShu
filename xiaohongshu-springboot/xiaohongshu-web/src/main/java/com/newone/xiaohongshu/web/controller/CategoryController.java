package com.newone.xiaohongshu.web.controller;

import com.newone.xiaohongshu.common.aspect.ApiOperationLog;
import com.newone.xiaohongshu.common.utils.Response;
import com.newone.xiaohongshu.web.model.vo.category.AddCategoryReqVO;
import com.newone.xiaohongshu.web.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@Api(tags = "社区分类模块")
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加社区分类")
    @ApiOperationLog(description = "添加社区分类")
    public Response addCategory(@RequestBody @Validated AddCategoryReqVO addCategoryReqVO) {
        return categoryService.addCategory(addCategoryReqVO);
    }

    @GetMapping("/find/list")
    @ApiOperation(value = "展示社区列表")
    @ApiOperationLog(description = "展示社区列表")
    public Response findCategoryList() {
        return categoryService.findCategoryList();
    }
}
