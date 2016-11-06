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
@Table(name="prueba_empleado")
public class Prueba_empleado {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "empleado_id")
    private long empleado_id;
    
    @Column(name = "prueba_id")
    private long prueba_id;
    
    @Column(name = "puntaje_prueba")
    private double puntaje_prueba;
    
    @Column(name = "fecha_prueba")
    private Date fecha_prueba;

    public Prueba_empleado(long empleado_id, long prueba_id, double puntaje_prueba, Date fecha_prueba) {
        this.empleado_id = empleado_id;
        this.prueba_id = prueba_id;
        this.puntaje_prueba = puntaje_prueba;
        this.fecha_prueba = fecha_prueba;
    }

    public long getEmpleado_id() {
        return empleado_id;
    }

    public void setEmpleado_id(long empleado_id) {
        this.empleado_id = empleado_id;
    }

    public long getPrueba_id() {
        return prueba_id;
    }

    public void setPrueba_id(long prueba_id) {
        this.prueba_id = prueba_id;
    }

    public double getPuntaje_prueba() {
        return puntaje_prueba;
    }

    public void setPuntaje_prueba(double puntaje_prueba) {
        this.puntaje_prueba = puntaje_prueba;
    }

    public Date getFecha_prueba() {
        return fecha_prueba;
    }

    public void setFecha_prueba(Date fecha_prueba) {
        this.fecha_prueba = fecha_prueba;
    }
    
    
}
