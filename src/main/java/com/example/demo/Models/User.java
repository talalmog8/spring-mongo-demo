package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

public class User {
    @Id
    private String id;
    private final Permissions permissions;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public User(@JsonProperty("permissions")Permissions permissions) {
        this.permissions = permissions;
    }

    public Permissions getPermissions() {
        return permissions;
    }

    public String getId() {
        return id;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
