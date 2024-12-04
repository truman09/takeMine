
package com.towson.takeMine.repository;

import com.towson.takeMine.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Integer> {
    List<Borrow> findByResId(int resId);
    List<Borrow> findByBorrowerTuId(String borrowerTuId);

    @Override
    Optional<Borrow> findById(Integer integer);

    @Override
    <S extends Borrow> S save(S entity);

    @Override
    List<Borrow> findAllById(Iterable<Integer> integers);

    @Override
    void delete(Borrow entity);
}
