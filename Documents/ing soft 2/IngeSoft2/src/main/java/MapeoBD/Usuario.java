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
@Table(name="usuario")
public class Usuario {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private long id_usuario;
    @Column(name = "login_usuario")
    private String login_usuario;
    @Column(name = "password_usuario")
    private String password_usuario;
    @Column(name = "rol_usuario")
    private String rol_usuario;

    public Usuario(long id_usuario, String login_usuario, String password_usuario, String rol_usuario) {
        this.id_usuario = id_usuario;
        this.login_usuario = login_usuario;
        this.password_usuario = password_usuario;
        this.rol_usuario = rol_usuario;
    }

    public Usuario(String login_usuario, String password_usuario, String rol_usuario) {
        this.login_usuario = login_usuario;
        this.password_usuario = password_usuario;
        this.rol_usuario = rol_usuario;
    }
    
    
    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_cliente(long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getLogin_usuario() {
        return login_usuario;
    }

    public void setLogin_usuario(String login_usuario) {
        this.login_usuario = login_usuario;
    }

    public String getPassword_usuario() {
        return password_usuario;
    }

    public void setPassword_usuario(String password_usuario) {
        this.password_usuario = password_usuario;
    }

    public String getRol_usuario() {
        return rol_usuario;
    }

    public void setRol_usuario(String rol_usuario) {
        this.rol_usuario = rol_usuario;
    }
    
    
    
}
