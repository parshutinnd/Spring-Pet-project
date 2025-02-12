package com.example.demo.controller;

import java.io.IOException;
import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;


@Controller
@RequestMapping("/photos")
public class PhotoController {

    private static final String KEY_ID = "YCAJEDm3qyGwDnnM5jk8Px9j2";
    private static final String SECRET_KEY = "YCPiaginSuBH7aD5gU0BORGL9Zgd5UIiqcQ1aN7P";
    private static final String REGION = "ru-central1";
    private static final String S3_ENDPOINT = "https://storage.yandexcloud.net";

    private static final String BUCKET = "spring-boot-sample";

    private final S3Client s3Client;

    public PhotoController() {
        AwsCredentials credentials = AwsBasicCredentials.create(KEY_ID, SECRET_KEY);

        s3Client = S3Client.builder()
                .httpClient(ApacheHttpClient.create())
                .region(Region.of(REGION))
                .endpointOverride(URI.create(S3_ENDPOINT))
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();
    }

    @GetMapping("/")
    public String photos() {
        return "photos";
    }
    

    @RequestMapping(value = "/save",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,method=RequestMethod.POST)
    public String uploadFile(@RequestParam("image") MultipartFile photo) throws IOException {

        String key = "photos/" + photo.getOriginalFilename();
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(BUCKET)
                .key(key)
                .contentType(photo.getContentType())
                .build();

        s3Client.putObject(putObjectRequest, RequestBody.fromBytes(photo.getBytes()));

        return key;
    }

}