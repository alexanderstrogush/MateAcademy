package com.shop.dao.implamentation.hibernate;

import com.shop.dao.CodeDao;
import com.shop.model.Code;

import java.util.Optional;

public class CodeDaoHibImpl extends GenericDaoImpl<Code> implements CodeDao {

    @Override
    public Optional<Code> getCodeByValue(long userId, String values) {
        return Optional.empty();
    }

}
