package com.newone.xiaohongshu.auth.constant;

/**
 * Redis键常量
 *
 * @author liuwh
 * @date 2025/06/30 17:25:51
 */
public class RedisKeyConstants {

    /**
     * 验证码 KEY 前缀
     */
    private static final String VERIFICATION_CODE_KEY_PREFIX = "verification_code:";

    /**
     * 小红书全局 ID 生成器 KEY
     */
    public static final String XIAOHONGSHU_ID_GENERATOR_KEY = "xiaohongshu.id.generator";

    /**
     * 用户角色数据 KEY 前缀
     */
    private static final String USER_ROLE_KEY_PREFIX = "user:roles:";

    /**
     * 角色对应的权限集合 KEY 前缀
     */
    private static final String ROLE_PERMISSIONS_KEY_PREFIX = "role:permissions:";

    /**
     * 构建验证码 KEY
     */
    public static String buildVerificationCodeKey(String phone) {
        return VERIFICATION_CODE_KEY_PREFIX + phone;
    }

    /**
     * 构建用户角色数据 KEY
     */
    public static String buildUserRoleKey(String phone) {
        return USER_ROLE_KEY_PREFIX + phone;
    }

    /**
     * 构建角色对应的权限集合 KEY
     */
    public static String buildRolePermissionsKey(Long roleId) {
        return ROLE_PERMISSIONS_KEY_PREFIX + roleId;
    }

}
