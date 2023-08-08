package by.it_academy.fitness.user_service.registration_login;

import by.it_academy.fitness.user_service.creation.UserCreateDTO;
import by.it_academy.fitness.user_service.creation.UserEntity;
import by.it_academy.fitness.user_service.creation.util.UserRole;
import by.it_academy.fitness.user_service.creation.util.UserStatus;

import java.util.UUID;

public class UserRegistrationLoginService implements IUserRegistrationLoginService{
    private final IUserRegistrationLoginRepository userRegistrationLoginDAO;

    public UserRegistrationLoginService(IUserRegistrationLoginRepository userRegistrationLoginDAO) {
        this.userRegistrationLoginDAO = userRegistrationLoginDAO;
    }

    @Override
    public void register(UserRegistrationDTO userRegistrationDTO) {
        UserEntity user = new UserEntity();
        user.setId(UUID.randomUUID());
        user.setPassword(userRegistrationDTO.getPassword());
        user.setUserStatus(UserStatus.WAITING_ACTIVATION);
        user.setUserRole(UserRole.USER);
        userRegistrationLoginDAO.save(user);
    }

    @Override
    public void login(UserLoginDTO userLoginDTO) {
    }

    @Override
    public UserCreateDTO getInformation() {
        return null;
    }
}
