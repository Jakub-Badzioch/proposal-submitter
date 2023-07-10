package com.towerbuilder.proposalsubmitter.security;

import com.towerbuilder.proposalsubmitter.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    public final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // map nic nie wykona jesli nie zostanie znalezony employee o podanym mailu
        return employeeRepository.findByEmail(email)
                .map(employee -> new User(email, employee.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_EMPLOYEE"))))
                .orElseThrow(() -> new UsernameNotFoundException(email));
    }
}
