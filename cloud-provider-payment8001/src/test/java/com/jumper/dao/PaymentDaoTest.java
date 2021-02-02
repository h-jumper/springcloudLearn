package com.jumper.dao;

import com.jumper.pojo.Payment;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PaymentDaoTest {

    @Autowired
    PaymentDao paymentDao;

    @Test
    void create() {
        Payment payment = new Payment(1,"123456");
        System.out.println(paymentDao.create(payment));
        System.out.println(payment.getId());
    }

    @Test
    void getPaymentById() {
        System.out.println(paymentDao.getPaymentById(new Long(11)));
    }
}