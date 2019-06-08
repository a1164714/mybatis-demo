package com.littleevil.mybatisdemo.mapper;

import com.littleevil.mybatisdemo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void save() {
        User user = new User();
        user.setId(1);
        user.setUsername("andy");
        user.setPassword("andy");
        userMapper.save(user);
    }

    @Test
    public void get() {
        User user = userMapper.get(1);
        assertEquals(user.getId(),new Integer(1));
        assertEquals(user.getUsername(),"andy");
        assertEquals(user.getPassword(),"andy");
    }
}