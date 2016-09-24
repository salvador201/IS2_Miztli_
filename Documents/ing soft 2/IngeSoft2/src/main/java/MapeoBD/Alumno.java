/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeoBD;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Marco
 */
@Entity
@Table(name="alumno")
public class Alumno {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name = "idalumno")
    private long idalumno;
    
    @Column(name = "nombrealumno")
    private String nombrealumno;
    
    @Column(name = "generacionalumno")
    private String generacionalumno;
    
    
    @ManyToOne
    @JoinColumn(name = "carreraalumno")
    private Carrera carrera;
    
    @OneToMany(mappedBy = "alumno")
    private Set<Inscripcion> inscripciones = new HashSet<Inscripcion>();

    public long getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(long idalumno) {
        this.idalumno = idalumno;
    }

    public String getNombrealumno() {
        return nombrealumno;
    }

    public void setNombrealumno(String nombrealumno) {
        this.nombrealumno = nombrealumno;
    }

    public String getGeneracionalumno() {
        return generacionalumno;
    }

    public void setGeneracionalumno(String generacionalumno) {
        this.generacionalumno = generacionalumno;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Set<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(Set<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

   
    
    
    
}
