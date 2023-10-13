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

    public static User create(Long id, String name, String email, String password) {
        return new User(id, name, email, password, null);
    }
}
