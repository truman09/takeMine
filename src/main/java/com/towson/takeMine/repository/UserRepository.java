
package com.towson.takeMine.repository;


import com.towson.takeMine.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Override
    List<User> findAll();

    @Override
    <S extends User> S save(S entity);

    @Override
    User getById(String s);

    @Override
    void delete(User entity);

    User findByTuEmail(String email);
}
