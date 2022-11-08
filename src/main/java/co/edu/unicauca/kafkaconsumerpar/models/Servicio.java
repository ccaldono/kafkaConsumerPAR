package co.edu.unicauca.kafkaconsumerpar.models;

public class Servicio {
    private Integer ser_id;
    private String ser_nombre;
    private String ser_tipoServicio;
    private String ser_broker;
    private String ser_estado;
    private String ser_topic;
    private String ser_descripcion;
    //private Plataforma ser_objPlataforma;


    public Servicio() {
       // this.ser_topic = "claudia_topic";
    }

    public Servicio(Integer ser_id, String ser_nombre, String ser_tipoServicio, String ser_broker, String ser_estado, String ser_topic, String ser_descripcion) {
        this.ser_id = ser_id;
        this.ser_nombre = ser_nombre;
        this.ser_tipoServicio = ser_tipoServicio;
        this.ser_broker = ser_broker;
        this.ser_estado = ser_estado;
        this.ser_topic = ser_topic;
        this.ser_descripcion = ser_descripcion;
        //this.ser_objPlataforma = ser_objPlataforma;
    }

    public Integer getSer_id() {
        return ser_id;
    }

    public void setSer_id(Integer ser_id) {
        this.ser_id = ser_id;
    }

    public String getSer_nombre() {
        return ser_nombre;
    }

    public void setSer_nombre(String ser_nombre) {
        this.ser_nombre = ser_nombre;
    }

    public String getSer_tipoServicio() {
        return ser_tipoServicio;
    }

    public void setSer_tipoServicio(String ser_tipoServicio) {
        this.ser_tipoServicio = ser_tipoServicio;
    }

    public String getSer_broker() {
        return ser_broker;
    }

    public void setSer_broker(String ser_broker) {
        this.ser_broker = ser_broker;
    }

    public String getSer_estado() {
        return ser_estado;
    }

    public void setSer_estado(String ser_estado) {
        this.ser_estado = ser_estado;
    }

    public String getSer_topic() {
        if(ser_topic==null)
            return "";
        else
            return ser_topic;
    }

    public void setSer_topic(String ser_topic) {
        this.ser_topic = ser_topic;
    }

    public String getSer_descripcion() {
        return ser_descripcion;
    }

    public void setSer_descripcion(String ser_descripcion) {
        this.ser_descripcion = ser_descripcion;
    }

    /*
    public Plataforma getSer_objPlataforma() {
        return ser_objPlataforma;
    }

   // public void setSer_objPlataforma(Plataforma ser_objPlataforma) {
        this.ser_objPlataforma = ser_objPlataforma;
    }*/
}