package com.towson.takeMine.repository;

import com.towson.takeMine.entity.TaggedAs;
import com.towson.takeMine.entity.TaggedAsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaggedAsRepository extends JpaRepository<TaggedAs, TaggedAsId> {
    @Override
    Optional<TaggedAs> findById(TaggedAsId taggedAsId);
    List<TaggedAs> findById_ResId(int resId);
    List<TaggedAs> findById_CName(String cName);
}
