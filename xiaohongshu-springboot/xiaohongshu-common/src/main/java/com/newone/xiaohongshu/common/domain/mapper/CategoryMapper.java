package com.dala.common.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dala.common.domain.dos.CategoryDO;

public interface CategoryMapper extends BaseMapper<CategoryDO> {

    /**
     * 根据分类名查询
     * @param categoryName
     * @return
     */
    default CategoryDO selectByName(String categoryName) {
        return selectOne(Wrappers.<CategoryDO>lambdaQuery()
                .eq(CategoryDO::getName, categoryName));
    }

}
