package com.mashibing.mongodb.enums;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-12-04 22:10
 */
public class NumberGenerator {
    public static Long generate() {
        //初始化备选数组
        int[] defaultNums = new int[10];
        for (int i = 0; i < defaultNums.length; i++) {
            defaultNums[i] = i;
        }
        Random random = new Random();
        int[] nums = new int[LENGTH];
        int canBeUsed = 10;
        for (int i = 0; i < nums.length; i++) {
            int index = random.nextInt(canBeUsed);
            nums[i] = defaultNums[index];
            swap(index, canBeUsed - 1, defaultNums);
            canBeUsed--;
        }
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < nums.length; i++) {
            str.append(nums[i]);
        }
        return Long.parseLong(str.toString());
    }

    //控制字符串数据的长度
    private static final int LENGTH = 8;

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test() {
        System.out.println(generate());
    }

}
