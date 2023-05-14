package pl.kostrowski.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

import java.util.HashMap;

@Slf4j
public class TestContainerConfig {
    @Container
    private static final RabbitMQContainer container = configureContainer();

    private static RabbitMQContainer configureContainer() {
        RabbitMQContainer rabbitMQContainer = new RabbitMQContainer(DockerImageName.parse("rabbitmq:3.11.15-management-alpine"))
                .withExchange("test-exchange", ExchangeTypes.DIRECT)
                .withExchange("test-exchange-2", ExchangeTypes.FANOUT)
                .withQueue("test-queue-1")
                .withQueue("test-queue-2")
                .withQueue("test-queue-3")
                .withBinding("test-exchange", "test-queue-1",  new HashMap<>(), "test-routing-1", "queue")
                .withBinding("test-exchange", "test-queue-2",  new HashMap<>(), "test-routing-2", "queue")
                .withBinding("test-exchange", "test-queue-3",  new HashMap<>(), "test-routing-3", "queue")
                .withBinding("test-exchange", "test-queue-3",  new HashMap<>(), "test-routing-3", "queue")
                .withBinding("test-exchange-2", "test-queue-1",  new HashMap<>(), "", "queue")
                .withBinding("test-exchange-2", "test-queue-2",  new HashMap<>(), "", "queue")
                .withBinding("test-exchange-2", "test-queue-3",  new HashMap<>(), "", "queue");

        rabbitMQContainer.start();
        return rabbitMQContainer;
    }
    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.rabbitmq.host", container::getHost);
        registry.add("spring.rabbitmq.port", () -> container.getMappedPort(5672));
        registry.add("spring.rabbitmq.username", () -> "guest");
        registry.add("spring.rabbitmq.password", () -> "guest");
        log.info("RabbitMQ console available at: {}", container.getHttpUrl());
    }
}
