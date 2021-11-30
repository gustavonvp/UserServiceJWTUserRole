package io.getarrays.userservice.userservice.repository;

import io.getarrays.userservice.userservice.domain.Role;
import io.getarrays.userservice.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {

    Role findByName(String username);
}
