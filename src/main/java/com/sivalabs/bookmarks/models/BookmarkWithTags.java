package com.sivalabs.bookmarks.models;

import java.util.List;

public record BookmarkWithTags(Long id, String title, String url, List<TagInfo> tags) {
    public record TagInfo (Long id, String name){}
}