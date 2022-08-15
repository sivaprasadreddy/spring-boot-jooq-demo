package com.sivalabs.bookmarks.domain.repositories;

import com.sivalabs.bookmarks.domain.models.Address;
import com.sivalabs.bookmarks.domain.models.User;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record4;
import org.jooq.RecordMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.sivalabs.bookmarks.jooq.tables.Users.USERS;
import static org.jooq.impl.DSL.row;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final DSLContext dsl;

    public Optional<User> findByEmail(String email){
        User user = dsl.select(USERS.ID, USERS.NAME, USERS.EMAIL,
                row(
                    USERS.addresses().ID,
                    USERS.addresses().STREET,
                    USERS.addresses().CITY,
                    USERS.addresses().STATE,
                    USERS.addresses().ZIP,
                    USERS.addresses().COUNTRY
                ).mapping(Address::new))
                .from(USERS)
                .where(USERS.EMAIL.equalIgnoreCase(email))
                .fetchOne(new UserRecordMapper());
        return Optional.ofNullable(user);
    }

    public boolean existsByEmail(String email) {
        return dsl.fetchExists(dsl.selectFrom(USERS).where(USERS.EMAIL.equalIgnoreCase(email)));
    }

    public Optional<User> getById(long id) {
        User user = dsl.select(USERS.ID, USERS.NAME, USERS.EMAIL,
                        row(
                            USERS.addresses().ID,
                            USERS.addresses().STREET,
                            USERS.addresses().CITY,
                            USERS.addresses().STATE,
                            USERS.addresses().ZIP,
                            USERS.addresses().COUNTRY
                        ).mapping(Address::new)
                )
                .from(USERS)
                .where(USERS.ID.eq(id))
                .fetchOne(new UserRecordMapper());
        return Optional.ofNullable(user);
    }
}

class UserRecordMapper implements RecordMapper<Record4<Long, String, String, Address>, User> {
    @Override
    public User map(Record4<Long, String, String, Address> userRecord) {
        return new User(userRecord.value1(),
                userRecord.value2(),
                userRecord.value3(),
                userRecord.value4());
    }
}