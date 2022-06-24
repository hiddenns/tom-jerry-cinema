package com.tomjerry.tom.jerry.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.servicequotas.model.RequestStatus;
import com.tomjerry.tom.jerry.Series;
import com.tomjerry.tom.jerry.config.S3Config;
import com.tomjerry.tom.jerry.service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping()
public class StreamingController {

    @Autowired
    private StreamingService streamingService;

    @GetMapping(value = "/video/{season}/{series}", produces = "video/mp4")
    @ResponseBody
    public ResponseEntity<StreamingResponseBody> getVideo(@PathVariable int season,
                                                          @PathVariable int series,
                                                          @RequestHeader("Range") String range,
                                                          HttpServletRequest request) {

        StreamingResponseBody responseBody = streamingService.getVideo(season,series);
        if (responseBody == null) {
            return new ResponseEntity<StreamingResponseBody>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<StreamingResponseBody>(responseBody, HttpStatus.OK);
    }

}
