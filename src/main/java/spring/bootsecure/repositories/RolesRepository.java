package spring.bootsecure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.bootsecure.entities.Roles;

@Repository
@Transactional
public interface RolesRepository extends JpaRepository<Roles, Long> {

        Roles findByRole(String role);

}
