package com.ferreirandre.dslist.controllers;

import com.ferreirandre.dslist.dto.GameDTO;
import com.ferreirandre.dslist.dto.GameMinDTO;
import com.ferreirandre.dslist.services.GameService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameMinDTO>> getAllGames() {
        var games = gameService.findAll();
        return ResponseEntity.ok(games);
    }

    @GetMapping("{id}")
    public ResponseEntity<GameDTO> getGameById(@PathVariable("id") Long id) {
        var game = gameService.findById(id);
        return ResponseEntity.ok(game);
    }
}
