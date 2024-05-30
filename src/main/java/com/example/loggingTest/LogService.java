package com.example.loggingTest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LogService {
    private final ErrorService errorService;
    public void normalMethod() {
        log.info("nothing special");
    }

    public void errorMethod() {
        log.error("make error");
        errorService.makeError();
    }
}
