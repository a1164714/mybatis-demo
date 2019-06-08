package com.littleevil.mybatisdemo.mapper;

import com.littleevil.mybatisdemo.entity.House;
import com.littleevil.mybatisdemo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HouseMapperTest {
    @Resource
    private HouseMapper houseMapper;

    @Test
    public void save() {
        House house = new House();
        house.setId(1);
        house.setName("house1");
        houseMapper.save(house);
    }

    @Test
    public void get() {
        House house = houseMapper.get(1);
        assertEquals(house.getId(),1);
        assertEquals(house.getName(),"house1");
    }
}