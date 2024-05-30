package com.example.loggingTest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/log")
@RequiredArgsConstructor
public class LogController {
    private final LogService logService;

    @GetMapping("/info")
    public String infoLog(){
        log.info("info log");
        return "info log";
    }

    @GetMapping("/error")
    public String errorLog(){
        log.error("error log");
        return "error log";
    }

    @GetMapping("/warn")
    public String warnLog(){
        log.warn("warn log");
        return "warn log";
    }

    @GetMapping("/error")
    public String errorMethod(){
        logService.errorMethod();
        return "error method";
    }

    @GetMapping("/normal")
    public String normalMethod(){
        logService.normalMethod();
        return "normal method";
    }
}
