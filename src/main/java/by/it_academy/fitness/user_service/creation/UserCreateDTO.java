package by.it_academy.fitness.user_service.creation;

import by.it_academy.fitness.util.UnixSerializer;
import by.it_academy.fitness.user_service.creation.util.UserRole;
import by.it_academy.fitness.user_service.creation.util.UserStatus;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class UserCreateDTO {
    private UUID id;
    private String fullName;
    private String email;
    private LocalDateTime dt_create;
    private LocalDateTime dt_update;
    private UserRole userRole;
    private UserStatus status;
    private String password;

    @JsonCreator
    public UserCreateDTO(@JsonProperty(value = "fio") String fullName,
                         @JsonProperty(value = "mail") String email,
                         @JsonProperty(value = "role") UserRole userRole,
                         @JsonProperty(value = "status") UserStatus status,
                         @JsonProperty(value = "password") String password) {
        this.fullName = fullName;
        this.email = email;
        this.dt_create = LocalDateTime.now();
        this.userRole = userRole;
        this.status = status;
        this.password = password;
    }

    public UserCreateDTO(UUID id, String fullName, String  email, LocalDateTime dt_create,
                         LocalDateTime dt_update, UserRole userRole, UserStatus status) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.dt_create = dt_create;
        this.dt_update = dt_update;
        this.userRole = userRole;
        this.status = status;
    }

    public UserCreateDTO() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonSerialize(using = UnixSerializer.class)
    public LocalDateTime getDt_create() {
        return dt_create;
    }

    @JsonSerialize(using = UnixSerializer.class)
    public void setDt_create(LocalDateTime dt_create) {
        this.dt_create = dt_create;
    }

    @JsonSerialize(using = UnixSerializer.class)
    public LocalDateTime getDt_update() {
        return dt_update;
    }

    @JsonSerialize(using = UnixSerializer.class)
    public void setDt_update(LocalDateTime dt_update) {
        this.dt_update = dt_update;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
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
        UserCreateDTO userDTO = (UserCreateDTO) o;
        return Objects.equals(id, userDTO.id) && Objects.equals(fullName, userDTO.fullName) && Objects.equals(email, userDTO.email) && Objects.equals(dt_create, userDTO.dt_create) && Objects.equals(dt_update, userDTO.dt_update) && userRole == userDTO.userRole && status == userDTO.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, email, dt_create, dt_update, userRole, status);
    }
}
