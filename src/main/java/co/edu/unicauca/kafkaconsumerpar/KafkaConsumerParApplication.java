package co.edu.unicauca.kafkaconsumerpar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaConsumerParApplication {

    public static void main(String[] args) {
       SpringApplication.run(KafkaConsumerParApplication.class, args);
    }

    /*
    @Bean(name = KafkaListenerConfigUtils.KAFKA_LISTENER_ENDPOINT_REGISTRY_BEAN_NAME)
    public KafkaListenerEndpointRegistry defaultKafkaListenerEndpointRegistry() {
        return new KafkaListenerEndpointRegistry();
    }*/
}