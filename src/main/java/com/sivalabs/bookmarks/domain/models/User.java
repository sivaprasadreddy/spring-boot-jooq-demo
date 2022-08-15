package com.sivalabs.bookmarks.domain.models;

public record User (
     Long id,
     String name,
     String email,
     String password,
     Address address
){
    public User(Long id, String name, String password, String email) {
        this(id, name, email, password, null);
    }
}
