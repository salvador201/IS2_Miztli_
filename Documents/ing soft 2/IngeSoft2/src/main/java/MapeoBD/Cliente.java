/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeoBD;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Marco
 */
@Entity
@Table(name="cliente")
public class Cliente {

   
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name = "id_cliente")
    private long id;
    
    @Column(name="correo")
    private String correo;
    
    @Column(name="password")
    private String pass;
    
    @Column(name="nombre_cliente")
    private String nombre;
    
    @Column(name="telefono_local")
    private String telefono;
    
    @Column(name="telefono_movil")
    private String telefonom;
    
    @Column(name="nombre_usuario")
    private String nombreu;
    
    @Column(name="area")
    private String area;
    
    @Column(name="puesto")
    private String puesto;
    
    @Column(name="nombre_empresa")
    private String n_empresa;
    
     public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefonom() {
        return telefonom;
    }

    public void setTelefonom(String telefonom) {
        this.telefonom = telefonom;
    }

    public String getNombreu() {
        return nombreu;
    }

    public void setNombreu(String nombreu) {
        this.nombreu = nombreu;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getN_empresa() {
        return n_empresa;
    }

    public void setN_empresa(String n_empresa) {
        this.n_empresa = n_empresa;
    }
}
