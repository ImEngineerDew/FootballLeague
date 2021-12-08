package com.toadsdewin.FootballLeague.controllers;

import com.toadsdewin.FootballLeague.models.MatchModel;
import com.toadsdewin.FootballLeague.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MatchController {
    @Autowired
    MatchService matchService;

    @PostMapping("/matches")
    public ResponseEntity<Map<String, String>> saveMatch(@Valid @RequestBody MatchModel match) {
        this.matchService.saveMatch(match);             /**This issue may create the table matches**/
        Map<String, String> answer = new HashMap<>();
        answer.put("Message", "The match has been introduced properly");
        answer.put("Status", "true");
        return ResponseEntity.ok(answer);
    }

    @PutMapping("/matches")
    public ResponseEntity<Map<String, String>> upgradeMatch(@Valid @RequestBody MatchModel match) {
        this.matchService.saveMatch(match);             /**This issue may create the table matches**/
        Map<String, String> answer = new HashMap<>();
        answer.put("Message", "The match has been updated properly");
        answer.put("Status", "true");
        return ResponseEntity.ok(answer);
    }

    @GetMapping("/matches")
    public List<MatchModel> getMatch() {
        return this.matchService.getMatches();
    }

    @GetMapping("/matches/{id}")
    public MatchModel getMatchByID(@PathVariable String id) {
        return this.matchService.findByID(id).get();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/matches/{id}")
    public String deleteMatch(@PathVariable String id)
    {
        matchService.deleteMatchByID(id);
        return "Match deleted by id";
    }
}
