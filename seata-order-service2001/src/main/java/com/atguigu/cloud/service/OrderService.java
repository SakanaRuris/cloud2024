package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Order;

/**
 * @author Yu Chenxi
 * @since 2024/4/20 0:54
 */
public interface OrderService {
    /**
     * 创建订单
     */
    void create(Order order);
}
