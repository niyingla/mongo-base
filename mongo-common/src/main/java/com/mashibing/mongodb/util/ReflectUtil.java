package com.mashibing.mongodb.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-12-05 15:51
 */
public class ReflectUtil {
    public static List<String> getClassFiledName(Object cl){
        Field[] fields=cl.getClass().getDeclaredFields();
        List<String> fieldNames=new ArrayList<>();
        for(int i=0;i<fields.length;i++){
            fieldNames.add(fields[i].getName());
        }
        return fieldNames;
    }

    public static Object getClassFieldValueByName(String fieldName, Object cl) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = cl.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(cl, new Object[] {});
            return value;
        } catch (Exception e) {
            return null;
        }
    }

}
