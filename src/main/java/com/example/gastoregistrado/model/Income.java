package com.example.gastoregistrado.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "income")
public class Income implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private long amount;
    private String currency;
    @Column(name = "expire_date")
    private Date expireDate;
    private String description;
    @Column(name = "image_cover")
    private String imageCover;
    private String term;
    private String state;
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
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_user_id_inc"))
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageCover() {
        return imageCover;
    }

    public void setImageCover(String imageCover) {
        this.imageCover = imageCover;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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