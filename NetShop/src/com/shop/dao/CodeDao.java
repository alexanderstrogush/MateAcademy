package com.shop.dao;

import com.shop.model.Code;

import java.util.Optional;

public interface CodeDao {

    public long addCode(Code code);

    public Optional<Code> getCodeByValue(long userId, String values);

    public int deleteCodeById(long codeId);
}
