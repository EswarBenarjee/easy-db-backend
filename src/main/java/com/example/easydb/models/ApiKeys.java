package com.example.easydb.models;

import org.springframework.data.annotation.Id;
import java.util.UUID;

public class ApiKeys {
    @Id
    private String id;

    private String key = UUID.randomUUID().toString();

    // Add relation
    private String userId;
}
