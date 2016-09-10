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
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 *
 * @author Salvador
 */
@Entity
@Table(name="alumno")
public class Alumno {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name ="idalumno")
    private long idalumno;
    
    @Column(name = "nombrealumno")
    private String nombrealumno;
    
    @Column(name = "generacionalumno")
    private String generacionalumno;
    
   
    @Column(name ="carreraalumno")
    private int carreraalumno;

    public long getId_alumno() {
        return idalumno;
    }

    public void setId_alumno(long idalumno) {
        this.idalumno = idalumno;
    }

    public String getNombre_alumno() {
        return nombrealumno;
    }

    public void setNombre_alumno(String nombrealumno) {
        this.nombrealumno = nombrealumno;
    }

    public String getGeneracion_alumno() {
        return generacionalumno;
    }

    public void setGeneracion_alumno(String generacionalumno) {
        this.generacionalumno = generacionalumno;
    }

    public int getCarrera_alumno() {
        return carreraalumno;
    }

    public void setCarrera_alumno(int carreraalumno) {
        this.carreraalumno = carreraalumno;
    }
    
}
