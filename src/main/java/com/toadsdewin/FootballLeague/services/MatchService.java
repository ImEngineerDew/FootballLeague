package com.toadsdewin.FootballLeague.services;
import com.toadsdewin.FootballLeague.models.MatchModel;
import com.toadsdewin.FootballLeague.models.UserModel;
import org.springframework.stereotype.Service;
import com.toadsdewin.FootballLeague.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class MatchService
{
    @Autowired
    MatchRepository matchRepository;        /**It contains the CRUD method**/

    public void saveMatch(MatchModel match)
    {
        this.matchRepository.save(match);
    }

    public List<MatchModel> getMatches()
    {
        return this.matchRepository.findAll();
    }
    public MatchModel findMatch(String id)
    {
        return this.matchRepository.findById(id).orElse(new MatchModel());
    }
    public Optional<MatchModel> findByID(String id)
    {
        return this.matchRepository.findById(id);
    }
    public void deleteMatchByID(String id)
    {
        matchRepository.deleteById(id);
    }

}
