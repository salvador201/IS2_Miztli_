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
@Table(name="Pregunta")
public class Pregunta {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_pregunta")
    private long id_pregunta;
    
    @Column(name = "nombre_pregunta")
    private String nombre_pregunta;
    
    @Column(name = "habilitado")
    private int habilitado;

    public Pregunta(long id_pregunta, String nombre_pregunta, int habilitado) {
        this.id_pregunta = id_pregunta;
        this.nombre_pregunta = nombre_pregunta;
        this.habilitado = habilitado;
    }

    public Pregunta(String nombre_pregunta, int habilitado) {
        this.nombre_pregunta = nombre_pregunta;
        this.habilitado = habilitado;
    }
    
    public long getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(long id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public String getNombre_pregunta() {
        return nombre_pregunta;
    }

    public void setNombre_pregunta(String nombre_pregunta) {
        this.nombre_pregunta = nombre_pregunta;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }

        
    
}
