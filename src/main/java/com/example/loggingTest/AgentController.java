package com.example.loggingTest;

import com.example.loggingTest.testJpa.Member;
import com.example.loggingTest.testJpa.MemberRepository;
import com.example.loggingTest.testJpa.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AgentController {
    private final MemberService memberService;

    @GetMapping("/thread/sleep")
    public String sleep() throws InterruptedException {
        log.info("running start");
        runningLoop();
        log.info("running end");

        List<Member> all = memberService.findAll();

        makeTemporaryString();

        return all.toString();
    }

    @GetMapping("/members/new")
    public String newMember() {
        Member member = new Member("new member");
        memberService.saveMember(member);

        makeTemporaryString();

        return "saved";
    }

    @GetMapping("/temp")
    public String temp() {
        return makeTemporaryString1();
    }

    private String makeTemporaryString1() {
        String temp = "temp_" + UUID.randomUUID();

        // random string, length = 2KB
        for (int i = 0; i < 100; i++) {
            temp += "temp_" + UUID.randomUUID();
        }

        return temp;
    }

    private void makeTemporaryString() {
        String temp = "temp_" + UUID.randomUUID();

        log.info("temp string: " + temp);
    }

    // private method that running using for loop
    private void runningLoop() {
        int cnt = 0;
        for (int i = 0; i < 100000000; i++) {
            cnt++;
        }
    }

}
