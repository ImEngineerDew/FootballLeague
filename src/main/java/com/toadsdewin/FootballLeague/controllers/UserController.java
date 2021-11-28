package com.toadsdewin.FootballLeague.controllers;
import com.toadsdewin.FootballLeague.models.UserModel;
import com.toadsdewin.FootballLeague.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController
{
    @Autowired
    UserService userService;
    /**
     * We define the HTTP method which is going to be
     * executed the method
     * inside of controller
     */

    @PostMapping("/users")
    public ResponseEntity<Map<String,String>>saveUsers(@Valid @RequestBody UserModel user)
    {

        Map<String,String> answer  = new HashMap<>();

        /**Okay, this is the line that validate if we've had created an user**/
        UserModel us = this.userService.findByUserName(user.getUsername());

        if(us.getId()== null)
        {
            this.userService.save(user);
            answer.put("Message","The user has been introduced properly");
        }
        else
        {
            answer.put("Message","The user already exist");
        }
        return ResponseEntity.ok(answer);
    }
}
