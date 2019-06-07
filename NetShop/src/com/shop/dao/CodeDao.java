package com.shop.dao;

import com.shop.model.Code;

import java.util.Optional;

public interface CodeDao extends GenericDao<Code> {

    public Optional<Code> getCodeByValue(long userId, String values);
}
