package com.sivalabs.bookmarks.domain.models;

public record User (
     Long id,
     String name,
     String email,
     Address address
){
    public User(Long id, String name, String email) {
        this(id, name, email, null);
    }
}
