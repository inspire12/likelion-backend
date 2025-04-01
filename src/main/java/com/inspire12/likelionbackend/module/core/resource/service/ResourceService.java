package com.inspire12.likelionbackend.module.core.resource.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Service
public class ResourceService {

    private final ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper;

    public ResourceService(ResourceLoader resourceLoader, ObjectMapper objectMapper) {
        this.resourceLoader = resourceLoader;
        this.objectMapper = objectMapper;
    }

    public String load(String resourceName) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:file/" + resourceName);

        if (resource.exists()) {
            InputStream inputStream = resource.getInputStream();
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }
        throw new FileNotFoundException(resourceName);
    }

    public byte[] loadImage(String resourceName) throws FileNotFoundException {
        Resource resource = resourceLoader.getResource("classpath:file/" + resourceName);

        byte[] imageBytes = null;
        try {
            imageBytes = StreamUtils.copyToByteArray(resource.getInputStream());
            return imageBytes;
        } catch (IOException e) {
            throw new FileNotFoundException(resourceName);
        }
    }

}
