package com.shop.dao;

import com.shop.model.Good;

import java.util.List;
import java.util.Optional;

public interface GoodDao {

    public long addGood(Good good);

    public Optional<Good> getGoodById(long goodId);

    public List<Good> getAllGoods();

    public int deleteGoodById(long goodId);

    public int updateGoodById(Good good);
}
