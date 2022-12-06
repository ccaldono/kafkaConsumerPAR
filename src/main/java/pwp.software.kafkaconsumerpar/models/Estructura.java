package pwp.software.kafkaconsumerpar.models;

public class Estructura {
    private int nit;
    private String est_contenido;


    public Estructura() {
    }

    public Estructura(int nit, String est_contenido) {
        this.nit = nit;
        this.est_contenido = est_contenido;
    }

    public int getNit() {
        return nit;
    }
    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getEst_contenido() {
        return est_contenido;
    }

    public void setEst_contenido(String est_contenido) {
        this.est_contenido = est_contenido;
    }
}