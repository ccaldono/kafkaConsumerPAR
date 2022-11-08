package co.edu.unicauca.kafkaconsumerpar.services;

import co.edu.unicauca.kafkaconsumerpar.models.Externo;

import java.util.List;

public interface IUsuario {
    public List<Externo> getUsuarios();
    public Boolean validar(int id);
}
