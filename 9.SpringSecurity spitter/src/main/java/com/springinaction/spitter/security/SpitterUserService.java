package com.springinaction.spitter.security;

import com.springinaction.spitter.Spitter;
import com.springinaction.spitter.data.SpitterRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Used for configuring custom user service
 */
public class SpitterUserService implements UserDetailsService {

    private final SpitterRepository spitterRepository;

    public SpitterUserService(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    /**
     * Locates the user based on the username.
     *
     * @param username the username identifying the user whose data is required.
     *
     * @return a fully populated user record (never <code>null</code>)
     *
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     * GrantedAuthority
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // looking for a user with such username from repository of spittle users (spitters)
        Spitter spitter = spitterRepository.findByUsername(username);

        if (spitter != null) {
            // setting for such user authorities by role
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_SPITTER"));

            // returning new spring security user instance based on spitter user and his role
            return new User(
                    spitter.getUsername(),
                    spitter.getPassword(),
                    authorities);
        }

        throw new UsernameNotFoundException("User '" + username + "' not found.");
    }
}
