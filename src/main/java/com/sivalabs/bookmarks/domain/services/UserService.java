package com.sivalabs.bookmarks.domain.services;

import com.sivalabs.bookmarks.domain.models.User;
import com.sivalabs.bookmarks.domain.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
    public Optional<User> getById(long id) {
        return userRepository.getById(id);
    }
}
