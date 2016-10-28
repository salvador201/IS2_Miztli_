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
@Table(name="Prueba")
public class Prueba {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_prueba")
    private long id_prueba;
   
    @Column(name = "nombre_prueba" )
    private String nombre_prueba;
    
    @Column(name = "descripcion_prueba"  )
    private String descripcion_prueba ;
    
    @Column(name = "habilitado"  )
    private int habilitado ;

    public Prueba(long id_prueba, String nombre_prueba, String descripcion_prueba, int habilitado) {
        this.id_prueba = id_prueba;
        this.nombre_prueba = nombre_prueba;
        this.descripcion_prueba = descripcion_prueba;
        this.habilitado = habilitado;
    }
    
    public Prueba(){
        
    }
    
    
    
   
    public long getId_prueba() {
        return id_prueba;
    }

    public void setId_prueba(long id_prueba) {
        this.id_prueba = id_prueba;
    }

    public String getNombre_prueba() {
        return nombre_prueba;
    }

    public void setNombre_prueba(String nombre_prueba) {
        this.nombre_prueba = nombre_prueba;
    }

    public String getDescripcion_prueba() {
        return descripcion_prueba;
    }

    public void setDescripcion_prueba(String descripcion_prueba) {
        this.descripcion_prueba = descripcion_prueba;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }

    
}
