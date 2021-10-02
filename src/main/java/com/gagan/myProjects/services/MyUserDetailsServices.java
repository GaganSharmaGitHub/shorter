package com.gagan.myProjects.services;

import com.gagan.myProjects.intermediates.UserDetailsIntermediate;
import com.gagan.myProjects.models.MyUser;
import com.gagan.myProjects.repositories.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsServices implements UserDetailsService {
    @Autowired
    MyUserRepository myUserRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    public MyUser createUser(String username,String password,Integer age){
        password= passwordEncoder.encode(password);
        MyUser u= new MyUser(username,password,age);
        myUserRepository.save(u);
        return u;
    }
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        MyUser user= myUserRepository.findByUsername(s);

        return new UserDetailsIntermediate(user);
    }
}
