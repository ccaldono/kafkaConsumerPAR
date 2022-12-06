package pwp.software.kafkaconsumerpar.services;

import pwp.software.kafkaconsumerpar.models.Estructura;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class KafkaConsumerImpl {


    private static String groupId="grupoConsumidor";
    public KafkaMessageListenerContainer<String, Estructura> createContainer(ContainerProperties containerProps) {
        Map<String, Object> props = consumerProps();
        DefaultKafkaConsumerFactory<String, Estructura> cf = new DefaultKafkaConsumerFactory<String, Estructura>(props,new StringDeserializer(),
                new JsonDeserializer<>(Estructura.class));
        KafkaMessageListenerContainer<String, Estructura> container = new KafkaMessageListenerContainer<>(cf, containerProps);
        return container;
    }

    public Map<String, Object> consumerProps() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return props;
    }


    /*
    private List<Estructura> estructuras= new ArrayList<>();


    @Autowired
    KafkaConsumerProperties kafkaConsumerProperties;*/

/*


    @KafkaListener(id="listener1",
            topics = "#{ServicioImpl.getServicio().getSer_topic()}",
            containerFactory = "estructuraKafkaListenerContainerFactory",autoStartup = "false")
    public void estructuraListener(Estructura estructura) {
        System.out.println("Ha llegado:" + estructura.getEst_contenido());
        estructuras.add(estructura);
    }
    public List<Estructura> getInformacion() {
        return estructuras;
    }*/
}