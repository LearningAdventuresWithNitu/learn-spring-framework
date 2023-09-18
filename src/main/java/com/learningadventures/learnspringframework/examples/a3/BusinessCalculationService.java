package com.learningadventures.learnspringframework.examples.a3;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
public class BusinessCalculationService {
    private DataService dataService;

    public BusinessCalculationService(DataService dataService) {
        super();
        this.dataService = dataService;
    }
    
    public int findMax() {
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}
