package com.jumper.controller;

import com.jumper.pojo.CommonResult;
import com.jumper.pojo.Payment;
import com.jumper.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功 + port: " + serverPort, result);
        } else {
            return new CommonResult(404, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询结果 + port: " +serverPort, payment);
        } else {
            return new CommonResult(404, "没有对应记录，查询ID:" + id, null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getServerPort(){
        return serverPort;
    }
}
