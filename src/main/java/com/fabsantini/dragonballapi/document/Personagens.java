package com.fabsantini.dragonballapi.document;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import org.springframework.data.annotation.Id;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@DynamoDBTable(tableName ="Dragonball_Api_Table")


public class Personagens {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanet() {
        return planet;
    }

    public void setUniverse(String planet) {
        this.planet = planet;
    }

    public int getFilms() {
        return power;
    }

    public void setFilms(int power) {
        this.power = power;
    }

    @Id
    @DynamoDBHashKey (attributeName = "id")
    private String id;

    @DynamoDBAttribute (attributeName = "name")
    private String name;

    @DynamoDBAttribute (attributeName = "planet")
    private String planet;

    @DynamoDBAttribute (attributeName = "power")
    private int power;

    //Criando as variáveis usadas na tabela de heróis;
    public Personagens(String id, String name, String planet, int power) {
        this.id = id;
        this.name = name;
        this.planet = planet;
        this.power = power;
    }

}

