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
@Table(name="salon")
public class Salon {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name = "idsalon")
    private long id_salon;
    
    @Column(name = "nombresalon")
    private String nombre_salon;
    
    @Column(name = "edificiosalon")
    private String edificio_salon;

    public Set<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(Set<Grupo> grupos) {
        this.grupos = grupos;
    }
    
    @OneToMany
    @JoinColumn(name = "salongrupo")
    private Set<Grupo> grupos = new HashSet<Grupo>();

    public long getId_salon() {
        return id_salon;
    }

    public void setId_salon(long id_salon) {
        this.id_salon = id_salon;
    }

    public String getNombre_salon() {
        return nombre_salon;
    }

    public void setNombre_salon(String nombre_salon) {
        this.nombre_salon = nombre_salon;
    }

    public String getEdificio_salon() {
        return edificio_salon;
    }

    public void setEdificio_salon(String edificio_salon) {
        this.edificio_salon = edificio_salon;
    }
    
    
    
}
