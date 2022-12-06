package pwp.software.kafkaconsumerpar.services;

import pwp.software.kafkaconsumerpar.models.Externo;

import java.util.List;

public interface IUsuario {
    public List<Externo> getUsuarios();
    public Boolean validar(int id);
}
