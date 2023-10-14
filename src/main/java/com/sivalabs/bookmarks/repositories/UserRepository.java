package com.sivalabs.bookmarks.repositories;

import com.sivalabs.bookmarks.jooq.tables.records.UsersRecord;
import com.sivalabs.bookmarks.models.User;
import com.sivalabs.bookmarks.models.UserPreferences;
import org.jooq.DSLContext;
import org.jooq.Record4;
import org.jooq.RecordMapper;
import org.jooq.SelectJoinStep;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.sivalabs.bookmarks.jooq.tables.UserPreferences.USER_PREFERENCES;
import static com.sivalabs.bookmarks.jooq.tables.Users.USERS;
import static org.jooq.Records.mapping;
import static org.jooq.impl.DSL.row;

@Repository
public class UserRepository {
    private final DSLContext dsl;

    public UserRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public List<User> findAllUsers() {

        return dsl.select(USERS.ID, USERS.NAME, USERS.EMAIL, USERS.PASSWORD)
                .from(USERS)
                .fetch(mapping(User::create));

        /*
        return dsl.select(USERS.ID, USERS.NAME, USERS.EMAIL, USERS.PASSWORD)
                .from(USERS)
                .fetch(mapping((id, name, email, password) -> new User(id, name, email, password)));
        */

        /*
        return dsl.select(USERS.ID, USERS.NAME, USERS.EMAIL, USERS.PASSWORD)
                .from(USERS)
                .fetch(r -> r.into(User.class));
        */

        /*
        return dsl.select(USERS.ID, USERS.NAME, USERS.EMAIL, USERS.PASSWORD)
                .from(USERS)
                .fetch(r -> new User(
                        r.get(USERS.ID),
                        r.get(USERS.NAME),
                        r.get(USERS.EMAIL),
                        r.get(USERS.PASSWORD))
                );
        */
    }

    public Optional<User> findUserById(Long id) {
        Optional<User> result;

        /*result = dsl
                .select(
                    USERS.ID, USERS.NAME, USERS.EMAIL, USERS.PASSWORD,
                    USER_PREFERENCES.ID, USER_PREFERENCES.THEME, USER_PREFERENCES.LANGUAGE)
                .from(USERS.leftOuterJoin(USER_PREFERENCES).on(USERS.PREFERENCES_ID.eq(USER_PREFERENCES.ID)))
                .where(USERS.ID.eq(id))
                .fetchOptional(record -> new User(
                        record.get(USERS.ID),
                        record.get(USERS.NAME),
                        record.get(USERS.EMAIL),
                        record.get(USERS.PASSWORD),
                        new UserPreferences(
                                record.get(USER_PREFERENCES.ID),
                                record.get(USER_PREFERENCES.THEME),
                                record.get(USER_PREFERENCES.LANGUAGE)
                        )
                ));*/

        /*result = dsl
                .select(
                    USERS.ID, USERS.NAME, USERS.EMAIL, USERS.PASSWORD,
                    USERS.userPreferences().ID, USERS.userPreferences().THEME, USERS.userPreferences().LANGUAGE)
                .from(USERS)
                .where(USERS.ID.eq(id))
                .fetchOptional(record -> new User(
                        record.get(USERS.ID),
                        record.get(USERS.NAME),
                        record.get(USERS.EMAIL),
                        record.get(USERS.PASSWORD),
                        new UserPreferences(
                                record.get(USER_PREFERENCES.ID),
                                record.get(USER_PREFERENCES.THEME),
                                record.get(USER_PREFERENCES.LANGUAGE)
                        )
                ));*/

        result = dsl
                    .select(
                        USERS.ID, USERS.NAME, USERS.EMAIL, USERS.PASSWORD,
                        row(
                            USERS.userPreferences().ID,
                            USERS.userPreferences().THEME,
                            USERS.userPreferences().LANGUAGE
                        ).mapping(UserPreferences::new).as("preferences"))
                .from(USERS)
                .where(USERS.ID.eq(id))
                .fetchOptional()
                .map(mapping((userId, name, email, password, preferences) ->
                        new User(userId, name, email, password, preferences)));

        return result;
    }

    public Optional<User> findUserByEmail(String email){
        return getSelectUserSpec()
                .where(USERS.EMAIL.equalIgnoreCase(email))
                .fetchOptional(new UserRecordMapper());
    }

    public boolean existsByEmail(String email) {
        return dsl.fetchExists(dsl.selectFrom(USERS)
                .where(USERS.EMAIL.equalIgnoreCase(email)));
    }

    public User createUser(User user) {
        UsersRecord record = dsl.newRecord(USERS, user);
        record.store();
        return new User(record.getId(),
                record.getName(),
                record.getEmail(),
                record.getPassword());

        /*
        UsersRecord record = dsl.newRecord(USERS);
        record.setName(user.name());
        record.setEmail(user.email());
        record.setPassword(user.password());
        record.store();
        return new User(record.getId(),
                        record.getName(),
                        record.getEmail(),
                        record.getPassword());
        */

        /*
        return dsl.insertInto(USERS, USERS.NAME, USERS.EMAIL, USERS.PASSWORD)
                .values(user.name(), user.email(), user.password())
                .returning()
                .fetchOne(record -> new User(
                        record.getId(),
                        record.getName(),
                        record.getEmail(),
                        record.getPassword()));
        */

        /*
        return dsl.insertInto(USERS)
                .set(USERS.NAME, user.name())
                .set(USERS.EMAIL, user.email())
                .set(USERS.PASSWORD, user.password())
                .returning()
                .fetchOne(record -> new User(
                        record.getId(),
                        record.getName(),
                        record.getEmail(),
                        record.getPassword()));
        */

    }

    public void updateUser(User user) {
        dsl.update(USERS)
                .set(USERS.NAME, user.name())
                .where(USERS.ID.eq(user.id()))
                .execute();
        /*
        dsl.fetchOptional(USERS, USERS.ID.eq(user.id()))
                .ifPresent(record -> {
                    record.setName(user.name());
                    record.store();
                });
        */
    }

    public void deleteUser(Long id) {
        dsl.deleteFrom(USERS)
                .where(USERS.ID.eq(id))
                .execute();
    }

    private SelectJoinStep<Record4<Long, String, String, String>> getSelectUserSpec() {
        return dsl.select(USERS.ID, USERS.NAME, USERS.EMAIL, USERS.PASSWORD)
                .from(USERS);
    }

    static class UserRecordMapper
            implements RecordMapper<Record4<Long, String, String, String>, User> {
        @Override
        public User map(Record4<Long, String, String, String> userRecord) {
            return new User(userRecord.get(USERS.ID),
                    userRecord.get(USERS.NAME),
                    userRecord.get(USERS.EMAIL),
                    userRecord.get(USERS.PASSWORD)
            );
        }
    }
}
