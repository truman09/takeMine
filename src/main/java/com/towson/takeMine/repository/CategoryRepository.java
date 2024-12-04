package com.towson.takeMine.repository;

import com.towson.takeMine.entity.Borrow;
import com.towson.takeMine.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // Find a category by its name (used in service)
    Optional<Category> findByCName(String cName);

    // Save a new category or update an existing one (used in service)
    Category save(Category category);
}
