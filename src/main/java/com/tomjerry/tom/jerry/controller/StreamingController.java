package com.tomjerry.tom.jerry.controller;

import com.tomjerry.tom.jerry.service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping()
public class StreamingController {

    @Autowired
    private StreamingService streamingService;

    @GetMapping(value = "/video/{season}/{series}", produces = "video/mp4")
    @ResponseBody
    public Mono<Resource> getVideo(@PathVariable int season, @PathVariable int series, @RequestHeader("Range") String range) {
        return streamingService.getVideo(season, series);
    }

}
