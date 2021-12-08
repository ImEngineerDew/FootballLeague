package com.toadsdewin.FootballLeague.controllers;
import com.toadsdewin.FootballLeague.models.MatchModel;
import com.toadsdewin.FootballLeague.models.UserModel;
import com.toadsdewin.FootballLeague.services.MatchService;
import com.toadsdewin.FootballLeague.services.UserService;
import com.toadsdewin.FootballLeague.utils.Autorization;
import com.toadsdewin.FootballLeague.utils.BCrypt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController
{
    @Autowired
    UserService userService;

    @Autowired
    MatchService matchService;
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
        user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));        
        
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

    /**For update an user**/
    @PutMapping("/users")
    public ResponseEntity<Map<String,String>> upgradeUsers(@Valid @RequestBody UserModel user)
    {
            this.userService.save(user);
            Map<String, String> answer = new HashMap<>();
            answer.put("Message", "The user has been upgraded properly");

            MatchModel  auxiliarMatch = this.matchService.findMatch("61a23a41c1d97e39da71ad17");
            auxiliarMatch.getUserModel().setName(user.getName());
            upgradeMatch(auxiliarMatch);

        return ResponseEntity.ok(answer);
    }
    
    @PostMapping("/users/login")
    public ResponseEntity <Map<String,String>> login (@RequestBody UserModel user)
    {
        UserModel auxiliarUser  = this.userService.findByUserName(user.getUsername());
        Map<String,String> answer = new HashMap<>();

        if(auxiliarUser.getUsername()==null)
        {
            answer.put("Message","The user or password is incorrect!");
        }

        if(!BCrypt.checkpw(user.getPassword(),auxiliarUser.getPassword()))
        {
            answer.put("Message","The user or password is incorrect");
        }
        else
        {
            String hash = "";
            long time = System.currentTimeMillis();

            if(auxiliarUser.getId()!=null)
            {
                hash = Jwts.builder()
                        .signWith(SignatureAlgorithm.HS256, Autorization.KEY)
                        .setSubject(auxiliarUser.getName())
                        .setIssuedAt(new Date(time))
                        .setExpiration(new Date(time+900000))
                        .claim("username",auxiliarUser.getUsername())
                        .claim("email",auxiliarUser.getEmail())
                        .compact();
            }
            auxiliarUser.setHash(hash);
            answer.put("Message","Login sucesfull!");
            answer.put("Token",hash);
        }
        return ResponseEntity.ok(answer);


    }
    
    public void upgradeMatch(MatchModel match)
    {
        this.matchService.saveMatch(match);             /**This issue may update the matches data**/
        Map<String,String> answer = new HashMap<>();
        answer.put("Message","The match has been updated properly");
        answer.put("Status","true");
    }

    @GetMapping("/users")
    public List<UserModel> getUsers()
    {
        return this.userService.getUser();
    }

    /**This is the linecode that find the users by id**/
    @GetMapping("/users/{id}")
    public UserModel getUserById(@PathVariable String id)
    {
        return this.userService.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void deleteUser(@PathVariable String id)
    {
        userService.deleteUserbyId(id);
    }

}
