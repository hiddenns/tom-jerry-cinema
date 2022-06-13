package com.tomjerry.tom.jerry.repository;

import com.tomjerry.tom.jerry.Series;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface SeriesRepository extends CrudRepository<Series, Long> {

    @Query("FROM Series WHERE SEASON_ID = ?1 AND POS = ?2")
    Series findSeriesBySeason(Integer season, Integer pos);

}
