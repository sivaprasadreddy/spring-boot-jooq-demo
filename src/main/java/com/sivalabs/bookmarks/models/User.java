package com.sivalabs.bookmarks.models;

public record User (
     Long id,
     String name,
     String email,
     String password,
     UserPreferences preferences
) {
    public User(Long id, String name, String email, String password) {
        this(id, name, email, password, null);
    }
}
