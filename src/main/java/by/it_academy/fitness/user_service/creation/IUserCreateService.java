package by.it_academy.fitness.user_service.creation;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface IUserCreateService{
    void save(UserCreateDTO user);
    void saveOrUpdate(UUID id, LocalDateTime dt_update, UserCreateDTO user);
    Optional<UserEntity> findById(UUID id);
}