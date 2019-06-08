package com.littleevil.mybatisdemo.mapper;

import com.littleevil.mybatisdemo.entity.User;

public interface UserMapper {

    void save(User user);

    User get(int id);
}
