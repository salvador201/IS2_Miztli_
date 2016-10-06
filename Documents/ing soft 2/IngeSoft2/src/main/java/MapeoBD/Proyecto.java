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
@Table(name="Proyecto")
public class Proyecto {
     @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_proyecto")
    private long id_proyecto;
     
    @Column(name = "cliente_id")
    private long cliente_id;
    
    @Column(name = "nombre_proyecto")
    private String nombre_proyecto;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "fecha_inicio")
    private Date fecha_inicio;
    
    @Column(name = "fecha_fin")
    private Date fecha_fin;
    
    @Column(name = "habilitado")
    private int habilitado;

    public Proyecto() {
    }

    
    public Proyecto(long cliente_id, String nombre_proyecto, String descripcion, Date fecha_inicio, Date fecha_fin, int habilitado) {
        this.cliente_id = cliente_id;
        this.nombre_proyecto = nombre_proyecto;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.habilitado = habilitado;
    }

    public Proyecto(long id_proyecto, long cliente_id, String nombre_proyecto, String descripcion, Date fecha_inicio, Date fecha_fin, int habilitado) {
        this.id_proyecto = id_proyecto;
        this.cliente_id = cliente_id;
        this.nombre_proyecto = nombre_proyecto;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.habilitado = habilitado;
    }

    
    
    public long getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(long id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(long cliente_id) {
        this.cliente_id = cliente_id;
    }


    public String getNombre_proyecto() {
        return nombre_proyecto;
    }

    public void setNombre_proyecto(String nombre_proyecto) {
        this.nombre_proyecto = nombre_proyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }
    
    
}
