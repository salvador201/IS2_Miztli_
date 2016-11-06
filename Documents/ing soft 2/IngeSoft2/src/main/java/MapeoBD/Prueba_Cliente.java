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
@Table(name="prueba_cliente")
public class Prueba_Cliente {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "prueba_id")
    private long prueba_id;
    
    @Column(name = "cliente_id")
    private long cliente_id;
    
     @Column(name = "habilitado"  )
    private int habilitado ;

    public Prueba_Cliente(long prueba_id, long cliente_id, int habilitado) {
        this.prueba_id = prueba_id;
        this.cliente_id = cliente_id;
        this.habilitado = habilitado;
    }

    public long getPrueba_id() {
        return prueba_id;
    }

    public void setPrueba_id(long prueba_id) {
        this.prueba_id = prueba_id;
    }

    public long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }

    
}
