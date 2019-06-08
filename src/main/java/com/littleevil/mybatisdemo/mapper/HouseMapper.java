package com.littleevil.mybatisdemo.mapper;


import com.littleevil.mybatisdemo.entity.House;

public interface HouseMapper {
    void save(House house);

    House get(int id);

    House selectForUpdate(int id);

    void sell(House house);
}
