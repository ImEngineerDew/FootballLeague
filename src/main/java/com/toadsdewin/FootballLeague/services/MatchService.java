package com.toadsdewin.FootballLeague.services;
import com.toadsdewin.FootballLeague.models.MatchModel;
import org.springframework.stereotype.Service;
import com.toadsdewin.FootballLeague.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

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
}
