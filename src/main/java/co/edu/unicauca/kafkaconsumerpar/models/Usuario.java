package co.edu.unicauca.kafkaconsumerpar.models;


public class Usuario {

    private Integer usu_id;
    private String usu_email;

    private String usu_nombre;

    private String usu_apellido;

    private String usu_estado;

    private String usu_contrasena;


    private String usu_contrasenanueva;


    public Usuario() {
    }

    public Usuario(Integer usu_id, String usu_email, String usu_nombre, String usu_apellido, String usu_estado, String usu_contrasena, String usu_contrasenanueva) {
        this.usu_id = usu_id;
        this.usu_email = usu_email;
        this.usu_nombre = usu_nombre;
        this.usu_apellido = usu_apellido;
        this.usu_estado = usu_estado;
        this.usu_contrasena = usu_contrasena;
        this.usu_contrasenanueva = usu_contrasenanueva;
    }

    public Integer getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(Integer usu_id) {
        this.usu_id = usu_id;
    }

    public String getUsu_email() {
        return usu_email;
    }

    public void setUsu_email(String usu_email) {
        this.usu_email = usu_email;
    }

    public String getUsu_nombre() {
        return usu_nombre;
    }

    public void setUsu_nombre(String usu_nombre) {
        this.usu_nombre = usu_nombre;
    }

    public String getUsu_apellido() {
        return usu_apellido;
    }

    public void setUsu_apellido(String usu_apellido) {
        this.usu_apellido =usu_apellido;
    }

    public String getUsu_estado() {
        return usu_estado;
    }

    public void setUsu_estado(String usu_estado) {
        this.usu_estado = usu_estado;
    }

    public String getUsu_contrasena() {
        return usu_contrasena;
    }

    public void setUsu_contrasena(String usu_contrasena) {
        this.usu_contrasena = usu_contrasena;
    }

    public String getUsu_contrasenanueva() {
        return usu_contrasenanueva;
    }

    public void setUsu_contrasenanueva(String usu_contrasenanueva) {
        this.usu_contrasenanueva = usu_contrasenanueva;
    }
}