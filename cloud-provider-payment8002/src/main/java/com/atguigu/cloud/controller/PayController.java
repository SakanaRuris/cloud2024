package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Yu Chenxi
 * @since 2024/4/4 22:11
 */
@RestController
@Slf4j
@Tag(name = "支付微信模块",description = "支付CRUD")
public class PayController {
    @Resource
    private PayService payService;

    @Operation(summary = "新增",description = "新增支付流水的方法，json串做参数")
    @PostMapping("/pay/add")
    public ResultData<String> addPay(@RequestBody Pay pay){
        System.out.println(pay.toString());
        int i = payService.add(pay);
        return ResultData.success("成功插入记录，返回值:" + i);
    }

    @Operation(summary = "删除",description = "删除支付流水的方法，id做参数")
    @DeleteMapping("/pay/del/{id}")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id){
        int i = payService.delete(id);
        return ResultData.success(i);
    }

    @Operation(summary = "更新",description = "更新支付流水的方法，json串做参数")
    @PutMapping("/pay/update")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO,pay);
        int i = payService.update(pay);
        return ResultData.success("成功修改记录，返回值:" + i);
    }

    @Operation(summary = "查询",description = "查询支付流水的方法，id做参数")
    @GetMapping("/pay/get/{id}")
    public ResultData<Pay> getById(@PathVariable("id") Integer id){
//        if(id == -4) throw new RuntimeException("id不能为负数");
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @Operation(summary = "查询所有",description = "查询所有支付流水的方法")
    @GetMapping("/pay/getall")
    public ResultData<List<Pay>> getAll(){
        List<Pay> payList = payService.getAll();
        return ResultData.success(payList);
    }

    @Value("${server.port}")
    private String port;


    @GetMapping("/pay/get/info")
    public String getInfoByConsul(@Value("${atguigu.info}") String atguiguInfo){
        return "atguiguInfo:"+atguiguInfo+"\t"+"port:" + port;
    }
}
