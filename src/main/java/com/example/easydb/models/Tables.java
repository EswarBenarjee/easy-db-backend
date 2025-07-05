package com.example.easydb.models;

import org.bson.BinaryVector;
import org.springframework.data.annotation.Id;

import java.util.Map;

public class Tables {
    @Id
    private String id;

    private String name;

    Map<String, String> columns;
}
