package com.tomjerry.tom.jerry;

import lombok.Data;

@Data
public class SeriesDto {

    private static int count = 0;
    private String name;
    private int pos;
    private int season;
    private boolean isCurrent = false;

    public SeriesDto(String name, int pos, int season){
        this.name = name;
        this.pos = pos;
        this.season = season;
    }

}
