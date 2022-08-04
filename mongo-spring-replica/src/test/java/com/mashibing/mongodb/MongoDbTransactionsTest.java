package com.mashibing.mongodb;

import com.mashibing.mongodb.service.FruitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2021-01-23 13:42
 */
public class MongoDbTransactionsTest extends MongodbApplicationTests{

    @Autowired
    FruitService fruitService;

    @Test
    public void test() {
        fruitService.insert();
    }
}
