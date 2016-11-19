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
@Table(name="Empleado_proyecto")
public class Empleado_proyecto {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "empleado_id")
    private long empleado_id;
    
    @Column(name = "proyecto_id")
    private long proyecto_id;
    
    @Column(name = "habilitado")
    private int habilitado;
    
    public Empleado_proyecto(){
        
    }

    public Empleado_proyecto(long empleado_id, long proyecto_id, int habilitado) {
        this.empleado_id = empleado_id;
        this.proyecto_id = proyecto_id;
        this.habilitado = habilitado;
    }

    public long getEmpleado_id() {
        return empleado_id;
    }

    public void setEmpleado_id(long empleado_id) {
        this.empleado_id = empleado_id;
    }

    public long getProyecto_id() {
        return proyecto_id;
    }

    public void setProyecto_id(long proyecto_id) {
        this.proyecto_id = proyecto_id;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }
    
    
}
