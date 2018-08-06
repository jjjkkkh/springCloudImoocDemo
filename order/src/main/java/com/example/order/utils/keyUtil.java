package com.example.order.utils;

import java.util.Random;

/**
 * Created by 黄逸晖 on 2018-08-06.
 */
public class keyUtil {
    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
