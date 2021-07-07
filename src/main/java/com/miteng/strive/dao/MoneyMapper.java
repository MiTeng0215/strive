package com.miteng.strive.dao;

import com.miteng.strive.pojo.Money;

/**
 * @Author 苗腾
 * @Date 2021/7/7 15:45
 * @Version 1.0
 */
public interface MoneyMapper {
    /**
     * 过去money
     * @param id
     * @return
     */
    Money getMoneyById(Integer id);
}
