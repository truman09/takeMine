package com.towson.takeMine.service;

import com.towson.takeMine.entity.Resource;
import com.towson.takeMine.repository.ResourceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {
    private final ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public Resource addResource(Resource resource) {
        //TODO:
//        if (resourceRepository.findById(resource.getResId()) != null) {
//            throw new IllegalArgumentException("Resource already exists");
//        }
        return resourceRepository.save(resource);
    }
    public List<Resource> getAllResource (){
        return resourceRepository.findAll();
    }
    public List<Resource> getAllResourceByTuId (String tuId){
        return Optional.ofNullable(resourceRepository.findAllByTuId(tuId)).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    public Resource updateResource(int resourceId, Resource updates) {
        Resource resource = resourceRepository.findById(resourceId).orElseThrow(() -> new IllegalArgumentException("Resource not found"));
        return resourceRepository.save(updates);
    }
    public Resource getResource (int resourceId){
        return resourceRepository.findById(resourceId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteResource (int resourceId){
        Optional<Resource> resource = resourceRepository.findById(resourceId);
        if (resource.isEmpty()) {
            throw new IllegalArgumentException("Resource already exists");
        }
         resourceRepository.delete(resource.get());
    }

}
