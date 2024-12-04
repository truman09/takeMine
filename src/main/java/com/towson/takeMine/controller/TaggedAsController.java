package com.towson.takeMine.controller;

import com.towson.takeMine.entity.TaggedAs;
import com.towson.takeMine.entity.TaggedAsId;
import com.towson.takeMine.service.TaggedAsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TaggedAsController {

    private final TaggedAsService taggedAsService;

    public TaggedAsController(TaggedAsService taggedAsService) {
        this.taggedAsService = taggedAsService;
    }

    @PostMapping
    public ResponseEntity<TaggedAs> createTaggedAs(@RequestBody TaggedAs taggedAs) {
        return ResponseEntity.ok(taggedAsService.createOrUpdateTaggedAs(taggedAs));
    }

    @PutMapping
    public ResponseEntity<TaggedAs> updateTaggedAs(@RequestBody TaggedAs taggedAs) {
        return ResponseEntity.ok(taggedAsService.createOrUpdateTaggedAs(taggedAs));
    }

    @GetMapping
    public ResponseEntity<TaggedAs> getTaggedAsById(@RequestBody TaggedAsId tagId) {
        return ResponseEntity.ok(taggedAsService.getTaggedAsById(tagId));
    }

    @GetMapping("/resId/{resId}")
    public ResponseEntity<List<TaggedAs>> getTaggedAsById(@PathVariable int resId) {
        return ResponseEntity.ok(taggedAsService.getTaggedAsByIdResId(resId));
    }

    @GetMapping("/cName/{cName}")
    public ResponseEntity<List<TaggedAs>> getTaggedAsByIdCName(@PathVariable String cName) {
        return ResponseEntity.ok(taggedAsService.getTaggedAsByIdCName(cName));
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteTaggedAs(@RequestBody TaggedAsId id) {
        taggedAsService.deleteTaggedAs(id);
        return ResponseEntity.noContent().build();
    }
}
