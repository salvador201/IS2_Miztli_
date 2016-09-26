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
    @Id 
    @Column(name = "ID_Cliente")
    private long ID_Cliente;
    
    @Column(name = "Correo")
    private String Correo;
    
    @Column(name = "Password")
    private String Password;
    
    @Column(name = "Nombre_Cliente")
    private String Nombre_Cliente;
    
    @Column(name = "Telefono_Local")
    private String Telefono_Local;
    
    @Column(name = "Telefono_Movil")
    private String Telefono_Movil;
    
    @Column(name = "Nombre_Usuario")
    private String Nombre_Usuario;
    
    @Column(name = "Area")
    private String Area;
    
    @Column(name = "Puesto")
    private String Puesto;
    
    @Column(name = "Nombre_Empresa")
    private String Nombre_Empresa;

    public long getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(long ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public void setNombre_Cliente(String Nombre_Cliente) {
        this.Nombre_Cliente = Nombre_Cliente;
    }

    public String getTelefono_Local() {
        return Telefono_Local;
    }

    public void setTelefono_Local(String Telefono_Local) {
        this.Telefono_Local = Telefono_Local;
    }

    public String getTelefono_Movil() {
        return Telefono_Movil;
    }

    public void setTelefono_Movil(String Telefono_Movil) {
        this.Telefono_Movil = Telefono_Movil;
    }

    public String getNombre_Usuario() {
        return Nombre_Usuario;
    }

    public void setNombre_Usuario(String Nombre_Usuario) {
        this.Nombre_Usuario = Nombre_Usuario;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }

    public String getPuesto() {
        return Puesto;
    }

    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
    }

    public String getNombre_Empresa() {
        return Nombre_Empresa;
    }

    public void setNombre_Empresa(String Nombre_Empresa) {
        this.Nombre_Empresa = Nombre_Empresa;
    }
    
    
    
    
    
}
