package by.it_academy.fitness.user_service.creation;

import by.it_academy.fitness.user_service.creation.UserCreateDTO;
import by.it_academy.fitness.user_service.creation.UserEntity;
import by.it_academy.fitness.user_service.creation.IUserCreateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    private final IUserCreateService userService;

    public UsersController(IUserCreateService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody UserCreateDTO user){;
        userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(path = "/{id}/version/{dt_update}", method = RequestMethod.PUT)
    public void saveOrUpdate(@PathVariable("id") UUID id,
                       @PathVariable("dt_update") LocalDateTime dt_update,
                       @RequestBody UserCreateDTO user) {
        userService.saveOrUpdate(id, dt_update, user);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Optional<UserEntity> findById(@PathVariable("id") UUID id){
        return userService.findById(id);
    }
}
