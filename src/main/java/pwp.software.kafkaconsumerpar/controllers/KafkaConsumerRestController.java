package pwp.software.kafkaconsumerpar.controllers;

import pwp.software.kafkaconsumerpar.models.Estructura;
import pwp.software.kafkaconsumerpar.services.IServicio;
import pwp.software.kafkaconsumerpar.services.IUsuario;
import pwp.software.kafkaconsumerpar.services.KafkaConsumerImpl;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

@CrossOrigin(origins = "http://localhost:49376",  maxAge = 3600)
@RestController
@RequestMapping("/api")
public class KafkaConsumerRestController {

    @Autowired
    private IUsuario usuario;
      @Autowired
    private KafkaConsumerImpl consumer;
    @Autowired
    private IServicio objServicio;
    List<Estructura> estructuras= new ArrayList<>();

    @GetMapping(value = "kafkaconsumerpar/{idServicio}/{nit}")
    public ResponseEntity<?> servicioConsumidor(@PathVariable("idServicio") Integer idServicio,@PathVariable("nit") Integer nit){

        Map<String,Object> response = new HashMap<>();

        objServicio.setIdServicio(idServicio);

        if(usuario.validar(nit)) {

        ContainerProperties containerProps = new ContainerProperties(objServicio.getServicio().getSer_topic());

        final CountDownLatch latch = new CountDownLatch(4);
        containerProps.setMessageListener(new MessageListener<String, Estructura>() {
            @Override
            public void onMessage(ConsumerRecord<String, Estructura> message) {
                System.out.println("Este el mensaje: "+ message.value().getEst_contenido());
                System.out.println("Topic: "+message.topic());
                estructuras.add(message.value());
                latch.countDown();
            }
        });
            KafkaMessageListenerContainer<String, Estructura> container = consumer.createContainer(containerProps);
            container.setBeanName("testAuto");
            container.start();

            response.put("mensaje", "El consumidor se suscribio con exito");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

        } else{
            response.put("mensaje", "No se encuentra registrado" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.FOUND);
        }
    }

    @GetMapping("kafkaconsumerpar/mensajes")
    public List<Estructura> listarTodosMensajes() {
        System.out.println("Listar todos los mensajes");
        return estructuras;
    }
}