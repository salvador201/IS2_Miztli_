/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeoBD;

import java.util.Date;
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
@Table(name="Empleado")
public class Empleado {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private long id_empleado;
    
    @Column(name = "cliente_id")
    private long cliente_id;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "horas_x_semana")
    private int horas_x_semana;
    
    @Column(name = "carrera")
    private String carrera;
    
    @Column(name = "estado_civil")
    private String estado_civil;
    
    @Column(name = "numero_hijos")
    private int numero_hijos;
    
    @Column(name = "fecha_nacimiento")
    private Date fecha_nacimiento;
    
    @Column(name = "antiguiedad")
    private String antiguiedad;
    
    @Column(name = "sueldo_mensual")
    private String sueldo_mensual;
    
    @Column(name = "sexo")
    private String sexo;
    
    @Column(name = "candidato")
    private String candidato;
    
    @Column(name = "habilitado")
    private int habilitado;

    public Empleado(long cliente_id, String direccion, int horas_x_semana, String carrera, String estado_civil, int numero_hijos, Date fecha_nacimiento, String antiguiedad, String sueldo_mensual, String sexo, String candidato, int habilitado) {
        this.cliente_id = cliente_id;
        this.direccion = direccion;
        this.horas_x_semana = horas_x_semana;
        this.carrera = carrera;
        this.estado_civil = estado_civil;
        this.numero_hijos = numero_hijos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.antiguiedad = antiguiedad;
        this.sueldo_mensual = sueldo_mensual;
        this.sexo = sexo;
        this.candidato = candidato;
        this.habilitado = habilitado;
    }

    public Empleado(long id_empleado, long cliente_id, String direccion, int horas_x_semana, String carrera, String estado_civil, int numero_hijos, Date fecha_nacimiento, String antiguiedad, String sueldo_mensual, String sexo, String candidato, int habilitado) {
        this.id_empleado = id_empleado;
        this.cliente_id = cliente_id;
        this.direccion = direccion;
        this.horas_x_semana = horas_x_semana;
        this.carrera = carrera;
        this.estado_civil = estado_civil;
        this.numero_hijos = numero_hijos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.antiguiedad = antiguiedad;
        this.sueldo_mensual = sueldo_mensual;
        this.sexo = sexo;
        this.candidato = candidato;
        this.habilitado = habilitado;
    }
    
    
    public long getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(long id_empleado) {
        this.id_empleado = id_empleado;
    }

    public long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getHoras_x_semana() {
        return horas_x_semana;
    }

    public void setHoras_x_semana(int horas_x_semana) {
        this.horas_x_semana = horas_x_semana;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public int getNumero_hijos() {
        return numero_hijos;
    }

    public void setNumero_hijos(int numero_hijos) {
        this.numero_hijos = numero_hijos;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getAntiguiedad() {
        return antiguiedad;
    }

    public void setAntiguiedad(String antiguiedad) {
        this.antiguiedad = antiguiedad;
    }

    public String getSueldo_mensual() {
        return sueldo_mensual;
    }

    public void setSueldo_mensual(String sueldo_mensual) {
        this.sueldo_mensual = sueldo_mensual;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCandidato() {
        return candidato;
    }

    public void setCandidato(String candidato) {
        this.candidato = candidato;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }
    
    
    
}
