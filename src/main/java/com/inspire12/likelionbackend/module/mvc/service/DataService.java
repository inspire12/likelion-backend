package com.inspire12.likelionbackend.module.mvc.service;

import com.inspire12.likelionbackend.module.mvc.repository.DataRepository;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    private final DataRepository dataRepository;


    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public void getData() {
        
    }
}
