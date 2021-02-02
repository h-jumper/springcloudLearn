package com.jumper.dao;

import com.jumper.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PaymentDao {

    public int create(Payment payment); //写

    public Payment getPaymentById(@Param("id") Long id);//读
}
