package com.atguigu.cloud;

import java.time.ZonedDateTime;

/**
 * @author Yu Chenxi
 * @since 2024/4/5 1:08
 */
public class Main {
    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
    }
}
