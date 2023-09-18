package com.learningadventures.learnspringframework.examples.a3;

import org.springframework.stereotype.Component;

@Component
public class MySQLDataService implements DataService {

    @Override
    public int[] retrieveData() {
        return new int[] {1, 4, 5, 9};
    }
    
}
