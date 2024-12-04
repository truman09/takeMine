package com.towson.takeMine.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TaggedAsId implements Serializable {
    @Column(name = "RES_ID", nullable = false)
    private int resId;
    @Column(name = "CNAME", nullable = false)
    private String cName;

    public TaggedAsId() {
    }

    public TaggedAsId(int resId, String cName) {
        this.resId = resId;
        this.cName = cName;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaggedAsId that = (TaggedAsId) o;
        return resId == that.resId && Objects.equals(cName, that.cName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resId, cName);
    }

    @Override
    public String toString() {
        return "TaggedAsId{" +
                "resId=" + resId +
                ", cName='" + cName + '\'' +
                '}';
    }
}