package co.edu.unicauca.kafkaconsumerpar.services;

import co.edu.unicauca.kafkaconsumerpar.models.Servicio;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("ServicioImpl")
public class ServicioImpl implements IServicio{
    private int idServicio;
    private String topic;
    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }
    public int getIdServicio() {
        return idServicio;
    }
    public Servicio getServicio(){
        String url= "http://localhost:8086/api/servicios/"+idServicio;
        System.out.println("Url: "+url);
        RestTemplate restTemplate= new RestTemplate();
        Servicio  servicio= restTemplate.getForObject(url, Servicio.class);
        return servicio;
    }
    public String obtenerTopic() {
        Servicio servicio= getServicio();
        System.out.println("Topic PAR: "+servicio.getSer_topic());
        topic =servicio.getSer_topic();
        return topic;
    }
}