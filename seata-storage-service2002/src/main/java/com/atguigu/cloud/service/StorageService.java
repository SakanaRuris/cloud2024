package com.atguigu.cloud.service;

/**
 * @author Yu Chenxi
 * @since 2024/4/20 1:17
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
