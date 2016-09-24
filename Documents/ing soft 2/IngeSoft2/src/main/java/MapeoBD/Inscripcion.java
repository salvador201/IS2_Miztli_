/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeoBD;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 *
 * @author Marco
 */
@Entity
@Table(name="inscripcion")
public class Inscripcion implements Serializable {
     @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
     @ManyToOne
     @JoinColumn(name="idgrupo")
     private Grupo grupo;
      
     @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
     @ManyToOne
     @JoinColumn(name="idalumno")
     private Alumno alumno;
    
    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    
}
