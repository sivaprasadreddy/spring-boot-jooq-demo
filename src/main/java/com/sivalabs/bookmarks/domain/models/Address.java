package com.sivalabs.bookmarks.domain.models;

public record Address (
    Long id,
    String street,
    String city,
    String state,
    String zip,
    String country){
}
