package com.tomjerry.tom.jerry;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int number;

    @OneToMany()
    @JoinColumn(name = "season_id", referencedColumnName = "id")
    private List<Series> seriesList;

    public Season(String name, int number, List<Series> seriesList) {
        this.name = name;
        this.number = number;
        this.seriesList = seriesList;
    }

    public Season(String name, int number) {
        this.name = name;
        this.number = number;
        this.seriesList = seriesList;
    }

}
