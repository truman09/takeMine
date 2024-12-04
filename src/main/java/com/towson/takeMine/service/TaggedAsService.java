package com.towson.takeMine.service;

import com.towson.takeMine.entity.Category;
import com.towson.takeMine.entity.TaggedAs;
import com.towson.takeMine.entity.TaggedAsId;
import com.towson.takeMine.repository.CategoryRepository;
import com.towson.takeMine.repository.TaggedAsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaggedAsService {

    private final TaggedAsRepository taggedAsRepository;
    private final CategoryRepository categoryRepository;

    public TaggedAsService(TaggedAsRepository taggedAsRepository, CategoryRepository categoryRepository) {
        this.taggedAsRepository = taggedAsRepository;
        this.categoryRepository = categoryRepository;
    }

    public TaggedAs createOrUpdateTaggedAs(TaggedAs taggedAs) {
        String cName = taggedAs.getId().getcName();
        Optional<Category> category = categoryRepository.findByCName(cName);
        Category newCategory = new Category();
        if (category.isEmpty()){
            newCategory.setcName(cName);
        }
        return taggedAsRepository.save(taggedAs);
    }

    public TaggedAs getTaggedAsById(TaggedAsId id) {
        return taggedAsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TaggedAs entry not found for the given composite key"));
    }

    public List<TaggedAs> getTaggedAsByIdResId(int resId) {
        List<TaggedAs> taggedAs = taggedAsRepository.findById_ResId(resId);
        if (taggedAs.isEmpty()){
        throw  new IllegalArgumentException("TaggedAs entry not found for the given resId");
        }
        return taggedAs;
    }
    public List<TaggedAs> getTaggedAsByIdCName(String cName) {
        List<TaggedAs> taggedAs = taggedAsRepository.findById_CName(cName);
        if (taggedAs.isEmpty()){
            throw  new IllegalArgumentException("TaggedAs entry not found for the given resId");
        }
        return taggedAs;
    }

    public void deleteTaggedAs(TaggedAsId id) {
        taggedAsRepository.deleteById(id);
    }
}
