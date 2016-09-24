/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeoBD;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Marco
 */
@Entity
@Table(name="profesor")
public class Profesor {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name = "idprofesor")
    private long id_profesor;
    
    @Column(name = "nombreprofesor")
    private String nombre_profesor;

    public Set<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(Set<Grupo> grupos) {
        this.grupos = grupos;
    }
    
    @Column(name = "tipoprofesor")
    private String tipo_profesor;
    
    @OneToMany
    @JoinColumn(name = "idprofesor")
    private Set<Grupo> grupos = new HashSet<Grupo>();

    public long getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(long id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getNombre_profesor() {
        return nombre_profesor;
    }

    public void setNombre_profesor(String nombre_profesor) {
        this.nombre_profesor = nombre_profesor;
    }

    public String getTipo_profesor() {
        return tipo_profesor;
    }

    public void setTipo_profesor(String tipo_profesor) {
        this.tipo_profesor = tipo_profesor;
    }
    
    
}
