package uz.pdp.springsecuritystarter.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.springsecuritystarter.dto.AuthUserDto;
import uz.pdp.springsecuritystarter.entity.authuser.AuthUser;
import uz.pdp.springsecuritystarter.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthUserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = userRepository
                .getAuthUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        return new User(authUser.getUsername(),authUser.getPassword(), authUser.getAuthorities());
    }

    public void create(AuthUserDto userDto) {
        System.out.println(userDto);

        AuthUser authUser = mapper.map(userDto, AuthUser.class);
        authUser.setPassword(encoder.encode(authUser.getPassword()));

        System.out.println(authUser);
        userRepository.save(authUser);
    }


    public void recoverPassword(String email) {

    }
}
