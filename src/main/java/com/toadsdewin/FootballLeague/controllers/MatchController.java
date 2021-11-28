package com.toadsdewin.FootballLeague.controllers;

import com.toadsdewin.FootballLeague.models.MatchModel;
import com.toadsdewin.FootballLeague.services.MatchService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MatchController
{
    @Autowired
    MatchService matchService;

    public ResponseEntity<Map<String,String>> saveMatch(@Valid @RequestBody MatchModel match)
    {
        Map<String,String> answer = new HashMap<>();
        answer.put("Message","The team has been introduced properly");
        answer.put("Status","true");

        return ResponseEntity.ok(answer);
    }

    @GetMapping("/matches")
    public List<MatchModel> getMatch()
    {
        return this.matchService.getMatches();
    }
}
