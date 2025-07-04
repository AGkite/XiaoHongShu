package com.newone.framework.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 逻辑删除枚举
 *
 * @author liuwh
 * @date 2025/07/02 10:36:25
 */
@Getter
@AllArgsConstructor
public enum DeletedEnum {

    YES(true),
    NO(false);

    private final Boolean value;

}
