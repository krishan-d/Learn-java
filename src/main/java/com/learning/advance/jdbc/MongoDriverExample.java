package com.learning.advance.jdbc;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

//import java.util.logging.Level;
//import java.util.logging.Logger;

public class MongoDriverExample {
    /*
    Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
    */
//  static Logger LOGGER = LoggerFactory.getLogger(MongoDriverExample.class);

    public static void main(String[] args) {

        try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {
            //Connecting To MongoDB

            //Creating DataBase
            MongoDatabase db = mongoClient.getDatabase("MONGODB_JAVA");

            //Creating Collection/Table
            MongoCollection<Document> collection = db.getCollection("STUDENT");

            /*
            //Creating Document/Record
            Document doc = new Document();
            doc.put("sId", 100046);
            doc.put("name", "Edwina");

            collection.insertOne(doc);
            System.out.println("Inserted document!" );
            */


            //Accessing Data
            FindIterable<Document> data = collection.find();
            for (Document record : data) {
                System.out.println(record.getInteger("sId") + ":" + record.getString("name"));
            }

            //Access in JSON Format:
            for (Document record : data) {
                System.out.println(record.toJson());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
