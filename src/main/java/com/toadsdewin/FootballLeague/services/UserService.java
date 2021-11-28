package com.toadsdewin.FootballLeague.services;
import com.toadsdewin.FootballLeague.models.UserModel;
import com.toadsdewin.FootballLeague.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    UserRepository userRepository;

    //A method for save the user data;
    public void save(UserModel user)
    {
        this.userRepository.save(user);
    }

    public List<UserModel> getUser()
    {
        return this.userRepository.findAll();
    }

    public Optional<UserModel> findById(String id)
    {
        return this.userRepository.findById(id);
    }

    public UserModel findByUserName(String username)
    {
        return this.userRepository.findByUsername(username).orElse(new UserModel());
    }
}
