package spring.bootsecure.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.bootsecure.entities.Users;
import spring.bootsecure.repositories.UsersRepository;
import spring.bootsecure.services.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findAllByEmail(username);
        if (user!=null){
            return user;
        }else throw new UsernameNotFoundException("USER NOT FOUND!!!");
    }
}
