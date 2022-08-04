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
public enum ProductEnum {
    /**
     * 商品枚举
     */
    IPHONE12_PRO(1, "Apple iPhone12 Pro Max",10099),
    IPHONE12(2, "Apple iPhone 12", 6799),
    HUAWEIMATE_40_PRO(3, "HUAWEI Mate 40 Pro", 6999),
    HUAWEI_P40_Pro(4, "HUAWEI P40 Pro", 6488),
    ONEPLUS(5, "OnePlus", 3699),
    小米10(6, "小米10", 3999),
    K7X(7, "OPPO k7x",1499),

    PLAY4T_PRO(8, "荣耀Play4T Pro",1788),
    Redmi_K30(9, "Redmi K30",2199),
    HUAWEI_畅想Z(10, "HUAWEI 畅想Z", 2199),
    ;

    private Integer key;
    private String value;
    private Integer price;
    public Integer getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }
    public Integer getPrice() {
        return price;
    }
    ProductEnum(Integer key, String value, Integer price) {
        this.key = key;
        this.value = value;
        this.price = price;
    }

    public static String getValueByKey(Integer key) {
        return Arrays.stream(ProductEnum.values())
                .filter(item -> item.getKey().equals(key))
                .findFirst()
                .map(ProductEnum::getValue).orElse("");
    }
    public static ProductEnum getEnumByKey(Integer key) {
        return Arrays.stream(ProductEnum.values())
                .filter(item -> item.getKey().equals(key))
                .findFirst()
                .orElse(null);
    }
    public static Integer getPriceByKey(Integer key) {
        return Arrays.stream(ProductEnum.values()).
                filter(item -> key.equals(item.getPrice()))
                .findFirst()
                .map(ProductEnum::getPrice).orElse(-1);
    }

    public static ProductEnum getRandomProduct(){
        int random = new Random().nextInt(9) + 1;
        return ProductEnum.getEnumByKey(random);
    }

    @Test
    public void test() {
        System.out.println(ProductEnum.getRandomProduct());
    }

}
