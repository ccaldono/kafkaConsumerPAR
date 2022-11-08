package co.edu.unicauca.kafkaconsumerpar.services;

import co.edu.unicauca.kafkaconsumerpar.models.Servicio;

public interface IServicio {

    public void setIdServicio(int idServicio);
    public int getIdServicio();
    public Servicio getServicio();
    public String obtenerTopic();
}
