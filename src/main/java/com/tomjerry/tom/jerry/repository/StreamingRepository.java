package com.tomjerry.tom.jerry.repository;

import com.tomjerry.tom.jerry.Season;
import com.tomjerry.tom.jerry.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StreamingRepository {

    private final SeasonsRepository seasonsRepository;
    private final SeriesRepository seriesRepository;

    @Autowired
    public StreamingRepository(SeasonsRepository seasonsRepository, SeriesRepository seriesRepository) {
        this.seasonsRepository = seasonsRepository;
        this.seriesRepository = seriesRepository;
    }

    public List<Season> findAll() {
        Iterable<Season> seasonIterable = seasonsRepository.findAll();
        List<Season> seasonList = new ArrayList<>();
        seasonIterable.forEach((i) -> seasonList.add(i));
        return seasonList;
    }

    public Series findSeriesBySeason(int season, int series) {
        return seriesRepository.findSeriesBySeason(season, series);
    }


}
