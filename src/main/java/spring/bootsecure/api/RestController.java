package spring.bootsecure.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.bootsecure.entities.Users;
import spring.bootsecure.repositories.UsersRepository;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/api/rest")
public class RestController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping(value = "/users")
    public ResponseEntity<List<Users>> getAllUsers(){
        return new ResponseEntity<>(usersRepository.findAll(), HttpStatus.OK);
    }
}
