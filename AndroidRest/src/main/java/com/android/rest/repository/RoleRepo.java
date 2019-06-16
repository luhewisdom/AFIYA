package com.android.rest.repository;

import com.android.rest.domain.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role, Long> {
    Role findByRole(String role);

}