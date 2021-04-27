package com.fabsantini.dragonballapi.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import static com.fabsantini.dragonballapi.constans.PersonagensConstant.ENDPOINT_DYNAMO;
import static com.fabsantini.dragonballapi.constans.PersonagensConstant.REGION_DYNAMO;

public class PersonagensData {

    public static void main(String[] args) throws Exception {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Dragonball_Api_Table");

        Item personagem = new Item()
                .withPrimaryKey("id", "2")
                .withString("name", "Goku")
                .withString("planet", "Sayajin")
                .withNumber("power", 20000);

        Item personagem2 = new Item()
                .withPrimaryKey("id", "3")
                .withString("name", "Vegetta")
                .withString("planet", "Sayajin")
                .withNumber("power", 19999);

        Item personagem3 = new Item()
                .withPrimaryKey("id", "4")
                .withString("name", "Gohan")
                .withString("planet", "Terra")
                .withNumber("power", 18000);

        PutItemOutcome outcome1 = table.putItem(personagem);
        PutItemOutcome outcome2 = table.putItem(personagem2);
        PutItemOutcome outcome3 = table.putItem(personagem3);

    }

}
