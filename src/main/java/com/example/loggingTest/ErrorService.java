package com.example.loggingTest;

import org.springframework.stereotype.Service;

@Service
public class ErrorService {
    public void makeError() {
        throw new RuntimeException("custom error");
    }
}
