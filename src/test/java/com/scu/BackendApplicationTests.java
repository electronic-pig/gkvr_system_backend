package com.scu;

import com.scu.gkvr_system.entity.RecoInfo;
import com.scu.gkvr_system.entity.User;
import com.scu.gkvr_system.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BackendApplicationTests {
    @Resource
    private UserMapper userMapper;

    @Test
    void testMapper() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }


}
