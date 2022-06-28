package com.tomjerry.tom.jerry.service;

import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@Service
public class StreamingService {

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;

    @Value("${cloud.aws.region.static}")
    private String region;

    @Value("${bucketName}")
    private String bucketName;

    @Autowired
    private CinemaService cinemaService;;

    private final String resourceFormat = ".mp4";

    public StreamingService(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    public StreamingResponseBody getVideo(int season, int series) {
        try {
            AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
            AmazonS3 s3client = AmazonS3ClientBuilder.standard().withRegion(region).withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
            S3Object object = s3client.getObject(bucketName, cinemaService.findSeriesDtoByPos(season,series).getPath() + resourceFormat);
            S3ObjectInputStream finalObject = object.getObjectContent();

            return outputStream -> {
                int numberOfBytesToWrite;
                byte[] data = new byte[1024];
                while ((numberOfBytesToWrite = finalObject.read(data, 0, data.length)) != -1) {
                    outputStream.write(data, 0, numberOfBytesToWrite);
                }
                finalObject.close();
            };
        } catch (SdkClientException e) {
            e.printStackTrace();
            throw new SdkClientException(e);
        }
    }
}
