package com.gagan.myProjects.controllers;

import com.gagan.myProjects.models.MyUser;
import com.gagan.myProjects.repositories.MyUserRepository;
import com.gagan.myProjects.services.MyUserDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {
    @Autowired
    private MyUserDetailsServices myUserDetailsServices;
    @GetMapping
    public String ok(){
        return  "OK";
    }
    @PostMapping
    public ResponseEntity<MyUser> add(@RequestBody Map<String,Object> userData ){
        String name= (String) userData.get("username");
        String password= (String) userData.get("password");
        MyUser u=new MyUser(name,password,0);
                myUserDetailsServices.createUser(name,password,0);
        return ResponseEntity.ok(u);
    }
}
