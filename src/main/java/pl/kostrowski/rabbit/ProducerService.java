package pl.kostrowski.rabbit;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerService {

    private final RabbitMessagingTemplate template;

    public void sendToRouting1(String message) {
        template.convertAndSend("test-exchange", "test-routing-1", message);
    }
    public void sendToRouting2(String message) {
        template.convertAndSend("test-exchange", "test-routing-2", message);
    }

    public void sendToRouting3(String message) {
        template.convertAndSend("test-exchange", "test-routing-3", message);
    }

    public void sendToFanout(String message) {
        template.convertAndSend("test-exchange-2","", message);
    }

}
