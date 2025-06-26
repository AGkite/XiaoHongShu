package com.newone.xiaohongshu.auth;

import com.newone.xiaohongshu.auth.domain.dataobject.UserDO;
import com.newone.xiaohongshu.auth.domain.mapper.UserDOMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
class XiaohongshuAuthApplicationTests {

    @Resource
    private UserDOMapper userDOMapper;

    @Test
    void testInsert() {
        UserDO userDO = UserDO.builder()
                .username("newone")
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        userDOMapper.insertSelective(userDO);
    }

    @Test
    void testDelete() {
        userDOMapper.deleteByPrimaryKey(1L);
    }
}
