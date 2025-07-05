package com.example.easydb.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.example.easydb.utils.SubscriptionType;
import org.springframework.data.mongodb.core.mapping.Encrypted;

import java.util.UUID;

@Document(collection = "users")
@Getter
@Setter
public class User {
    @Id
    private String id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String mail;

    @Size(min = 6, max = 14, message = "Password must be between 6-14 characters.")
    private String password;

    private SubscriptionType subscriptionType;

    public User() {
        this.id = UUID.randomUUID().toString();
        this.subscriptionType = SubscriptionType.BRONZE;
    }
}
