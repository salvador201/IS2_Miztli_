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
@Table(name="Pregunta_prueba")
public class Pregunta_prueba {
     @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "pregunta_id")
    private long pregunta_id;
    
    @Column(name = "prueba_id")
    private long prueba_id;
     
    @Column(name = "numero_pregunta")
    private int numero_pregunta;

    public Pregunta_prueba(long pregunta_id, long prueba_id, int numero_pregunta) {
        this.pregunta_id = pregunta_id;
        this.prueba_id = prueba_id;
        this.numero_pregunta = numero_pregunta;
    }

    public long getPregunta_id() {
        return pregunta_id;
    }

    public void setPregunta_id(long pregunta_id) {
        this.pregunta_id = pregunta_id;
    }

    public long getPrueba_id() {
        return prueba_id;
    }

    public void setPrueba_id(long prueba_id) {
        this.prueba_id = prueba_id;
    }

    public int getNumero_pregunta() {
        return numero_pregunta;
    }

    public void setNumero_pregunta(int numero_pregunta) {
        this.numero_pregunta = numero_pregunta;
    }
    
    
}
