package pwp.software.kafkaconsumerpar.services;

import pwp.software.kafkaconsumerpar.models.Externo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UsuarioImpl implements IUsuario{
    @Override
    public List<Externo> getUsuarios() {
        String url= "http://localhost:8086/api/externos";
        System.out.println("Url: "+url);
        RestTemplate restTemplate= new RestTemplate();

        Externo[] externos = restTemplate.getForObject(url,Externo[].class);
        List<Externo> usuarios= Arrays.asList(externos);
        return usuarios;
    }

    public Boolean validar(int id)
    {
        List<Externo> usuarios= getUsuarios();

        for (int i = 0; i <usuarios.size(); i++) {
            if(usuarios.get(i).getExt_nit().equals(id)){return true;}
        }
        return false;
    }
}