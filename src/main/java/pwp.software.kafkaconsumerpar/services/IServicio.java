package pwp.software.kafkaconsumerpar.services;

import pwp.software.kafkaconsumerpar.models.Servicio;

public interface IServicio {

    public void setIdServicio(int idServicio);
    public int getIdServicio();
    public Servicio getServicio();
}
