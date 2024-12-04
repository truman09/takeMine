package com.towson.takeMine.service;

import com.towson.takeMine.entity.Borrow;
import com.towson.takeMine.entity.Resource;
import com.towson.takeMine.repository.BorrowRepository;
import com.towson.takeMine.repository.ResourceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowService {
    private final BorrowRepository borrowRepository;

    public BorrowService(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    public Borrow addBorrow(Borrow borrow) {
        return borrowRepository.save(borrow);
    }
    public List<Borrow> getAllBorrows (){
        return borrowRepository.findAll();
    }
    public List<Borrow> getAllByBorrowerTuId (String borrowerTuId){
        return borrowRepository.findByBorrowerTuId(borrowerTuId);
    }
    public List<Borrow> getAllByResId (int borrowerTuId){
        return borrowRepository.findByResId(borrowerTuId);
    }
    public Borrow getAByBorrowId (int borrowId){
        Borrow borrow = borrowRepository.findById(borrowId)
                .orElseThrow(() -> new IllegalArgumentException("Borrow not found"));
        return borrow;
    }
    public Borrow updateResource(int borrowId, Borrow updates) {
        Borrow borrow = borrowRepository.findById(borrowId)
                .orElseThrow(() -> new IllegalArgumentException("Borrow not found"));
        return borrowRepository.save(updates);
    }


    public void deleteBorrow (int borrowId){
        Optional<Borrow> borrow = borrowRepository.findById(borrowId);
        if (borrow.isEmpty()) {
            throw new IllegalArgumentException("Resource already exists");
        }
        borrowRepository.delete(borrow.get());
    }
}
