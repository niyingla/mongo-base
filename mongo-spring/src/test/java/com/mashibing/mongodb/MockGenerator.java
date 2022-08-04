package com.mashibing.mongodb;

import com.mashibing.mongodb.entity.Order;
import com.mashibing.mongodb.entity.OrderDetail;
import com.mashibing.mongodb.enums.*;
import com.mashibing.mongodb.util.RandomUtil;
import com.mashibing.mongodb.util.TimeTool;
import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-12-05 16:01
 */
public class MockGenerator extends MongodbApplicationTests {

    @Resource
    private MongoTemplate mongoTemplate;

    @Test
    public void insert() throws InterruptedException {
        int num = 3000;
        int threadNum = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            executorService.execute(()->{
                List<Order> list = new CopyOnWriteArrayList<>();
                for (int i1 = 0; i1 < num; i1++) {
                    list.add(getOrderStr());
                    if (list.size() == 1000) {
                        mongoTemplate.insertAll(list);
                        list.clear();
                    }

                }
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行完成");
    }
    @Test
    public void time(){
        TimeTool.check("30万数据保存",()->{
            try {
                insert();
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        });
    }

    public Order getOrderStr(){
        Order order = new Order();
        order.setProvince(AddressEnum.getRandomAddress());
        order.setShopName(ShopNameEnum.getRandomShopName());
        order.setPhone(NameAndPhone.getPhone());
        order.setOrderDate(DateGenerator.randomDate("2020-01-01","2020-11-31"));
        order.setStatus(OrderStatusEnum.getRandomStatus());
        order.setWaybillNo("JD" + NumberGenerator.generate());
        order.setShippingFee(10);

        List<OrderDetail> orderDetailList = new ArrayList<>();
        int num = RandomUtil.getNum(1, 5);
        for (int i = 1; i <= num; i++) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setId((long) i);
            ProductEnum product = ProductEnum.getRandomProduct();
            orderDetail.setSku("SKU" + NumberGenerator.generate());
            orderDetail.setProductName(product.getValue());
            orderDetail.setQty(RandomUtil.getNum(1, 3));
            orderDetail.setPrice(product.getPrice());
            orderDetail.setCost((int) (product.getPrice() * 0.8));
            orderDetailList.add(orderDetail);
        }
        order.setTotal(RandomUtil.getNum(2000,10000));
        order.setOrderDetailList(orderDetailList);
        return order;
    }
}
