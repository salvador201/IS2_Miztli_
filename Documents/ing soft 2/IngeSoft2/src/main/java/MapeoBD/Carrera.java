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
@Table(name="carrera")
public class Carrera {
     @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
     
     @Column(name = "idcarrera")
     private long id_carrera;
     
     @Column(name = "nombrecarrera")
     private String nombre_carrera;
     
@OneToMany
@JoinColumn(name = "idcarrera")
private Set<Alumno> alumnos = new HashSet<Alumno>();


@OneToMany(mappedBy="carrera")
private Set<Grupo> grupos = new HashSet<Grupo>();

    public long getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(long id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getNombre_carrera() {
        return nombre_carrera;
    }

    public void setNombre_carrera(String nombre_carrera) {
        this.nombre_carrera = nombre_carrera;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Set<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(Set<Grupo> grupos) {
        this.grupos = grupos;
    }
     
     
     
    
}
