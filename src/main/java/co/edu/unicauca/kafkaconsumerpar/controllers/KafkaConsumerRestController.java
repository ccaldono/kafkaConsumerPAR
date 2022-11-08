package co.edu.unicauca.kafkaconsumerpar.controllers;

import co.edu.unicauca.kafkaconsumerpar.models.Estructura;
import co.edu.unicauca.kafkaconsumerpar.services.IUsuario;
import co.edu.unicauca.kafkaconsumerpar.services.KafkaConsumerImpl;
import co.edu.unicauca.kafkaconsumerpar.services.ServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:49376",  maxAge = 3600)
@RestController
@RequestMapping("/api")
public class KafkaConsumerRestController {
    @Autowired
    private ApplicationContext context;
    @Autowired
    private IUsuario usuario;
    @Autowired
    private KafkaListenerEndpointRegistry KafkaListenerEndpointRegistry;

    @GetMapping(value = "kafkaconsumerpar/{idServicio}/{nit}")
    public ResponseEntity<?> servicioConsumidor(@PathVariable("idServicio") Integer idServicio,@PathVariable("nit") Integer nit){

        Map<String,Object> response = new HashMap<>();

        System.out.println("Entro al servicio consumidor con id: "+ idServicio);
        System.out.println("Nit: "+nit);

        ServicioImpl ServicioImpl= context.getBean( ServicioImpl.class);
        ServicioImpl.setIdServicio(idServicio);
        ServicioImpl.obtenerTopic();
        System.out.println("Este es id servicio: "+ServicioImpl.getIdServicio());
        System.out.println("Este es el topic: "+ServicioImpl.obtenerTopic());
        System.out.println("Este es el tamano:"+usuario.getUsuarios().size());

        if(usuario.validar(nit)){
            KafkaConsumerImpl obj=context.getBean(KafkaConsumerImpl.class);

            starListener();
            obj.getInformacion();

            response.put("mensaje", "conexion exitosa" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
        else{
            response.put("mensaje", "No se encuentra registrado" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.FOUND);
        }
    }
    public void starListener(){
        KafkaListenerEndpointRegistry.getListenerContainer("listener1").start();
    }

    @GetMapping("kafkaconsumerpar/mensajes")
    public List<Estructura> listarTodosMensajes() {
        System.out.println("Listar todos los mensajes");
        KafkaConsumerImpl obj=context.getBean(KafkaConsumerImpl.class);
        return obj.getInformacion();
    }
}