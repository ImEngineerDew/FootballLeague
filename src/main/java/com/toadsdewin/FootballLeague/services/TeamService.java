package com.toadsdewin.FootballLeague.services;
import com.toadsdewin.FootballLeague.models.TeamModel;
import com.toadsdewin.FootballLeague.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //It defines a class like a service
public class TeamService
{
    @Autowired
    TeamRepository teamRepository;

    //A method to save the teams data
    public void saveTeam(TeamModel team)
    {
        this.teamRepository.save(team);
    }
    //A method for check the teams model
    public List<TeamModel> getTeams()
    {
        return this.teamRepository.findAll();
    }
    //A method for check a team by ID
    public Optional<TeamModel> findByID(String id)
    {
        return this.teamRepository.findById(id);
    }
    //A method for check if the team already exists!
    public Boolean checkTeam(String id)
    {
        return this.teamRepository.existsById(id);
    }
    public void delTeam(String id)
    {
        this.teamRepository.deleteById(id);
    }
}
