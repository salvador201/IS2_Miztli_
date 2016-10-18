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
 * @author Salvador
 */
@Entity
@Table(name="Respuesta")
public class Respuesta {
     @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_respuesta")
    private long id_respuesta;
    
    @Column(name = "nombre_respuesta")
    private String nombre_respuesta;
    
    @Column(name = "habilitado")
    private int habilitado;

    public Respuesta(long id_respuesta, String nombre_respuesta, int habilitado) {
        this.id_respuesta = id_respuesta;
        this.nombre_respuesta = nombre_respuesta;
        this.habilitado = habilitado;
    }

    public Respuesta(String nombre_respuesta, int habilitado) {
        this.nombre_respuesta = nombre_respuesta;
        this.habilitado = habilitado;
    }

    

    public long getId_repuesta() {
        return id_respuesta;
    }

    public void setId_repuesta(long id_repuesta) {
        this.id_respuesta = id_repuesta;
    }

    public String getNombre_respuesta() {
        return nombre_respuesta;
    }

    public void setNombre_respuesta(String nombre_respuesta) {
        this.nombre_respuesta = nombre_respuesta;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }
    
    
    
}
