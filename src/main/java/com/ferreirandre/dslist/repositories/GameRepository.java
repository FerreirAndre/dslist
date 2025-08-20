package com.ferreirandre.dslist.repositories;

import com.ferreirandre.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
