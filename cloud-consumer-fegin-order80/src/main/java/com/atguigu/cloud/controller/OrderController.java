package com.atguigu.cloud.controller;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.unit.DataUnit;
import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Yu Chenxi
 * @since 2024/4/5 0:48
 */
@RestController
public class OrderController {
    @Resource
    private PayFeignApi payFeignApi;

    @PostMapping("/fegin/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO){
        ResultData resultData = payFeignApi.addPay(payDTO);
        return resultData;
    }

    @GetMapping("/fegin/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id){

//        ResultData resultData = null;
//        try {
//            System.out.println("调用开始"+ DateUtil.now());
//            resultData = payFeignApi.getPayInfo(id);
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println("调用结束"+ DateUtil.now());
//            ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
//        }
        ResultData resultData = payFeignApi.getPayInfo(id);
        return resultData;
    }

    @GetMapping("/fegin/pay/mylb")
    public String mylb(){
        return payFeignApi.mylb();
    }

}
