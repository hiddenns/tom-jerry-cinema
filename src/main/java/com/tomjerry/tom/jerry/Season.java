package com.tomjerry.tom.jerry;

import lombok.Data;

import java.util.List;

@Data
public class Season {
    private String name;
    private int number;
    private List<SeriesDto> seriesList;

    public Season(String name, int number, List<SeriesDto> seriesList) {
        this.name = name;
        this.number = number;
        this.seriesList = seriesList;
    }
}
