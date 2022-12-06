package pwp.software.kafkaconsumerpar.services;

import pwp.software.kafkaconsumerpar.models.Servicio;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("ServicioImpl")
public class ServicioImpl implements IServicio{
    private int idServicio;


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
}