package co.edu.unicauca.kafkaconsumerpar.services;

import co.edu.unicauca.kafkaconsumerpar.models.Estructura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class KafkaConsumerImpl {
    private List<Estructura> estructuras= new ArrayList<>();

    @KafkaListener(id="listener1",
            topics = "#{ServicioImpl.obtenerTopic()}",
            containerFactory = "estructuraKafkaListenerContainerFactory",autoStartup = "false")
    public void estructuraListener(Estructura estructura) {
            System.out.println("Ha llegado:" + estructura.getEst_contenido());
            estructuras.add(estructura);
    }
    public List<Estructura> getInformacion() {
        return estructuras;
    }
}