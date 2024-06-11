package com.newone.xiaohongshu.web.service;


import com.newone.xiaohongshu.common.utils.Response;
import com.newone.xiaohongshu.web.model.vo.category.AddCategoryReqVO;

public interface CategoryService {
    /**
     * 添加社区分类
     * @param addCategoryReqVO
     * @return
     */
    Response addCategory(AddCategoryReqVO addCategoryReqVO);

    /**
     * 展示社区列表
     * @return
     */
    Response findCategoryList();
}
