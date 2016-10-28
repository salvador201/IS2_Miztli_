/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeoBD;

import java.util.Date;
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
@Table(name="Prueba_Proyecto")
public class Prueba_Proyecto {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_prueba_proyecto")
    private long id_prueba_proyecto;
    
    @Column(name = "prueba_id")
    private long prueba_id;
    
    @Column(name = "proyecto_id")
    private long proyecto_id;
    
    @Column(name = "puntaje_prueba")
    private int puntaje_prueba;
    
    @Column(name = "fecha_creacion")
    private Date fecha_creacion;
    
    @Column(name = "habilitado")
    private int habilitado;
    
    Prueba_Proyecto(){
        
    }

    public Prueba_Proyecto(long id_prueba_proyecto, long prueba_id, long proyecto_id, int puntaje_prueba, Date fecha_creacion, int habilitado) {
        this.id_prueba_proyecto = id_prueba_proyecto;
        this.prueba_id = prueba_id;
        this.proyecto_id = proyecto_id;
        this.puntaje_prueba = puntaje_prueba;
        this.fecha_creacion = fecha_creacion;
        this.habilitado = habilitado;
    }

    public long getId_prueba_proyecto() {
        return id_prueba_proyecto;
    }

    public void setId_prueba_proyecto(long id_prueba_proyecto) {
        this.id_prueba_proyecto = id_prueba_proyecto;
    }

    public long getPrueba_id() {
        return prueba_id;
    }

    public void setPrueba_id(long prueba_id) {
        this.prueba_id = prueba_id;
    }

    public long getProyecto_id() {
        return proyecto_id;
    }

    public void setProyecto_id(long proyecto_id) {
        this.proyecto_id = proyecto_id;
    }

    public int getPuntaje_prueba() {
        return puntaje_prueba;
    }

    public void setPuntaje_prueba(int puntaje_prueba) {
        this.puntaje_prueba = puntaje_prueba;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }
    
    
    
    
}
