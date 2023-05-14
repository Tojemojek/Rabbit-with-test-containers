package pl.kostrowski.rabbit;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final ProducerService producerService;
    @GetMapping("/test")
    public String test() {
        producerService.sendToRouting1("test message 1");
        producerService.sendToRouting2("test message 2");
        producerService.sendToRouting3("test message 3");
        producerService.sendToFanout("test message 4");
        return "test";
    }

}
