package by.it_academy.fitness.user_service.registration_login;

import by.it_academy.fitness.user_service.creation.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUserRegistrationLoginRepository extends JpaRepository<UserEntity, UUID> {
}
