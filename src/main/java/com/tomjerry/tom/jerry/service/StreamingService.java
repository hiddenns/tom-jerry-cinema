package com.tomjerry.tom.jerry.service;

import com.tomjerry.tom.jerry.Season;
import com.tomjerry.tom.jerry.SeriesDto;
import com.tomjerry.tom.jerry.repository.StreamingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class StreamingService {

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private StreamingRepository streamingRepository;

    private static final String FORMAT = "classpath:videos/season";
    private static final String FORMAT_END = "/%s.mp4";
    private static String currentFormat = FORMAT + 1 + FORMAT_END;
    //private static final String FORMAT = "classpath:videos/%s.mp4";

    public Mono<Resource> getVideo(int season, int series){
        SeriesDto seriesDto = findSeriesDtoByPos(season, series);
        String title = seriesDto.getName();
        return Mono.fromSupplier(() ->
                resourceLoader.getResource(String.format(currentFormat,title)));
    }

    public List<Season> getAllSeasons(){
        return streamingRepository.getAllSeasons();
    }

    private SeriesDto findSeriesDtoByPos(int season, int series){
        return streamingRepository.findSeriesBySeason(season, series);
    }

}
