/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapeoBD.Alumno;
import MapeoBD.Grupo;
import MapeoBD.Salon;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Marco
 */
public interface AlumnoDAOint {
    
     public List<Alumno> getAlumnos();
     public List<Grupo> getGrupos(String nombre);
     public List<Salon> getSalones(Long id);
     
}
