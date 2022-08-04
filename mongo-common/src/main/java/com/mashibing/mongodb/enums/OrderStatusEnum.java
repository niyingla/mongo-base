package com.mashibing.mongodb.enums;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-12-01 0:15
 */
public enum OrderStatusEnum {
    /**
     * 性别枚举
     */
    待付款(1, "待付款"),
    待发货(2, "待发货"),
    待收货(3, "待收货"),
    已完成未评价1(4, "已完成未评价"),
    已完成未评价2(5, "已完成未评价"),
    已完成未评价3(6, "已完成未评价"),
    已完成已评价1(7, "已完成已评价"),
    已完成已评价2(8, "已完成已评价"),
    已完成已评价3(9, "已完成已评价"),
    退货(10, "退货"),
    ;

    private Integer key;
    private String value;
    public Integer getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }
    OrderStatusEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }
    public static String getValueByKey(Integer key) {
        return Arrays.stream(OrderStatusEnum.values())
                .filter(item -> item.getKey().equals(key))
                .findFirst()
                .map(OrderStatusEnum::getValue).orElse("");
    }
    public static Integer getKeyByValue(String value) {
        return Arrays.stream(OrderStatusEnum.values()).
                filter(item -> value.equals(item.getValue()))
                .findFirst()
                .map(OrderStatusEnum::getKey).orElse(-1);
    }

    public static String getRandomStatus(){
        int random = new Random().nextInt(9) + 1;
        return OrderStatusEnum.getValueByKey(random);
    }

    @Test
    public void test() {
        System.out.println(OrderStatusEnum.getRandomStatus());
    }


}
