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
public enum  AddressEnum {
    /**
     * 性别枚举
     */
    安徽(1, "安徽"),
    北京(2, "北京"),
    重庆(3, "重庆"),
    钓鱼岛(4, "钓鱼岛"),
    福建(5, "福建"),
    甘肃(6, "甘肃"),
    广西(7, "广西"),
    广东(8, "广东"),
    贵州(9, "贵州"),
    海南(10, "海南"),
    河北(11, "河北"),
    河南(12, "河南"),
    黑龙江(13, "黑龙江"),
    湖南(14, "湖南"),
    湖北(15, "湖北"),
    吉林(16, "吉林"),
    江西(17, "江西"),
    江苏(18, "江苏"),
    辽宁(19, "辽宁"),
    内蒙古(20, "内蒙古"),
    宁夏(21, "宁夏"),
    青海(22, "青海"),
    陕西(23, "陕西"),
    山西(24, "山西"),
    山东(25, "山东"),

    上海(26, "上海"),
    四川(27, "四川"),
    天津(28, "天津"),
    西藏(29, "西藏"),
    新疆(10, "新疆"),
    云南(31, "云南"),
    浙江(32, "浙江");

    private Integer key;
    private String value;
    public Integer getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }
    AddressEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }
    public static String getValueByKey(Integer key) {
        return Arrays.stream(AddressEnum.values())
                .filter(item -> item.getKey().equals(key))
                .findFirst()
                .map(AddressEnum::getValue).orElse("");
    }
    public static Integer getKeyByValue(String value) {
        return Arrays.stream(AddressEnum.values()).
                filter(item -> value.equals(item.getValue()))
                .findFirst()
                .map(AddressEnum::getKey).orElse(-1);
    }

    public static String getRandomAddress(){
        int random = new Random().nextInt(31) + 1;
        return AddressEnum.getValueByKey(random);
    }

    @Test
    public void test() {
        System.out.println(AddressEnum.getRandomAddress());
    }


}
