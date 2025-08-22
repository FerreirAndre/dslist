package com.ferreirandre.dslist.repositories;

import com.ferreirandre.dslist.dto.GameMinDTO;
import com.ferreirandre.dslist.entities.Game;
import com.ferreirandre.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(nativeQuery = true, value = """
            SELECT tg.id, tg.title, tg.game_year AS year, tg.img_url AS imgUrl,
            tg.short_description AS shortDescription, tb.position
            FROM tb_game tg
            INNER JOIN tb_belonging tb ON tb.game_id = tg.id
            WHERE tb.list_id = :listId
            ORDER BY tb.position;
            """)
    List<GameMinProjection> findByList(Long listId);
}
