package semicolonafrica.group7capstoneproject.security.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import semicolonafrica.group7capstoneproject.data.models.Account;
import semicolonafrica.group7capstoneproject.data.repositories.AccountRepository;

@Service
@RequiredArgsConstructor
public class UserAccountDetailsService implements UserDetailsService {
    private final AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findAccountByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return UserAccountDetails.buildUserDetails(account);
    }

}
