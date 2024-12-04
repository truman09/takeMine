
package com.towson.takeMine.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @Column(nullable = false,name = "TU_ID")
    private String tuId;

    @Column(nullable = false)
    private String userStatus;

    @Column(nullable = false, unique = true)
    private String tuEmail;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private LocalDate doB;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Transient
    private Double balance;

    public String getTuId() {
        return tuId;
    }

    public void setTuId(String tuId) {
        this.tuId = tuId;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getTuEmail() {
        return tuEmail;
    }

    public void setTuEmail(String tuEmail) {
        this.tuEmail = tuEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDoB() {
        return doB;
    }

    public void setDoB(LocalDate doB) {
        this.doB = doB;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "tuId='" + tuId + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", tuEmail='" + tuEmail + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", DoB=" + doB +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
    // Getters and Setters
}
