package com.towson.takeMine.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "CATEGORY", schema = "TAKE_MINE")
public class Category {
    public Category() {
    }

    @Id
    @Column(nullable = false, name="CNAME")
    private String cName;

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cName='" + cName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(cName, category.cName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cName);
    }
}
