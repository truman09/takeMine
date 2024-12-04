package com.towson.takeMine.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TAGGEDAS")
public class TaggedAs {
    @EmbeddedId
    private TaggedAsId id;

    public TaggedAs() {}

    public TaggedAs(TaggedAsId id) {
        this.id = id;
    }

    public TaggedAsId getId() {
        return id;
    }

    public void setId(TaggedAsId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TaggedAs{" +
                "id=" + id +
                '}';
    }
}
