
package com.towson.takeMine.entity;


import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "RESOURCE")
public class Resource implements Serializable {
    public Resource() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Res_ID")
    private Integer resId;

    @Column(nullable = false)
    private String resName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String location;

    @Column(nullable = true)
    private Boolean availability = true;

    @Column(nullable = true)
    private BigDecimal cost;

    @Column(nullable = false, name = "TU_ID")
    private String tuId;

    @Column(nullable = false)
    private String resourceType;

    @Column(nullable = true)
    private Boolean helpMode = false;

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getTuId() {
        return tuId;
    }

    public void setTuId(String tuId) {
        this.tuId = tuId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public Boolean getHelpMode() {
        return helpMode;
    }

    public void setHelpMode(Boolean helpMode) {
        this.helpMode = helpMode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource resource = (Resource) o;
        return Objects.equals(resId, resource.resId) && Objects.equals(resName, resource.resName) && Objects.equals(description, resource.description) && Objects.equals(location, resource.location) && Objects.equals(availability, resource.availability) && Objects.equals(cost, resource.cost) && Objects.equals(tuId, resource.tuId) && Objects.equals(resourceType, resource.resourceType) && Objects.equals(helpMode, resource.helpMode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resId, resName, description, location, availability, cost, tuId, resourceType, helpMode);
    }
    // Getters and Setters
}
