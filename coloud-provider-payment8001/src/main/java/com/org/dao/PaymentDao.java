package com.org.dao;

import com.org.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    public Payment get(@Param("serial") String serial);
}
