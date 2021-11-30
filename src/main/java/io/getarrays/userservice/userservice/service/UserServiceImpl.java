package io.getarrays.userservice.userservice.service;

import io.getarrays.userservice.userservice.domain.Role;
import io.getarrays.userservice.userservice.domain.User;
import io.getarrays.userservice.userservice.repository.RoleRepo;
import io.getarrays.userservice.userservice.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;


    public UserServiceImpl(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to the database", user.getName());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role{} to the database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {

        log.info("Adding role {} to user {}", roleName, username);

        User user = userRepo.findByUsername(username);

        Role role = roleRepo.findByName(roleName);

        user.getRoles().add(role);

    }

    @Override
    public User getUser(String username) {

        log.info("Fetching user {}", username);

        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUser() {
        log.info("Fetching all users");
         return userRepo.findAll();
    }
}
