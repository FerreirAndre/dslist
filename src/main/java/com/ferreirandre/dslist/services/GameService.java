package com.ferreirandre.dslist.services;

import com.ferreirandre.dslist.dto.GameMinDTO;
import com.ferreirandre.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        var games = gameRepository.findAll();
        return games.stream().map(g -> new GameMinDTO(g)).toList();
    }
}
