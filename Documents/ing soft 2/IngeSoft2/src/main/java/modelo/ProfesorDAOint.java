/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapeoBD.Alumno;
import java.util.List;

/**
 *
 * @author Marco
 */
public interface ProfesorDAOint {
    
     public List<Alumno> getAlumnos(Long id);   
    
}
