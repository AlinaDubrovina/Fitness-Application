package by.it_academy.fitness.user_service.creation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserCreateRepository extends JpaRepository<UserEntity, UUID> {
}
