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
@Table(name="Respuesta_empleado")
public class Respuesta_empleado {
     @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "pregunta_respuesta_id")
    private long pregunta_respuesta_id;
    
     @Column(name = "empleado_id")
    private long empleado_id;
     
    @Column(name = "pregunta_id")
    private long pregunta_id;
    
    @Column(name = "respuesta_id")
    private long respuesta_id;

    public Respuesta_empleado(long pregunta_respuesta_id, long empleado_id, long pregunta_id, long respuesta_id) {
        this.pregunta_respuesta_id = pregunta_respuesta_id;
        this.empleado_id = empleado_id;
        this.pregunta_id = pregunta_id;
        this.respuesta_id = respuesta_id;
    }

    public long getPregunta_respuesta_id() {
        return pregunta_respuesta_id;
    }

    public void setPregunta_respuesta_id(long pregunta_respuesta_id) {
        this.pregunta_respuesta_id = pregunta_respuesta_id;
    }

    public long getEmpleado_id() {
        return empleado_id;
    }

    public void setEmpleado_id(long empleado_id) {
        this.empleado_id = empleado_id;
    }

    public long getPregunta_id() {
        return pregunta_id;
    }

    public void setPregunta_id(long pregunta_id) {
        this.pregunta_id = pregunta_id;
    }

    public long getRespuesta_id() {
        return respuesta_id;
    }

    public void setRespuesta_id(long respuesta_id) {
        this.respuesta_id = respuesta_id;
    }
    
    
}
