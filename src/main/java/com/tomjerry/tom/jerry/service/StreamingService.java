package com.tomjerry.tom.jerry.service;

import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.tomjerry.tom.jerry.Season;
import com.tomjerry.tom.jerry.Series;
import com.tomjerry.tom.jerry.config.S3Config;
import com.tomjerry.tom.jerry.repository.StreamingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class StreamingService {

    @Autowired
    private ResourceLoader resourceLoader;

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;

    @Value("${cloud.aws.region.static}")
    private String region;

    @Value("${bucketName}")
    private String bucketName;

    @Autowired
    private StreamingRepository streamingRepository;;

    private final AmazonS3 s3;

    public StreamingService(ResourceLoader resourceLoader, StreamingRepository streamingRepository, AmazonS3 s3) {
        this.resourceLoader = resourceLoader;
        this.streamingRepository = streamingRepository;
        this.s3 = s3;
    }

    public StreamingResponseBody getVideo(int season, int series) {
        try {
            AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
            AmazonS3 s3client = AmazonS3ClientBuilder.standard().withRegion(region).withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
            S3Object object = s3client.getObject(bucketName, findSeriesDtoByPos(season,series).getName() + ".mp4");
            S3ObjectInputStream finalObject = object.getObjectContent();

            final StreamingResponseBody body = outputStream -> {
                int numberOfBytesToWrite = 0;
                byte[] data = new byte[1024];
                while ((numberOfBytesToWrite = finalObject.read(data, 0, data.length)) != -1) {
                    outputStream.write(data, 0, numberOfBytesToWrite);
                }
                finalObject.close();
            };

            return body;
        } catch (SdkClientException e) {
            e.printStackTrace();
            throw new SdkClientException(e);
        }

    }

    public List<Season> getAllSeasons(){
        return streamingRepository.findAll();
    }

    public Series findSeriesDtoByPos(int season, int series){
        return streamingRepository.findSeriesBySeason(season, series);
    }

}
