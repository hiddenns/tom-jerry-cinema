package com.tomjerry.tom.jerry;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
public class SelectSeriesDto {
    private String season;
    private String series;

    public SelectSeriesDto() {
        season = series = "1";
    }
}
