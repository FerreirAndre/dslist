package com.ferreirandre.dslist.repositories;

import com.ferreirandre.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
