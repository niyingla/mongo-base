package com.mashibing.mongodb.service;

import com.mashibing.mongodb.entity.Apple;
import com.mashibing.mongodb.entity.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2021-01-23 18:47
 */
@Service
public class FruitService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Transactional(rollbackFor = Exception.class)
    public void insert() {
        Apple apple = new Apple("红色", 10);
        Fruit fruit = new Fruit("黄色", "香蕉");
        mongoTemplate.insert(apple);
        mongoTemplate.insert(fruit);
        System.out.println(1 / 0);
    }
}
