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
@Table(name="Cliente")
public class Cliente {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private long id_cliente;
    
    @Column(name = "usuario_id")
    private long usuario_id;
    
    @Column(name = "correo")
    private String correo;
    
    @Column(name = "nombre_cliente")
    private String nombre_cliente;
    
    @Column(name = "apellido_paterno_cliente")
    private String apellido_paterno_cliente;
    
    @Column(name = "apellido_materno_cliente")
    private String apellido_materno_cliente;
    
    @Column(name = "telefono_local")
    private String telefono_local;
    
    @Column(name = "telefono_movil")
    private String telefono_movil;
    
    @Column(name = "area")
    private String area;
    
    @Column(name = "puesto")
    private String puesto;
    
    @Column(name = "nombre_empresa")
    private String nombre_empresa;
    
    @Column(name = "habilitado")
    private int habilitado;

    public Cliente(long usuario_id, String correo, String nombre_cliente, String apellido_paterno_cliente, String apellido_materno_cliente, String telefono_local, String telefono_movil, String area, String puesto, String nombre_empresa, int habilitado) {
        this.usuario_id = usuario_id;
        this.correo = correo;
        this.nombre_cliente = nombre_cliente;
        this.apellido_paterno_cliente = apellido_paterno_cliente;
        this.apellido_materno_cliente = apellido_materno_cliente;
        this.telefono_local = telefono_local;
        this.telefono_movil = telefono_movil;
        this.area = area;
        this.puesto = puesto;
        this.nombre_empresa = nombre_empresa;
        this.habilitado = habilitado;
    }

    

    
    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApellido_paterno_cliente() {
        return apellido_paterno_cliente;
    }

    public void setApellido_paterno_cliente(String apellido_paterno_cliente) {
        this.apellido_paterno_cliente = apellido_paterno_cliente;
    }

    public String getApellido_materno_cliente() {
        return apellido_materno_cliente;
    }

    public void setApellido_materno_cliente(String apellido_materno_cliente) {
        this.apellido_materno_cliente = apellido_materno_cliente;
    }

    public String getTelefono_local() {
        return telefono_local;
    }

    public void setTelefono_local(String telefono_local) {
        this.telefono_local = telefono_local;
    }

    public String getTelefono_movil() {
        return telefono_movil;
    }

    public void setTelefono_movil(String telefono_movil) {
        this.telefono_movil = telefono_movil;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }
    
        
}
