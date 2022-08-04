package com.mashibing.mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-11-28 22:53
 */
@Data
@AllArgsConstructor
public class Apple {

    /**
     * id
     */
    private String color;
    /**
     * 价格
     */
    private Integer price;



}
