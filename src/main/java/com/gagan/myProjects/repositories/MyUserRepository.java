package com.gagan.myProjects.repositories;

import com.gagan.myProjects.models.MyUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface MyUserRepository extends CrudRepository<MyUser, String> {
    MyUser findByUsername(String username);

}
