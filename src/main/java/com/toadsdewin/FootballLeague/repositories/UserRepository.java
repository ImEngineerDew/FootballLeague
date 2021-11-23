package com.toadsdewin.FootballLeague.repositories;
import com.toadsdewin.FootballLeague.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserModel,String>
{
    public Optional<UserModel> findByUsername(String userName);
}

