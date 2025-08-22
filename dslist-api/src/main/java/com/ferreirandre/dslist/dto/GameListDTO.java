package com.ferreirandre.dslist.dto;

import com.ferreirandre.dslist.entities.GameList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor
@Getter
@Setter
public class GameListDTO {
    private Long id;
    private String name;

    public GameListDTO(GameList gameList) {
        BeanUtils.copyProperties(gameList,this);
    }
}
