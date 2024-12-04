
package com.towson.takeMine.repository;


import com.towson.takeMine.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {
    List<Resource> findByResNameContainingIgnoreCase(String resName);

    @Override
    Resource getById(Integer integer);

    @Override
    <S extends Resource> S save(S entity);

    List<Resource> findAllByTuId(String tuId);

    @Override
    List<Resource> findAll();

    @Override
    void delete(Resource entity);
}
