package MaviDevStudyCase.demo.bootstrap;

import MaviDevStudyCase.demo.Role.Role;
import MaviDevStudyCase.demo.Role.RoleRepository;
import MaviDevStudyCase.demo.User.User;
import MaviDevStudyCase.demo.User.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserDataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private void loadSecurityData() {
        Role admin = roleRepository.save(Role.builder().role("ADMIN").build());
        Role userRole = roleRepository.save(Role.builder().role("USER").build());

        userRepository.save(User.builder().
                username("spring").password(passwordEncoder.encode("cem123")).role(admin).build());
        userRepository.save(User.builder().
                username("cem").password(passwordEncoder.encode("12345")).role(userRole).build());

        log.debug("Users loaded" + userRepository.count());
    }
    @Override
    public void run(String... args) throws Exception {
        if(roleRepository.count()==0){
            loadSecurityData();
        }
    }


}
