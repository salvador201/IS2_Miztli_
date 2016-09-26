/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import MapeoBD.Cliente;


/**
 *
 * @author Salvador
 */
public interface ClienteDAO {
    public void crearCliente(Cliente nuevo);
    
    public void modificarCliente(long id_Cliente,Cliente cambios);
    
    public void eliminarCliente(long id_Cliente);
    
    public Cliente consultaCliente(long id_Cliente);
}
