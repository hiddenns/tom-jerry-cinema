package com.tomjerry.tom.jerry.service;

import com.tomjerry.tom.jerry.Season;
import com.tomjerry.tom.jerry.Series;
import com.tomjerry.tom.jerry.repository.StreamingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {

    @Autowired
    private StreamingRepository streamingRepository;;

    public List<Season> getAllSeasons(){
        return streamingRepository.findAll();
    }

    public Series findSeriesDtoByPos(int season, int series){
        return streamingRepository.findSeriesBySeason(season, series);
    }
}
