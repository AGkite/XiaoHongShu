package com.newone.xiaohongshu.web.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.newone.xiaohongshu.common.domain.dos.CategoryDO;
import com.newone.xiaohongshu.common.domain.mapper.CategoryMapper;
import com.newone.xiaohongshu.common.enums.ResponseCodeEnum;
import com.newone.xiaohongshu.common.exception.BizException;
import com.newone.xiaohongshu.common.utils.Response;
import com.newone.xiaohongshu.web.model.vo.category.AddCategoryReqVO;
import com.newone.xiaohongshu.web.model.vo.category.CategoryRspVO;
import com.newone.xiaohongshu.web.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    /**
     * 添加社区分类
     *
     * @param addCategoryReqVO
     * @return
     */
    @Override
    public Response addCategory(AddCategoryReqVO addCategoryReqVO) {
        String categoryName = addCategoryReqVO.getName();

        // 先判断该分类是否已经存在
        CategoryDO categoryDO = categoryMapper.selectByName(categoryName);

        if (Objects.nonNull(categoryDO)) {
            log.warn("社区名称: {}, 此社区已存在", categoryName);
            throw new BizException(ResponseCodeEnum.CATEGORY_NAME_IS_EXISTED);
        }

        // 构建 DO 类
        CategoryDO insertCategoryDO = CategoryDO.builder()
                .name(addCategoryReqVO.getName().trim())
                .build();

        // 执行 insert
        categoryMapper.insert(insertCategoryDO);

        return Response.success();
    }

    /**
     * 展示社区列表
     * @return
     */
    @Override
    public Response findCategoryList() {
        List<CategoryDO> categoryDOS = categoryMapper.selectList(Wrappers.emptyWrapper());

        List<CategoryRspVO> vos = null;

        if (!CollectionUtils.isEmpty(categoryDOS)) {
            vos = categoryDOS.stream()
                    .filter(categoryDO -> !categoryDO.getIsDeleted())
                    .map(categoryDO -> CategoryRspVO.builder()
                            .categoryId(categoryDO.getCategoryId())
                            .name(categoryDO.getName())
                            .createTime(categoryDO.getCreateTime())
                            .build())
                    .collect(Collectors.toList());
        }

        return Response.success(vos);
    }
}
