package co.edu.unicauca.kafkaconsumerpar.models;




public class Externo extends Usuario {

    private Integer ext_nit;

    private String ext_sector;

    private String ext_pais;

    private String ext_direccion;
    private String ext_telefono;
    private String ext_paginaweb;

    private String ext_tipousuarioexterno;

    public Externo() {
    }

    public Externo(Integer usu_id, String usu_email, String usu_nombre, String usu_apellido, String usu_estado, String usu_contrasena, String usu_contrasenanueva, Integer ext_nit, String ext_sector, String ext_pais, String ext_direccion, String ext_telefono, String ext_paginaweb, String ext_tipousuarioexterno) {
        super(usu_id, usu_email, usu_nombre, usu_apellido, usu_estado, usu_contrasena,usu_contrasenanueva);
        this.ext_nit = ext_nit;
        this.ext_sector = ext_sector;
        this.ext_pais = ext_pais;
        this.ext_direccion = ext_direccion;
        this.ext_telefono = ext_telefono;
        this.ext_paginaweb = ext_paginaweb;
        this.ext_tipousuarioexterno = ext_tipousuarioexterno;
    }

    public Integer getExt_nit() {
        return ext_nit;
    }

    public void setExt_nit(Integer ext_nit) {
        this.ext_nit = ext_nit;
    }

    public String getExt_sector() {
        return ext_sector;
    }

    public void setExt_sector(String ext_sector) {
        this.ext_sector = ext_sector;
    }

    public String getExt_pais() {
        return ext_pais;
    }

    public void setExt_pais(String ext_pais) {
        this.ext_pais = ext_pais;
    }

    public String getExt_direccion() {
        return ext_direccion;
    }

    public void setExt_direccion(String ext_direccion) {
        this.ext_direccion = ext_direccion;
    }

    public String getExt_telefono() {
        return ext_telefono;
    }

    public void setExt_telefono(String ext_telefono) {
        this.ext_telefono = ext_telefono;
    }

    public String getExt_paginaweb() { return ext_paginaweb; }

    public void setExt_paginaweb(String ext_paginaweb) { this.ext_paginaweb = ext_paginaweb; }

    public String getExt_tipousuarioexterno() {
        return ext_tipousuarioexterno;
    }

    public void setExt_tipousuarioexterno(String ext_tipousuarioexterno) {
        this.ext_tipousuarioexterno = ext_tipousuarioexterno;
    }
}
