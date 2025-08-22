package com.ferreirandre.dslist.dto;

import com.ferreirandre.dslist.entities.Game;
import com.ferreirandre.dslist.projections.GameMinProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor
@Getter
@Setter
public class GameMinDTO {
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO(Game game) {
        BeanUtils.copyProperties(game, this);
    }
    public GameMinDTO(GameMinProjection projection) {
        BeanUtils.copyProperties(projection, this);
    }
}
