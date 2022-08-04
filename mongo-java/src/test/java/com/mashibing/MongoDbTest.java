package com.mashibing;

import com.alibaba.fastjson.JSON;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import lombok.extern.slf4j.Slf4j;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;
import org.junit.jupiter.api.Test;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-11-28 22:16
 */
@Slf4j
public class MongoDbTest {

    private static final String DATABASE = "test";


    public MongoCollection<Document> getDb(String collectionName){
        //1.创建链接
        ConnectionString connString = new ConnectionString("mongodb://192.168.254.211:27017/test");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .retryWrites(true)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        return mongoClient.getDatabase(DATABASE).getCollection(collectionName);
    }
    @Test
    public void insert() {
        String collectionName = "shop";
        MongoCollection<Document> collection = getDb(collectionName);
        Document document = new Document();
        document.append("name","手机");
        document.append("price",8000);
        InsertOneResult insertOneResult = collection.insertOne(document);
        System.out.println(JSON.toJSONString(insertOneResult, true));
    }
    @Test
    public void update() {
        String collectionName = "shop";
        MongoCollection<Document> collection = getDb(collectionName);
        Bson condition = Filters.and(Filters.eq("name", "手机"));
        Bson update =  new Document("$set", new Document().append("price", 7000));
        collection.updateMany(condition,update);
        System.out.println("修改成功");
    }
    @Test
    public void delete() {
        String collectionName = "shop";
        MongoCollection<Document> collection = getDb(collectionName);
        Bson condition = Filters.and(Filters.eq("name", "手机"));
        collection.deleteMany(condition);
        System.out.println("删除成功");
    }
    @Test
    public void findAll(){
        String collectionName = "shop";
        MongoCollection<Document> collection = getDb(collectionName);
        FindIterable<Document> documents = collection.find();
        documents.forEach(item->{
            System.out.println(item.get("name") + "--" + item.get("price"));
        });
    }
    @Test
    public void findByConditation(){
        String collectionName = "shop";
        MongoCollection<Document> collection = getDb(collectionName);
        Bson condition = Filters.and(Filters.eq("name", "手机"));
        FindIterable<Document> documents = collection.find(condition);
        documents.forEach(item->{
            System.out.println(item.get("name"));
        });
    }

}
