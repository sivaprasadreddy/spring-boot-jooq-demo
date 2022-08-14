package com.sivalabs.bookmarks.domain.models;

import java.util.List;

public record Bookmark (
    Long id,
    String title,
    String url,
    User createdBy,
    List<Tag> tags
){
}
