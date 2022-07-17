package spring.bootsecure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.bootsecure.entities.Users;

@Repository
@Transactional
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findAllByEmail(String email);

}
