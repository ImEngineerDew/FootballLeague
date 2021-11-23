package com.toadsdewin.FootballLeague.repositories;
import com.toadsdewin.FootballLeague.models.MatchModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends MongoRepository<MatchModel,String>
{

}
