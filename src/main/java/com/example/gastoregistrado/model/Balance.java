package com.example.gastoregistrado.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "balance")
public class Balance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long amount;
    private String currency;
    @Column(name = "image_cover")
    private String imageCover;
    @Column(name = "latest_update")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime latestUpdate;
    @PreUpdate
    protected void onUpdate() {
        this.latestUpdate = LocalDateTime.now();
    }
    private String type;
    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private LocalDate createdAt;
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDate.now();
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_user_id_bal"))
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getImageCover() {
        return imageCover;
    }

    public void setImageCover(String imageCover) {
        this.imageCover = imageCover;
    }

    public LocalDateTime getLatestUpdate() {
        return latestUpdate;
    }

    public void setLatestUpdate(LocalDateTime latestUpdate) {
        this.latestUpdate = latestUpdate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}