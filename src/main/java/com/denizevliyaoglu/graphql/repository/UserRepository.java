package com.denizevliyaoglu.graphql.repository;

import com.denizevliyaoglu.graphql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
