package com.toadsdewin.FootballLeague.repositories;
import com.toadsdewin.FootballLeague.models.TeamModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends MongoRepository<TeamModel,String>
{

}
