package co.edu.unicauca.kafkaconsumerpar.config;

import co.edu.unicauca.kafkaconsumerpar.models.Estructura;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
    private String bootstrapAddress="localhost:9092";
    private String groupId="grupoConsumidor";
    public ConsumerFactory<String, Estructura> estructuraConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        props.put(
                ConsumerConfig.GROUP_ID_CONFIG,
                groupId);
        props.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        props.put(
                ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return new DefaultKafkaConsumerFactory<>(
                props,
                new StringDeserializer(),
                new JsonDeserializer<>(Estructura.class));
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Estructura>
    estructuraKafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, Estructura> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(estructuraConsumerFactory());
        factory.setBatchListener(true);
        factory.setAutoStartup(false);
        return factory;
    }
}