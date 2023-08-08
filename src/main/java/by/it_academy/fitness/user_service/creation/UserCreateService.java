package by.it_academy.fitness.user_service.creation;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public class UserCreateService implements IUserCreateService {
    private final IUserCreateRepository user;

    public UserCreateService(IUserCreateRepository user) {
        this.user = user;
    }

    @Override
    public void save(UserCreateDTO userDTO) {
        user.save(new UserEntity(userDTO.getId(),userDTO.getFullName(),
                userDTO.getEmail(), userDTO.getUserRole(),
                userDTO.getStatus(), userDTO.getPassword()));
    }

    @Override
    public void saveOrUpdate(UUID id, LocalDateTime dt_update, UserCreateDTO userDTO) {
        UserEntity userEntity = user.getReferenceById(id);
        userEntity.setId(id);
        userEntity.setFullName(userDTO.getFullName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setUserRole(userDTO.getUserRole());
        userEntity.setUserStatus(userDTO.getStatus());
        userEntity.setPassword(userDTO.getPassword());
        user.save(userEntity);
    }

    public Optional<UserEntity> findById(UUID id) {
        return user.findById(id);
    }
}
