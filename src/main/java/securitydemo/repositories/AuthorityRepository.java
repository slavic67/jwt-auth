package securitydemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import securitydemo.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
