/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiMapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="carrera")
public class Carrera {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idcarrera")
    private long idcarrera;
    
    @Column(name = "nombrecarrera")
    private String nombrecarrera;
    
    public long getId_carrera() {
        return idcarrera;
    }

    public void setId_carrera(long idcarrera) {
        this.idcarrera = idcarrera;
    }

    public String getNombre_carrera() {
        return nombrecarrera;
    }

    public void setNombre_carrera(String nombrecarrera) {
        this.nombrecarrera = nombrecarrera;
    }
}
