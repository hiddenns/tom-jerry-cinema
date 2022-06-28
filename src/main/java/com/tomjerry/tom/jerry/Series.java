package com.tomjerry.tom.jerry;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Series {

    @Id
    @Column(name = "series_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String path;
    private int pos;
    private int season_id;
    private String description;

    public Series(String path, String description, int pos, int seasonId){
        this.path = path;
        this.description = description;
        this.pos = pos;
        this.season_id = seasonId;
    }

}
