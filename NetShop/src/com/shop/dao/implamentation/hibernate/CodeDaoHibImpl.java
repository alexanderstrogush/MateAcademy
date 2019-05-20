package com.shop.dao.implamentation.hibernate;

import com.shop.dao.CodeDao;
import com.shop.model.Code;

import java.util.Optional;

public class CodeDaoHibImpl implements CodeDao {
    @Override
    public long addCode(Code code) {
        return 0;
    }

    @Override
    public Optional<Code> getCodeByValue(long userId, String values) {
        return Optional.empty();
    }

    @Override
    public int deleteCodeById(long codeId) {
        return 0;
    }
}
