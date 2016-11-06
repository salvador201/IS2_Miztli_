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
@Table(name="Pregunta_respuesta")
public class Pregunta_respuesta {
     @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_pregunta_respuesta")
    private long id_pregunta_respuesta;
     
    @Column(name = "pregunta_id")
    private long pregunta_id;
    
    @Column(name = "respuesta_id")
    private long respuesta_id;
    
    @Column(name = "puntaje_respuesta")
    private long puntaje_respuesta;

    public Pregunta_respuesta(long id_pregunta_respuesta, long pregunta_id, long respuesta_id, long puntaje_respuesta) {
        this.id_pregunta_respuesta = id_pregunta_respuesta;
        this.pregunta_id = pregunta_id;
        this.respuesta_id = respuesta_id;
        this.puntaje_respuesta = puntaje_respuesta;
    }

    public long getId_pregunta_respuesta() {
        return id_pregunta_respuesta;
    }

    public void setId_pregunta_respuesta(long id_pregunta_respuesta) {
        this.id_pregunta_respuesta = id_pregunta_respuesta;
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

    public long getPuntaje_respuesta() {
        return puntaje_respuesta;
    }

    public void setPuntaje_respuesta(long puntaje_respuesta) {
        this.puntaje_respuesta = puntaje_respuesta;
    }
    
    
    
    
    
}
