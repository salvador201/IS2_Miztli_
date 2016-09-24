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
@Table(name="grupo")
public class Grupo {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name = "idgrupo")
    private long id_grupo;

    public Set<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(Set<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
    @Column(name = "nombregrupo")
    private String nombre_grupo;
    
    @OneToMany(mappedBy = "grupo")
    private Set<Inscripcion> inscripciones = new HashSet<Inscripcion>();
    
    @ManyToOne
    @JoinColumn(name = "salongrupo")
    private Salon salon;
    
    @ManyToOne
    @JoinColumn(name = "carreragrupo")
    private Carrera carrera;
    
    
    @ManyToOne
    @JoinColumn(name = "profesorgrupo")
    private Profesor profesor;

    public long getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(long id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getNombre_grupo() {
        return nombre_grupo;
    }

    public void setNombre_grupo(String nombre_grupo) {
        this.nombre_grupo = nombre_grupo;
    }

}