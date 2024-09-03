package com.example.SpringDemoBot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity(name = "usersDataTable")
public class User {

    @Id
    private Long chatId;

    private String firstName;
    private String lastName;
    private String userName;
    private Timestamp registeredAt;

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRegisteredAt(Timestamp registeredAt) {
        this.registeredAt = registeredAt;
    }
    @Override
    public String toString() {
        return "User{" +
                "chatID=" + chatId +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", userName=" + userName +
                ", registered at=" + registeredAt +
                "}";
    }
    public Long getChatId() {
        return chatId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public Timestamp getRegisteredAt() {
        return registeredAt;
    }

    public User() {
    }

    public User(Long chatId) {
        this.chatId = chatId;
    }
}