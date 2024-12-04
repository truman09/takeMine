package com.towson.takeMine.controller;

import com.towson.takeMine.entity.Borrow;
import com.towson.takeMine.service.BorrowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {
    private final BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {

        this.borrowService = borrowService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Borrow>> getBorrows() {
        return ResponseEntity.ok(borrowService.getAllBorrows());
    }
    @GetMapping("/all/resId/{resId}")
    public ResponseEntity<List<Borrow>> getAllByResId(@PathVariable int resId) {
        return ResponseEntity.ok(borrowService.getAllByResId(resId));
    }
    @GetMapping("/all/BorrowerTuId/{BorrowerTuId}")
    public ResponseEntity<List<Borrow>> getAllByBorrowerTuId(@PathVariable String BorrowerTuId) {
        return ResponseEntity.ok(borrowService.getAllByBorrowerTuId(BorrowerTuId));
    }

    @GetMapping("/{borrowId}")
    public ResponseEntity<Borrow> getBorrow(@PathVariable int borrowId) {
        return ResponseEntity.ok(borrowService.getAByBorrowId(borrowId));
    }
    @PostMapping("/addBorrow")
    public ResponseEntity<Borrow> registerResource(@RequestBody Borrow borrow) {
        System.out.println(borrow.toString() + "..........");
        return ResponseEntity.ok(borrowService.addBorrow(borrow));
    }
    @PutMapping("/{borrowId}")
    public ResponseEntity<Borrow> updateBorrow(@PathVariable int borrowId,
                                                   @RequestBody Borrow borrow) {
        return ResponseEntity.ok(borrowService.updateResource(borrowId, borrow));
    }
}
