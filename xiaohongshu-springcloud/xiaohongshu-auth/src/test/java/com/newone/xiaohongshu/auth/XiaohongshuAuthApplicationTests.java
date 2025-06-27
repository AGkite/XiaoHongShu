package com.newone.xiaohongshu.auth;

import com.alibaba.druid.filter.config.ConfigTools;
import com.newone.xiaohongshu.auth.domain.dataobject.UserDO;
import com.newone.xiaohongshu.auth.domain.mapper.UserDOMapper;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
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

    @Test
    void testSelect() {
        userDOMapper.selectByPrimaryKey(2L);
    }

    @SneakyThrows
    @Test
    void testEncrypt() {
        String password = "123456";
        String[] keyPair = ConfigTools.genKeyPair(512);

        String privateKey = keyPair[0];
        String publicKey = keyPair[1];

        String encryptPassword = ConfigTools.encrypt(privateKey, password);

        String decryptPassword = ConfigTools.decrypt(publicKey, encryptPassword);

        log.info(String.format("""
                
                privateKey=%s
                publicKey=%s
                encryptPassword=%s
                decryptPassword=%s
                """, privateKey, publicKey, encryptPassword, decryptPassword));

    }
}
