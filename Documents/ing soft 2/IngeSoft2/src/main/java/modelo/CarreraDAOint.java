/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapeoBD.Grupo;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Marco
 */
public interface CarreraDAOint {
    public Set<Grupo> getGrupos(String carrera);
    
}
