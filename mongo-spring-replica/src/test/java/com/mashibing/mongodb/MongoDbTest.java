package com.mashibing.mongodb;

import com.alibaba.fastjson.JSON;
import com.mashibing.mongodb.entity.Order;
import com.mashibing.mongodb.entity.OrderDetail;
import com.mashibing.mongodb.enums.*;
import com.mashibing.mongodb.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-11-28 22:16
 */
@Slf4j
public class MongoDbTest extends MongodbApplicationTests{

    @Resource
    private MongoTemplate mongoTemplate;

    @Test
    public void insert() {
        Order insert = mongoTemplate.insert(getOrderStr());
        System.out.println(JSON.toJSONString(insert, true));
    }
    @Test
    public void update() {
        Query query = new Query();
        query.addCriteria(Criteria.where("province").is("安徽"));
        Update update = Update.update("shippingFee", 20);
        mongoTemplate.updateMulti(query, update, Order.class);
        System.out.println("修改成功");
    }
    @Test
    public void delete() {
        Query query = new Query();
        query.addCriteria(Criteria.where("province").is("安徽"));
        mongoTemplate.remove(query,Order.class);
        System.out.println("删除成功");
    }
    @Test
    public void find(){
        Query query = new Query();
        List<Order> orders = mongoTemplate.find(query, Order.class);
        orders.forEach(item->{
            System.out.println(JSON.toJSONString(item, true));
        });
    }
    @Test
    public void findByCondition(){
        Query query = new Query();
        query.addCriteria(Criteria.where("province").is("安徽"));
        List<Order> orders = mongoTemplate.find(query, Order.class);
        orders.forEach(item-> System.out.println(JSON.toJSONString(item, true)));
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
