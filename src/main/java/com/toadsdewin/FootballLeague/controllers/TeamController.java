package com.toadsdewin.FootballLeague.controllers;
import com.toadsdewin.FootballLeague.models.TeamModel;
import com.toadsdewin.FootballLeague.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TeamController
{
    @Autowired
    TeamService teamService;

    /**
     * We define the HTTP method which is going to be
     * executed the method
     * inside of controller
     */
    @PostMapping("/teams")
    public ResponseEntity<Map<String,String>> saveTeam(@Valid @RequestBody TeamModel team)
    {
        this.teamService.saveTeam(team);
        Map<String,String> answer  = new HashMap<>();
        answer.put("Message","The team has been introduce properly");

        return ResponseEntity.ok(answer);
    }

}
