package com.sivalabs.bookmarks.domain.repositories;


import com.sivalabs.bookmarks.domain.models.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {

    Optional<User> findByEmail(String email){
        return null;
    }

    boolean existsByEmail(String email) {
        return false;
    }

    public User getById(long l) {
        return null;
    }
}
