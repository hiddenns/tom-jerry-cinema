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

    private String name;
    private int pos;
    private String path;
    private int season_id;
    private String description;

    public Series(String name, String path, int pos){
        this.name = name;
        this.path = path;
        this.pos = pos;
    }

    public Series(String name, String description, String path, int pos, int seasonId){
        this.name = name;
        this.path = path;
        this.description = description;
        this.pos = pos;
        this.season_id = seasonId;
    }

}
