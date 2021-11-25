package com.bulgogifriedrice.backend.domain.auth.repository;

import com.bulgogifriedrice.backend.domain.auth.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
