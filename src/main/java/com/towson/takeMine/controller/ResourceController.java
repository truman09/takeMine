package com.towson.takeMine.controller;

import com.towson.takeMine.entity.Resource;
import com.towson.takeMine.entity.User;
import com.towson.takeMine.service.ResourceService;
import com.towson.takeMine.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {
    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {

        this.resourceService = resourceService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Resource>> getResource() {
        return ResponseEntity.ok(resourceService.getAllResource());
    }

    @GetMapping("/all/{tuId}")
    public ResponseEntity<List<Resource>> getResource(@PathVariable String tuId) {
        return ResponseEntity.ok(resourceService.getAllResourceByTuId(tuId));
    }
    @PostMapping("/addResource")
    public ResponseEntity<Resource> registerResource(@RequestBody Resource resource) {
        System.out.println(resource.toString() + "..........");
        return ResponseEntity.ok(resourceService.addResource(resource));
    }

    @PutMapping("/{resourceId}")
    public ResponseEntity<Resource> updateResource(@PathVariable int resourceId,
                                               @RequestBody Resource resource) {
        return ResponseEntity.ok(resourceService.updateResource(resourceId, resource));
    }

    @GetMapping("/{resourceId}")
    public ResponseEntity<Resource> getResource(@PathVariable int resourceId) {
        return ResponseEntity.ok(resourceService.getResource(resourceId));
    }
}
