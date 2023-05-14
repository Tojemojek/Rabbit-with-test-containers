package pl.kostrowski.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Listener {
    @RabbitListener(queues = "test-queue-1")
    public void processMessageQueue1(String content) {
        log.info("Received message from test-queue-1: {}", content);
    }

    @RabbitListener(queues = "test-queue-2")
    public void processMessageQueue2(String content) {
        log.info("Received message from test-queue-2: {}", content);
    }

    @RabbitListener(queues = "test-queue-3")
    public void processMessageQueue3(String content) {
        log.info("Received message from test-queue-3: {}", content);
    }

}
