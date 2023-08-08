package by.it_academy.fitness.user_service.registration_login;

import by.it_academy.fitness.user_service.creation.UserCreateDTO;

public interface IUserRegistrationLoginService {
    void register(UserRegistrationDTO userRegistrationDTO);
    void login(UserLoginDTO userLoginDTO);
     UserCreateDTO getInformation();
}
