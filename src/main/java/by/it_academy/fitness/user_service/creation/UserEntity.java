package by.it_academy.fitness.user_service.creation;

import by.it_academy.fitness.user_service.creation.util.UserRole;
import by.it_academy.fitness.user_service.creation.util.UserStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "users", schema = "app")
public class UserEntity {
    @Id
    @UuidGenerator
    @Column(name = "user_id")
    private UUID id;
    @Column(name = "full_name")
    private String fullName;

    @Column(name = "mail")
    private String email;

    @Column(name = "dt_create")
    private LocalDateTime dt_create;
    @Column(name = "dt_update")
    @Version
    private LocalDateTime dt_update;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @Column(name = "password")
    private String password;

    public UserEntity(UUID id, String fullName, String  email, UserRole userRole, UserStatus userStatus, String password) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.dt_create = LocalDateTime.now();
        this.userRole = userRole;
        this.userStatus = userStatus;
        this.password = password;
    }

    public UserEntity() {
    }

    public UserEntity(UUID id, String fullName, String email, LocalDateTime dt_create, LocalDateTime dt_update, UserRole userRole, UserStatus userStatus) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.dt_create = dt_create;
        this.dt_update = dt_update;
        this.userRole = userRole;
        this.userStatus = userStatus;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String  getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDt_create() {
        return dt_create;
    }

    public void setDt_create(LocalDateTime dt_create) {
        this.dt_create = dt_create;
    }

    public LocalDateTime getDt_update() {
        return dt_update;
    }

    public void setDt_update(LocalDateTime dt_update) {
        this.dt_update = dt_update;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(fullName, that.fullName) && Objects.equals(email, that.email) && Objects.equals(dt_create, that.dt_create) && Objects.equals(dt_update, that.dt_update) && userRole == that.userRole && userStatus == that.userStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, email, dt_create, dt_update, userRole, userStatus);
    }

    @PreUpdate
    void updateDateTimeUpdate() {
        this.dt_update = LocalDateTime.now();
    }
}