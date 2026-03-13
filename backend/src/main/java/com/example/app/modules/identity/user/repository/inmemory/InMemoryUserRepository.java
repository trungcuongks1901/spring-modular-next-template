package com.example.app.modules.identity.user.repository.inmemory;

import com.example.app.modules.identity.role.entity.Role;
import com.example.app.modules.identity.user.entity.User;
import com.example.app.modules.identity.user.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private final Map<Long, User> data = new ConcurrentHashMap<>();

    public InMemoryUserRepository() {
        data.put(1L, new User(1L, "admin", "admin123", Role.ADMIN, null, true));
        data.put(2L, new User(2L, "user1", "user123", Role.OFFICE, 1L, true));
    }

    @Override
    public User save(User user) { data.put(user.id(), user); return user; }
    @Override
    public List<User> findAll() { return new ArrayList<>(data.values()); }
    @Override
    public Optional<User> findById(Long id) { return Optional.ofNullable(data.get(id)); }
    @Override
    public Optional<User> findByUsername(String username) { return data.values().stream().filter(u -> u.username().equals(username)).findFirst(); }
}
