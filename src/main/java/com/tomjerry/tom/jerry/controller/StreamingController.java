package com.tomjerry.tom.jerry.controller;

import com.tomjerry.tom.jerry.service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping()
public class StreamingController {

    @Autowired
    private StreamingService streamingService;

    @GetMapping(value = "/video/{season}/{series}", produces = "video/mp4")
    @ResponseBody
    public ResponseEntity<StreamingResponseBody> getVideo(@PathVariable int season, @PathVariable int series,
                                                          @RequestHeader("Range") String range,
                                                          HttpServletRequest request) {
        StreamingResponseBody responseBody = streamingService.getVideo(season,series);
        if (responseBody == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

}
