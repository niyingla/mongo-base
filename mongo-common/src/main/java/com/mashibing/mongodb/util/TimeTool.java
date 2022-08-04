package com.mashibing.mongodb.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>粗略计算 执行方法时间长短工具类</p>
 *
 * @author sunzhiqiang23
 * @date 2019/12/12 02:05
 */
public class TimeTool {
    private static final SimpleDateFormat FMT = new SimpleDateFormat("HH:mm:ss.SSS");

    public interface Task {
        void execute();
    }

    public static void check(String title, Task task) {
        if (task == null) {
            return;
        }
        title = (title == null) ? "" : ("【" + title + "】");
        System.out.println("--------------------------");
        System.out.println(title);
        System.out.println("开始：" + FMT.format(new Date()));
        long begin = System.currentTimeMillis();
        task.execute();
        long end = System.currentTimeMillis();

        System.out.println("结束：" + FMT.format(new Date()));
        double delta = (end - begin) / 1000.0;
        System.out.println("耗时：" + delta + "秒");
        System.out.println("--------------------------");

    }

}
