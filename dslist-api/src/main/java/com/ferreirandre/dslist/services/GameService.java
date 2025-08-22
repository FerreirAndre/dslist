package com.ferreirandre.dslist.services;

import com.ferreirandre.dslist.dto.GameDTO;
import com.ferreirandre.dslist.dto.GameMinDTO;
import com.ferreirandre.dslist.exceptions.NotFoundException;
import com.ferreirandre.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        var result = gameRepository.findAll();
        return result.stream().map(g -> new GameMinDTO(g)).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        var result = gameRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Game with id " + id + " not found")
        );
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        var result = gameRepository.findByList(listId);
        return result.stream().map(GameMinDTO::new).toList();
    }
}
