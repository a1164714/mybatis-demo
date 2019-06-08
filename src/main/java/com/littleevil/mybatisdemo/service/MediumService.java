package com.littleevil.mybatisdemo.service;

import com.littleevil.mybatisdemo.entity.House;
import com.littleevil.mybatisdemo.mapper.HouseMapper;
import com.littleevil.mybatisdemo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 房地产中介：买卖房子
 */
@Service
@Slf4j
public class MediumService {

    @Resource
    private HouseMapper houseMapper;

    /**
     * 锁行
     * 隔离级别：读未提交能进行行锁
     * Transactional只有当方法为public才生效
     *
     * @param hid 房子Id
     * @param uid 用户Id
     */
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void buyHouseLock(int hid, int uid) {
        House house = houseMapper.selectForUpdate(hid);
        log.info("house:{}",house);
        if (house.getMaster() != null) {
            log.info("not null house:{}",house);
            return;
        }
        house.setMaster(uid);
        houseMapper.sell(house);
    }

    /**
     * 相同配置，但是没有锁行
     *
     * @param hId
     * @param uid
     */
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void buyHouse(int hId, int uid) {
        House house = houseMapper.get(hId);
        log.info("house:{}",house);
        if (house.getMaster() != null) {
            log.info("not null house:{}",house);
            return;
        }
        house.setMaster(uid);
        houseMapper.sell(house);
    }
}
