package com.sivalabs.bookmarks.domain.repositories;

import com.sivalabs.bookmarks.domain.models.User;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.sivalabs.bookmarks.jooq.tables.Users.USERS;
import static org.jooq.Records.mapping;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final DSLContext dsl;

    public Optional<User> findByEmail(String email){
        return Optional.ofNullable(
                dsl.select(USERS.ID, USERS.NAME)
                        .from(USERS)
                        .where(USERS.EMAIL.equalIgnoreCase(email))
                .fetchOne(mapping(User::new)));
    }

    public boolean existsByEmail(String email) {
        return dsl.fetchExists(dsl.selectFrom(USERS).where(USERS.EMAIL.equalIgnoreCase(email)));
    }

    public Optional<User> getById(long id) {
        return Optional.ofNullable(
                dsl.select(USERS.ID, USERS.NAME)
                        .from(USERS)
                        .where(USERS.ID.eq(id))
                        .fetchOne(mapping(User::new)));
    }
}
