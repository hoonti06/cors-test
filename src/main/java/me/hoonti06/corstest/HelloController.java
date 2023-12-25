package me.hoonti06.corstest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/hi")
    public String getHi() {
        log.info("getHi() called");
        return "hi";
    }

    @PostMapping("/hi")
    public String postHi() {
        log.info("postHi() called");
        return "bye";
    }
}
