package semicolonafrica.group7capstoneproject.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import semicolonafrica.group7capstoneproject.data.models.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {


    Optional<Account> findAccountByEmail(String email);
    boolean existsByEmail(String email);

}
