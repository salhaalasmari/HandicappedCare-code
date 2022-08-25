package com.example.handicappedcare.service;


import com.example.handicappedcare.model.Register;
import com.example.handicappedcare.repository.RegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService  implements UserDetailsService{
    private  final RegisterRepository registerRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Register register =registerRepository.findRegistersByUsername(username);

        if(register==null){
            throw new UsernameNotFoundException("Invalid username or password");
        }

        return register;
    }
}
