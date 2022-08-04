package com.mashibing.mongodb.util;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-12-05 13:19
 */
public class RandomUtil {
    public static int getNum(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }
}
